package com.pluralsight.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class DealershipFileManager
{
    private final String LOG_DIRECTORY_PATH = "files";
    private String filePath;

    public DealershipFileManager(String fileName)
    {
        // this makes sure that the logs folder is created
        File directory = new File(LOG_DIRECTORY_PATH);
        if(!directory.exists())
        {
            directory.mkdir();
        }

        // create a variable with the correct file path
//        this.fileName = fileName;
        this.filePath = LOG_DIRECTORY_PATH + "/" + fileName;
        if(!this.filePath.toLowerCase().endsWith(".csv"))
        {
            this.filePath += ".csv";
        }
    }

    public void saveDealership(Dealership dealership)
    {
        File logFile = new File(filePath);



        try(FileWriter fileWriter = new FileWriter(logFile);
            PrintWriter writer = new PrintWriter(fileWriter)
        ) {

                writer.println(String.format("%s|%s|%s", dealership.getName(), dealership.getAddress(), dealership.getPhone()));


            for (Vehicle vehicle : dealership.getInventory())
            {

                    writer.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f \n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice()));
            }


        }
        catch (IOException ex)
        {
            System.out.println("Data transaction failed");
        }

    }

    public Dealership loadDealership()
    {
       Dealership dealership = null;

        File file = new File("files/inventory.csv");
        try(Scanner fileScanner = new Scanner(file)) {

            String firstline = fileScanner.nextLine();
            String[] rowOne = firstline.split("[|]");
            String name = rowOne[0];
            String address = rowOne[1];
            String phone = rowOne[2];


            dealership = new Dealership(name, address, phone);

            while(fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();
                String[] columns = line.split("[|]");

                int vin = Integer.parseInt(columns[0]);
                int year = Integer.parseInt(columns[1]);
                String make = columns[2];
                String model = columns[3];
                String vehicleType = columns[4];
                String color = columns[5];
                int odometer = Integer.parseInt(columns[6]);
                double price = Double.parseDouble(columns[7]);
                Vehicle information = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(information);

            }

        }
        catch (IOException ex)
        {
            System.out.println("Error reading log file: " + ex.getMessage());

        }
        return dealership;
    }






}
