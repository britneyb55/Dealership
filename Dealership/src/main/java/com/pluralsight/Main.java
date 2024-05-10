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

        logger inventoryLogger = new logger();


        ArrayList<Dealership> dealer = inventoryLogger.readInventoryFirstLine();
        ArrayList<Vehicle> inventory = inventoryLogger.readInventory();

        
        UserInterface.displayAllVehicles(inventory,dealer);

    }
}