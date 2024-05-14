package com.pluralsight.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest
{
    Dealership dealership;

    @BeforeEach
    public void car() {
        dealership = new Dealership("Vehicles Motor Inc ", "Oakland CA", "555-555-5555");
        dealership.addVehicle(new Vehicle(1, 2024, "Toyota", "Camry", "Car", "PINK", 12355, 15500));
        dealership.addVehicle(new Vehicle(2, 2023, "Honda", "Civic", "Car", "RED", 12355, 20500));
        dealership.addVehicle(new Vehicle(3,1993,"Ford","Explorer","SUV","Red",525123,995.00));
    }
    @Test
    public void testVehicle_by_color()
    {
        //arrange
        dealership.addVehicle(new Vehicle(1014, 2023,"Honda","Civic","Car","RED",12355,20500));

         //act
        List<Vehicle> vehicleColor = dealership.getVehicleByColor("Red");
        int expected = 2;

        //assert
        assertEquals(expected,vehicleColor.size());

    }

    @Test
    public void testVehicle_ByPrice()
    {
        //arrange
        double min = 900;
        double max = 16000;

       // act
        ArrayList<Vehicle> vehiclePrice = dealership.getVehicleByPrice(min,max);

        int expected = 2;

        //assert
        assertEquals(expected, vehiclePrice.size());

    }

    @Test
    public void testVehicle_addVehicle()
    {
        Vehicle newVehicle = new Vehicle(4,2024,"Honda", "Odyssey","Minivan","Red",1200, 30000);
        dealership.addVehicle(newVehicle);
        assertTrue(dealership.getInventory().contains(newVehicle));


    }

    @Test
    public void testVehicle_removeVehicle()
    {
        Vehicle newVehicle = new Vehicle(5,2022,"Honda", "Odyssey","Minivan","Red",1200, 30000);
        dealership.addVehicle(newVehicle);
        dealership.removeVehicle(newVehicle);
        assertFalse(dealership.getInventory().contains(newVehicle));


    }






}