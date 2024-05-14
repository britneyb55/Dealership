package com.pluralsight.ui;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;
import com.pluralsight.models.DealershipFileManager;
import java.util.Scanner;

public class UserInterface
{
    private static DealershipFileManager dealershipFileManager = new DealershipFileManager("inventory");
    private static  Scanner userInput = new Scanner(System.in);

    public void run()
    {
        Dealership dealership = dealershipFileManager.loadDealership();
        display(dealership);
    }

    public static void display(Dealership dealership)
    {

        System.out.println("-".repeat(60));
        System.out.printf(Colors.PURPLE + "Welcome To %s Dealership \n ", dealership.getName()  );
        System.out.println(Colors.RESET );
        System.out.println(Colors.BLUE + "Would you like to find a Vehicle " + Colors.RESET);
        System.out.println(Colors.CYAN + " [1] Within a Price Range ");
        System.out.println(" [2] By Make and Model");
        System.out.println(" [3] By Year ");
        System.out.println(" [4] Color ");
        System.out.println(" [5] Mileage Range");
        System.out.println(" [6] Car Type ");
        System.out.println(" [7] List All Vehicle");
        System.out.println(" [8] Add Vehicle");
        System.out.println(" [9] Remove a Vehicle");
        System.out.println(" [99] Quit" + Colors.RESET);
        System.out.println("-".repeat(60));


        try
        {
            while(true)
            {
                int choice = Integer.parseInt(userInput.nextLine().strip());

                switch (choice)
                {
                    case 1:
                        processGetByPriceRequest(dealership);
                    case 2:
                        processGetByMakeModelRequest(dealership);
                    case 3:
                        processGetByYearRequest(dealership);
                    case 4:
                        processGetByColorRequest(dealership);
                    case 5:
                        processGetMileageRequest(dealership);
                    case 6:
                        processGetByVehicleTypeRequest(dealership);
                    case 7:
                        displayAllVehicles(dealership);
                        break;
                    case 8:
                        addVehicle(dealership);
                        break;
                    case 9:
                        removeVehicle(dealership);
                        break;
                    case 99:
                        return;
                    default:
                        System.out.println("That was invalid");
                        System.out.println("Please try again");
                        display(dealership);

                }
            }
      }catch(NumberFormatException ex)
        {
            System.out.println("Invalid selection choice a number");
            display(dealership);
        }
    }

    private static void processGetByPriceRequest(Dealership dealership)
    {
        System.out.println("-".repeat(60));
        System.out.println("Min price");
        double min = Double.parseDouble(userInput.nextLine());
        System.out.println("Max price");
        double max = Double.parseDouble(userInput.nextLine());
        dealership.getVehicleByPrice(min,max);

        System.out.println();
        System.out.println(Colors.PURPLE + "What would you like to do?" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [I] " + Colors.CYAN + "Find another vehicle between a different range?" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [X] " + Colors.CYAN + "Go to the home screen" + Colors.RESET);
        System.out.print(Colors.PURPLE + "Select an option: " + Colors.RESET);
        String choice = userInput.nextLine().strip().toLowerCase();

        switch(choice)
        {
            case "i":
                processGetByPriceRequest(dealership);
                break;
            case "x":
                System.out.println("Redirecting to home screen");
                display(dealership);
            default:
                System.out.println("invalid input");
        }
    }

    private static void processGetByMakeModelRequest(Dealership dealership)
    {
        System.out.println("-".repeat(60));
        System.out.println("Enter the make of the vehicle ");
        String make = userInput.nextLine();
        System.out.println("Enter the model of the vehicle");
        String model = userInput.nextLine();
        dealership.getVehicleByMakeModel(make,model);

        System.out.println();
        System.out.println(Colors.PURPLE + "What would you like to do?" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [I] " + Colors.CYAN + "Find another Make and Model" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [X] " + Colors.CYAN + "Go to the home screen" + Colors.RESET);
        System.out.print(Colors.PURPLE + "Select an option: " + Colors.RESET);
        String choice = userInput.nextLine().strip().toLowerCase();
        switch(choice)
        {
            case "i":
                processGetByMakeModelRequest(dealership);
                break;
            case "x":
                System.out.println("Redirecting to home screen");
                display(dealership);
            default:
                System.out.println("invalid input");
        }
    }

    private static void processGetByYearRequest(Dealership dealership)
    {
        System.out.println("-".repeat(60));
        System.out.println("What is the earliest year of the vehicle your looking for?  ");
        int min = Integer.parseInt(userInput.nextLine());
        System.out.println("What is the latest vehicle year?");
        int max = Integer.parseInt(userInput.nextLine());

        dealership.getVehicleByYear(min,max);

        System.out.println();
        System.out.println(Colors.PURPLE + "What would you like to do?" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [I] " + Colors.CYAN + "Find another vehicle by a different Year?" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [X] " + Colors.CYAN + "Go to the home screen" + Colors.RESET);
        System.out.print(Colors.PURPLE + "Select an option: " + Colors.RESET);
        String choice = userInput.nextLine().strip().toLowerCase();
        switch(choice)
        {
            case "i":
                processGetByYearRequest(dealership);
                break;
            case "x":
                System.out.println("Redirecting to home screen");
                display(dealership);
            default:
                System.out.println("invalid input");
        }

    }

    private static void processGetByColorRequest(Dealership dealership)
    {
        System.out.println("-".repeat(60));
        System.out.println("What is the vehicle color you are looking for? ");
        String color = userInput.nextLine();
        dealership.getVehicleByColor(color);

        System.out.println();
        System.out.println(Colors.PURPLE + "What would you like to do?" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [I] " + Colors.CYAN + "Find another vehicle by a different Color?" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [X] " + Colors.CYAN + "Go to the home screen" + Colors.RESET);
        System.out.print(Colors.PURPLE + "Select an option: " + Colors.RESET);
        String choice = userInput.nextLine().strip().toLowerCase();
        switch(choice)
        {
            case "i":
                processGetByColorRequest(dealership);
                break;
            case "x":
                System.out.println("Redirecting to home screen");
                display(dealership);
            default:
                System.out.println("invalid input");
        }

    }

    private static void processGetMileageRequest(Dealership dealership)
    {
        System.out.println("-".repeat(60));
        System.out.println("Minimum Mileage ");
        int min = Integer.parseInt(userInput.nextLine());
        System.out.println("Maximum Mileage ");
        int max = Integer.parseInt(userInput.nextLine());

        dealership.getVehicleByMileage(min,max);

        System.out.println();
        System.out.println(Colors.PURPLE + "What would you like to do?" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [I] " + Colors.CYAN + "Find another vehicle by a different Mileage?" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [X] " + Colors.CYAN + "Go to the home screen" + Colors.RESET);
        System.out.print(Colors.PURPLE + "Select an option: " + Colors.RESET);
        String choice = userInput.nextLine().strip().toLowerCase();
        switch(choice)
        {
            case "i":
                processGetMileageRequest(dealership);
                break;
            case "x":
                System.out.println("Redirecting to home screen");
                display(dealership);
            default:
                System.out.println("invalid input");
        }
    }

    private static void processGetByVehicleTypeRequest(Dealership dealership)
    {
        System.out.println("-".repeat(60));
        System.out.println("Enter Vehicle Type of interest ");
        String vehicleType = userInput.nextLine();

        dealership.getVehicleByType(vehicleType);

        System.out.println();
        System.out.println(Colors.PURPLE + "What would you like to do?" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [I] " + Colors.CYAN + "Find another vehicle by a different Type?" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [X] " + Colors.CYAN + "Go to the home screen" + Colors.RESET);
        System.out.print(Colors.PURPLE + "Select an option: " + Colors.RESET);
        String choice = userInput.nextLine().strip().toLowerCase();
        switch(choice)
        {
            case "i":
                processGetByVehicleTypeRequest(dealership);
                break;
            case "x":
                System.out.println("Redirecting to home screen");
                display(dealership);
            default:
                System.out.println("invalid input");
        }


    }

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

        System.out.println("Press Enter to go back to Home page");
        userInput.nextLine();
        display(dealership);
    }

    public static void addVehicle(Dealership dealership)
    {
        try {
            System.out.println();
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


           Vehicle newVehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
           dealership.addVehicle(newVehicle);
           dealershipFileManager.saveDealership(dealership);

            System.out.println("The vehicle is successfully logged in");
        }
        catch(Exception ex){
            System.out.println("Invalid input only type in the number");
            addVehicle(dealership);
        }
        System.out.println();
        promptChoice(dealership);

    }

    public static void promptChoice(Dealership dealership)
    {
        System.out.println();
        System.out.println(Colors.PURPLE + "What would you like to do?" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [I] " + Colors.CYAN + "insert another vehicle" + Colors.RESET);
        System.out.println(Colors.LIGHT_MAGENTA + " [X] " + Colors.CYAN + "Go to the home screen" + Colors.RESET);
        System.out.print(Colors.PURPLE + "Select an option: " + Colors.RESET);
        String choice = userInput.nextLine().strip().toLowerCase();

        switch(choice)
        {
            case "i":
                addVehicle(dealership);
                promptChoice(dealership);
                break;
            case "x":
                System.out.println("Redirecting to home screen");
                display(dealership);
            default:
                System.out.println("invalid input");
        }
    }


    public static void removeVehicle(Dealership dealership)
    {

        System.out.print("Enter the Vin of the vehicle: ");
        int vin = Integer.parseInt(userInput.nextLine());

        for(Vehicle vehicle: dealership.getInventory())
        {
            if (vin == vehicle.getVin())
            {
                //Vehicle removeVehicle = new Vehicle(vehicle.getVin(),vehicle.getYear(),vehicle.getMake(),vehicle.getModel(),vehicle.getVehicleType(),vehicle.getColor(),vehicle.getOdometer(),vehicle.getPrice());
                dealership.removeVehicle(vehicle);
                dealershipFileManager.saveDealership(dealership);
                break;
            }
            else
            {
              System.out.println("vin does not exist");
              break;
            }

        }

        System.out.println(Colors.LIGHT_MAGENTA + " [X] " + Colors.CYAN + "Go to the home screen" + Colors.RESET);
        String choice = userInput.nextLine().strip().toLowerCase();
        switch(choice)
        {
            case "x":
                System.out.println("Redirecting to home screen");
                display(dealership);
            default:
                System.out.println("invalid input");
        }

    }

}
