package com.pluralsight;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Logger;
import com.pluralsight.ui.UserInterface;

public class Main
{
    static  Dealership dealership;


    public static void main(String[] args)
    {
        Logger logger = new Logger("inventory");

        dealership = logger.loadDealership();
        UserInterface.displayAllVehicles(dealership);





    }
}