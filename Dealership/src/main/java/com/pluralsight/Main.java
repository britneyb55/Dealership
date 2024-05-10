package com.pluralsight;

import com.pluralsight.models.DealershipLot;
import com.pluralsight.models.Logger;
import com.pluralsight.ui.UserInterface;

public class Main
{
    static DealershipLot dealership;


    public static void main(String[] args)
    {
        Logger logger = new Logger("inventory");

        dealership = logger.loadDealership();
        UserInterface.displayAllVehicles(dealership);
        UserInterface.addVehicle();
        UserInterface.displayAllVehicles(dealership);





    }
}