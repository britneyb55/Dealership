package com.pluralsight.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Logger
{
    private final String LOG_DIRECTORY_PATH = "files";
    private String filePath;

    public Logger(String fileName)
    {
        // this makes sure that the logs folder is created
        File directory = new File(LOG_DIRECTORY_PATH);
        if(!directory.exists())
        {
            directory.mkdir();
        }

        // create a variable with the correct file path
        this.filePath = LOG_DIRECTORY_PATH + "/" + fileName;
        if(!this.filePath.toLowerCase().endsWith(".csv"))
        {
            this.filePath += ".csv";
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


    public void logVehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price)
    {
        File logFile = new File(filePath);

        try(FileWriter fileWriter = new FileWriter(logFile, true);
            PrintWriter writer = new PrintWriter(fileWriter)
        )
        {
            writer.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f \n", vin,year,make,model,vehicleType,color,odometer,price ));
        }
        catch (IOException ex)
        {
            System.out.println("Data transaction failed");
        }

    }



}
