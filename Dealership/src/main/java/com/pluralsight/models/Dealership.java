package com.pluralsight.models;

import java.util.ArrayList;

public class Dealership
{
    private final  String name;
    private final String address;
    private final String phone;
    private final ArrayList<Vehicle> vehicles;

    public Dealership(String name, String address, String phone) {
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

    public ArrayList<Vehicle> getVehicleByPrice(double min, double max)
    {
        ArrayList<Vehicle> priceMatch = new ArrayList<>();
       for(Vehicle vehicle : vehicles)
       {
           if(min <= vehicle.getPrice() && max >= vehicle.getPrice())
           {
               priceMatch.add(vehicle);
              System.out.printf(" %d %d %s %s %s %s %d %.2f \n",vehicle.getVin(),vehicle.getYear(),vehicle.getMake(),vehicle.getModel(),
               vehicle.getVehicleType(),vehicle.getColor(),vehicle.getOdometer(),vehicle.getPrice());


           }
       }
       return priceMatch;


    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model )
    {
        ArrayList<Vehicle> vehicleMakeModel = new ArrayList<>();
        for(Vehicle vehicle : vehicles)
        {
            if(make.equalsIgnoreCase(vehicle.getMake()) && model.equalsIgnoreCase(vehicle.getModel()))
            {
                vehicleMakeModel.add(vehicle);
                System.out.printf(" %d %d %s %s %s %s %d %.2f \n",vehicle.getVin(),vehicle.getYear(),vehicle.getMake(),vehicle.getModel(),
                        vehicle.getVehicleType(),vehicle.getColor(),vehicle.getOdometer(),vehicle.getPrice());


            }
        }
        return vehicleMakeModel;
    }

    public ArrayList<Vehicle> getVehicleByYear(int min, int max)
    {
        ArrayList<Vehicle> vehicleYear = new ArrayList<>();
        for(Vehicle vehicle : vehicles)
        {
            if(min <= vehicle.getYear() && max >= vehicle.getYear())
            {
                vehicleYear.add(vehicle);
                System.out.printf(" %d %d %s %s %s %s %d %.2f \n",vehicle.getVin(),vehicle.getYear(),vehicle.getMake(),vehicle.getModel(),
                        vehicle.getVehicleType(),vehicle.getColor(),vehicle.getOdometer(),vehicle.getPrice());


            }
        }
        return vehicleYear;
    }

    public ArrayList<Vehicle> getVehicleByColor(String color)
    {
        ArrayList<Vehicle> vehicleColor = new ArrayList<>();
        for(Vehicle vehicle : vehicles)
        {
            if(color.equalsIgnoreCase(vehicle.getColor()))
            {
                vehicleColor.add(vehicle);
                System.out.printf(" %d %d %s %s %s %s %d %.2f \n",vehicle.getVin(),vehicle.getYear(),vehicle.getMake(),vehicle.getModel(),
                        vehicle.getVehicleType(),vehicle.getColor(),vehicle.getOdometer(),vehicle.getPrice());


            }
        }
        return vehicleColor;
    }

    public ArrayList<Vehicle> getVehicleByMileage(int min, int max)
    {
        ArrayList<Vehicle> vehicleMileage = new ArrayList<>();
        for(Vehicle vehicle : vehicles)
        {
            if(min <= vehicle.getOdometer() && max >= vehicle.getOdometer())
            {
                vehicleMileage.add(vehicle);
                System.out.printf(" %d %d %s %s %s %s %d %.2f \n",vehicle.getVin(),vehicle.getYear(),vehicle.getMake(),vehicle.getModel(),
                        vehicle.getVehicleType(),vehicle.getColor(),vehicle.getOdometer(),vehicle.getPrice());

            }

        }
        return vehicleMileage;
    }

    public ArrayList<Vehicle> getVehicleByType(String vehicleType)
    {
        ArrayList<Vehicle> vehicletype = new ArrayList<>();
        for(Vehicle vehicle : vehicles)
        {
            if(vehicleType.equalsIgnoreCase(vehicle.getVehicleType()))
            {
                vehicletype.add(vehicle);
                System.out.printf(" %d %d %s %s %s %s %d %.2f \n",vehicle.getVin(),vehicle.getYear(),vehicle.getMake(),vehicle.getModel(),
                        vehicle.getVehicleType(),vehicle.getColor(),vehicle.getOdometer(),vehicle.getPrice());

            }

        }
        return vehicletype;
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

