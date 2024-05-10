package com.pluralsight.ui;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;
import com.pluralsight.models.Logger;


import java.util.Scanner;


public class UserInterface
{
    private static Logger logger = new Logger("inventory");
    private static Scanner userInput = new Scanner(System.in);

    public static void displayAllVehicles(Dealership dealership)
    {
        System.out.println("-".repeat(50));
        System.out.println();
        System.out.println("Dealership Information:");

            System.out.printf("%s %s %s \n", dealership.getName(), dealership.getAddress(), dealership.getPhone());

        System.out.println();
        System.out.println("ALL VEHICLES:");
        for(Vehicle vehicle: dealership.getInventory())
        {
            System.out.printf(" %d %d %s %s %s %s %d %.2f \n",vehicle.getVin(),vehicle.getYear(),vehicle.getMake(),vehicle.getModel(),
                    vehicle.getVehicleType(),vehicle.getColor(),vehicle.getOdometer(),vehicle.getPrice());
        }
        System.out.println();
    }

    public static void addVehicle()
    {
        System.out.println("Enter the vehicle information");
        System.out.print("Enter the vin of the vehicle: ");
        int vin = Integer.parseInt(userInput.nextLine());

        System.out.print("Enter the year: ");
        int year = Integer.parseInt(userInput.nextLine());

        System.out.print("Enter the make: ");
        String make = userInput.nextLine();

        System.out.print("Enter the model: ");
        String model = userInput.nextLine();

        System.out.println("Enter the vehicle type: ");
        String vehicleType = userInput.nextLine();

        System.out.println("Enter the color: ");
        String color = userInput.nextLine();

        System.out.println("Enter the odometer: ");
        int odometer = Integer.parseInt(userInput.nextLine());

        System.out.println("Enter the price: ");
        int price = Integer.parseInt(userInput.nextLine());

        System.out.println("The vehicle is successfully logged in");

        logger.logVehicle(vin, year, make, model, vehicleType, color, odometer, price);



    }

}
