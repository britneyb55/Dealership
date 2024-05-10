package com.pluralsight.models;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class logger
{
    private final String LOG_DIRECTORY_PATH = "files";

    public ArrayList<Dealership> readInventoryFirstLine()
    {
        ArrayList<Dealership> dealer = new ArrayList<>();

        File file = new File("files/inventory.csv");
        try(Scanner fileScanner = new Scanner(file)) {
            String firstline = fileScanner.nextLine();
            String[] rowOne = firstline.split("[|]");
            String name = rowOne[0];
            String address = rowOne[1];
            String phone = rowOne[2];


            Dealership dealership = new Dealership(name, address, phone);
            dealer.add(dealership);
        }
        catch (IOException ex)
        {
            System.out.println("Error reading log file: " + ex.getMessage());

        }
        return dealer;
    }

    public ArrayList<Vehicle> readInventory()
    {
        ArrayList<Vehicle> inventory = new ArrayList<>();

        File file = new File("files/inventory.csv");

        try(Scanner fileScanner = new Scanner(file))
        {
            readInventoryFirstLine();
            fileScanner.nextLine();


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
                Vehicle information = new Vehicle(vin, year, make, model,
                    vehicleType, color, odometer, price);
                inventory.add(information);

            }

        }catch (IOException ex)
        {
            System.out.println("Error reading log file: " + ex.getMessage());

        }
        return inventory;
    }
}
