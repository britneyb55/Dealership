package com.pluralsight.models;

import java.util.ArrayList;

public class DealershipLot
{
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles;

    public DealershipLot(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        //build the dealership with the vehicles
        vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
     public void addVehicle(Vehicle vehicle)
     {
         vehicles.add(vehicle);
     }


    public ArrayList<Vehicle> getInventory()
    {
        return vehicles;
    }

    public void removeVehicle(Vehicle vehicle)
    {
        vehicles.remove(vehicle);
    }
}

