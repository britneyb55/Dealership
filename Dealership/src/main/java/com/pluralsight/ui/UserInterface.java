package com.pluralsight.ui;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;

import java.util.ArrayList;

public class UserInterface
{

    public static void displayAllVehicles(ArrayList<Vehicle> inventory, ArrayList<Dealership> dealer)
    {
        for (Dealership dealership : dealer)
        {
            System.out.printf("%s %s %s \n", dealership.getName(), dealership.getAddress(), dealership.getPhone());
        }

        for(Vehicle vehicle: inventory)
        {
            System.out.printf(" %d %d %s %s %s %s %d %.2f \n",vehicle.getVin(),vehicle.getYear(),vehicle.getMake(),vehicle.getModel(),
                    vehicle.getVehicleType(),vehicle.getColor(),vehicle.getOdometer(),vehicle.getPrice());
        }
        System.out.println();
    }

}
