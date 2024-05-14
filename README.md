# Dealership

The Car Dealership program is designed to help the sales process for a salesman or sales manager. This application allows finding the right vehicle for the client's desired car and features. This application lets you easily manage the vehicle inventory and assist customers in finding their dream car.

## Process

Although I had the information I needed for each one of my classes, I wanted to understand where I was going to place my ArrayList. Although I had an idea, I learned in the UserInteraction class that I can just call the Dealership dealer and load the data from there, getting all the information about the vehicles in the dealership inventory.

![Home screen](images/diagram.jpeg)


##Demo 

![Home screen](images/part1.jpeg)

![Home screen](images/partTwo.jpeg)

![Home screen](images/partThree.jpeg)

![Home screen](images/partfour.jpeg)

![Home screen](images/partfive.jpeg)


## CODE

One piece of code that I found interesting and was also struggling with is the addVehicle method. I learned a lot from this single method, being able to use the Dealership class and load data from the inventory file into the Dealership instance to retrieve data or append and add a new vehicle to the existing ArrayList in the Dealership class. Additionally, I learned that after adding a new vehicle, I had to save it to the inventory CSV file at the end.

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