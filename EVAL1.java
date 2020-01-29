import java.util.Scanner;
import allObjects.*;

class Location
{
    String name;
    int number;

    Location(String NAME, int NUMBER)
    {
        name = NAME;
        number = NUMBER;
    }

    void printLocation()
    {
        System.out.println((number + 1) + ". " + name);
    }
}


class Price
{
    int basePrice = 40;
    double[][] distances = {{0, 5, 4.6, 6.5, 6.3}, {5, 0, 3.8, 3.3, 7.7}, {4.6, 3.8, 0, 2.4, 6.2}, {6.5, 3.3, 2.4, 0, 4.8}, {6.3, 7.7, 6.2, 4.8, 0}};

    double getPrice(Location one, Location two)
    {
        final int perKM = 25;
        return (basePrice + (perKM * distances[one.number][two.number]));
    }
}

public class CarRental
{
    static Location[] locations = {new Location("VNIT", 0), new Location("Ajni Station", 1), new Location("Eternity Mall", 2), new Location("Empress Mall", 3), new Location("INOX Jaswant Tuli", 4)};

    static Car[] car_list_Compact = {new Car("MH05DO1017", "Toyota", "Etios"),
            new Car("MH08GO1018", "Tata", "Indica"),
            new Car("MH05JO0067", "Maruti Suzuki", "Ritz"),
            new Car("MH75HO1019", "Maruti Zuzuki", "WagonR")};
    static Car[] car_list_Sedan = {new Car("MH05DO1055", "Toyota", "Prius"),
            new Car("MH05JO1010", "Chevrolet", "Suburban"),
            new Car("MH69JK9999", "Toyota", "Camry"),
            new Car("MH27AA8889", "Honda", "Civic")};
    static Car[] car_list_SUV = {new Car("MH85DO10543", "Hyundai", "Venue"),
            new Car("MH05JO1011", "Maruti", "Brezza"),
            new Car("MH99AO0097", "Toyota", "Fortuner"),
            new Car("MH12SO1019", "Mahindra", "TUV300")};
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws java.io.IOException, ArrayIndexOutOfBoundsException, ArithmeticException
    {
        Customer[] userList = new Customer[10];
        userList[0] = new Customer("Praneeth", "8989898989", "praneeth@gmail.com", 19, "praneeth1441", "password1");
        userList[1] = new Customer("Anirudh", "8989898987", "anirudh@gmail.com", 18, "sarma30", "maccBookPro");
        userList[2] = new Customer("Rahul", "8989898986", "rahul@gmail.com", 19, "rahul87", "asusZenfone");
        int userCount = 3;
        Driver[] driverList = new Driver[10];
        driverList[0] = new Driver("Rajulu", "9823467543", "rajulu@gmail.com", 31, "MH1420110062821");
        driverList[1] = new Driver("vishal", "9555895412", "vishal123@gmail.com", 28, "AH1487654562821");
        driverList[2] = new Driver("chandrakanth", "9821389400", "chandu9876@gmail.com", 41, "KL7656789821");
        //Registration.
        overall:
        while(true)
        {
            System.out.println("WELCOME TO CAR RENTAL!!!!!");
            System.out.println("Would you like to:");
            System.out.println("1) LOGIN");
            System.out.println("2) REGISTER AS NEW USER");
            int registrationChoice = 0;
            System.out.print("Your choice: ");
            registrationChoice = Integer.parseInt(sc.nextLine());
            if((registrationChoice<1||registrationChoice>2))
            {
            	throw new ArithmeticException("Access denied - invalid choice entered.");
            }
            Customer currentCustomer = new Customer();
            Registration r = new Registration();
            if (registrationChoice == 1)
            {
                currentCustomer = r.Login(userList, userCount);
                currentCustomer.printDetails();
            } else if (registrationChoice == 2)
            {
                currentCustomer = r.newregister();
                userList[userCount] = currentCustomer;
                userCount++;
            }
            
    
            //AFTER LOGIN.
            System.out.println("We currently offer services between these locations:");
            System.out.println("1) VNIT");
            System.out.println("2) Ajni Railway Station");
            System.out.println("3) Eternity Mall");
            System.out.println("4) Empress Mall");
            System.out.println("5) Trilium Mall");
            int start, end, via = -1;
            System.out.println("Enter the number corresponding to the location you would like to avail the services from.");
            System.out.print("Enter the starting location - ");
            start = Integer.parseInt(sc.nextLine());
            if((start<1||start>5))
            {
            	throw new ArithmeticException("Access denied - invalid choice entered.");
            }
            System.out.print("Enter your destination - ");
            end = Integer.parseInt(sc.nextLine());
            if((end<1||end>5))
            {
            	throw new ArithmeticException("Access denied - invalid choice entered.");
            }
            System.out.println("Would you like to add a stop on the way?");
            System.out.println("Enter y for YES or n for NO");
            String svia = sc.nextLine();
            if ((svia.equalsIgnoreCase("y")) || (svia.equalsIgnoreCase("yes")))
            {
                System.out.print("Enter the location you would like to stop on the way - ");
                via = Integer.parseInt(sc.nextLine());
            }
            Car currentCar = new Car();
            typechoice:
            while (true)
            {
                System.out.println("What type of Car would you like?");
                System.out.println("(1)Compact  (2)Sedan  (3)SUV");
                System.out.println("Your choice - ");
                Price p = new Price();
                double fare = 0;
                if (via == -1)
                {
                    fare += p.getPrice(locations[start - 1], locations[end - 1]);
                } else
                {
                    fare += p.getPrice(locations[start - 1], locations[via - 1]);
                    fare += p.getPrice(locations[via - 1], locations[end - 1]);
                }
                int vehicleTypeChoice = Integer.parseInt(sc.nextLine());
                if (vehicleTypeChoice == 1)
                {
                    int j = 0;
                    for (j = 0; j < car_list_Compact.length; j++)
                    {
                        if (car_list_Compact[j].Free)
                        {
                            break;
                        }
                    }
                    if (j != car_list_Compact.length)
                    {
                        System.out.println("The following car is available.");
                        car_list_Compact[j].printDuringSelection();
                        System.out.println("Your fare will be Rs." + fare);
                        int confirm = 0;
                        System.out.println("Would you like to confirm the booking? Enter (1)YES (2)PICK NEW TYPE (3)CANCEL BOOKING");
                        confirm = Integer.parseInt(sc.nextLine());
                        if (confirm == 1)
                        {
                            currentCar = car_list_Compact[j];
                            break;
                        } else if(confirm == 2)
                        {
                            continue;
                        }else if(confirm == 3)
                        {
                        	System.out.println("We are sorry to see you leave. We hope you consider us in the future. THANK YOU!!");
                        	break overall;
                        }
                    } else
                    {
                        System.out.println("There are no Compacts available at the moment. Please try again later.");
                    }
                } else if (vehicleTypeChoice == 2)
                {
                    int j = 0;
                    for (j = 0; j < car_list_Sedan.length; j++)
                    {
                        if (car_list_Sedan[j].Free)
                        {
                            break;
                        }
                    }
                    if (j != car_list_Sedan.length)
                    {
                        System.out.println("The following car is available.");
                        car_list_Sedan[j].printDuringSelection();
                        fare = fare * 1.05;
                        System.out.println("Your fare will be Rs." + fare);
                        int confirm = 0;
                        System.out.println("Would you like to confirm the booking? Enter (1)YES (2)PICK NEW TYPE (3)CANCEL BOOKING ");
                        confirm = Integer.parseInt(sc.nextLine());
                        if (confirm == 1)
                        {
                            currentCar = car_list_Sedan[j];
                            break typechoice;
                        } else if (confirm == 2)
                        {
                            continue typechoice;
                        }else if(confirm == 3)
                        {
                        	System.out.println("We are sorry to see you leave. We hope you consider us in the future. THANK YOU!!");
                            break overall;
                        }
                    } else
                    {
                        System.out.println("There are no Sedans available at the moment. Please try again later.");
                    }
                } else if (vehicleTypeChoice == 3)
                {
                    int j = 0;
                    for (j = 0; j < car_list_SUV.length; j++)
                    {
                        if (car_list_SUV[j].Free)
                        {
                            break;
                        }
                    }
                    if (j != car_list_SUV.length)
                    {
                        System.out.println("The following car is available.");
                        car_list_SUV[j].printDuringSelection();
                        fare = fare * 1.075;
                        System.out.println("Your fare will be Rs." + fare);
                        int confirm = 0;
                        System.out.println("Would you like to confirm the booking? Enter (1)YES (2)PICK NEW TYPE (3)CANCEL BOOKING");
                        confirm = Integer.parseInt(sc.nextLine());
                        if (confirm == 1)
                        {
                            currentCar = car_list_SUV[j];
                            break typechoice;
                        } else if(confirm == 2)
                        {
                            continue typechoice;
                        }else if(confirm == 3)
                        {
                        	System.out.println("We are sorry to see you leave. We hope you consider us in the future. THANK YOU!!");
                            break overall;
                        }
                    } else
                    {
                        System.out.println("There are no SUVs available at the moment. Please try again later.");
                    }
                }
            }//typechoice loop
            System.out.println("YOUR BOOKING DETAILS");
            currentCar.printoutcardetails();
            int j;
            for (j = 0; j < 3; j++)
            {
                if (driverList[j].Free)
                {
                    break;
                }
            }
            if (j != 3)
            {
                driverList[j].printoutDriverdetails();
            }
            break;
        }
        sc.close();

    }

}
