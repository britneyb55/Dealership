package com.pluralsight;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;
import com.pluralsight.models.logger;
import com.pluralsight.ui.UserInterface;

import java.util.ArrayList;

public class Main
{
    static  ArrayList<Vehicle> inventory = new ArrayList<>();


    public static void main(String[] args)
    {
        // Create an instance of the logger class
        logger inventoryLogger = new logger();

        // Call the readInventory method to read the inventory data from the CSV file
        ArrayList<Dealership> dealer = inventoryLogger.readInventoryFirstLine();
        ArrayList<Vehicle> inventory = inventoryLogger.readInventory();


        // Display the inventory using the UserInterface class
        UserInterface.displayAllVehicles(inventory,dealer);

    }
}