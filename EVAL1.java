import java.util.*;
interface Person
{
	String getName();
	String getPhone();
	String getEmail();
	int getAge();
}
class Car
{
	String plateNumber;
	String company;
	String model;
	Car(String number, String manufacturer, String mODEL)
	{
		plateNumber=number;
		company=manufacturer;
		model=mODEL;
	}
}
class Driver implements Person
{
	String name;
	String phone;
	String email;
	int age;
	String licenseNumber;
	Car C;
	
	Driver(String t_name, String t_phone, String t_email, int t_age, String lNumber)
	{
		name=t_name;
		phone=t_phone;
		email=t_email;
		age=t_age;
		licenseNumber=lNumber;
	}
	public String getName()
	{
		return name;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getEmail()
	{
		return email;
	}
	public int getAge()
	{
		return age;
	}
}

class Customer implements Person
{
	String name;
	String phone;
	String email;
	int age;
	String username;
	String password;
	Customer(){}
	Customer(String t_name, String t_phone, String t_email, int t_age, String t_Username, String t_Password)
	{
		name=t_name;
		phone=t_phone;
		email=t_email;
		age=t_age;
		username=t_Username;
		password=t_Password;
	}
	public String getName()
	{
		return name;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getEmail()
	{
		return email;
	}
	public int getAge()
	{
		return age;
	}
	void printDetails()
	{
		System.out.println("NAME: "+name);
		System.out.println("PHONE: "+phone);
		System.out.println("EMAIL: "+email);
		System.out.println("AGE: "+age);
	}
}

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
		System.out.println((number+1)+". "+name);
	}
}

class Price
{
	int basePrice = 40;
	double[][] distances = {{0,5,4.6,6.5,6.3},{5,0,3.8,3.3,7.7},{4.6,3.8,0,2.4,6.2},{6.5,3.3,2.4,0,4.8},{6.3,7.7,6.2,4.8,0}};
	
	double getPrice(Location one, Location two)
	{
		final int perKM = 25;
		return (basePrice+(perKM*distances[one.number][two.number]));
	}
}
class Registration
{
	Customer Login(Customer userList[], int userCount)
	{
		boolean run = true;
		Customer c = new Customer();
		Scanner s = new Scanner(System.in);
		while(run)
		{
			
			String uname;
			String upassword;
			System.out.print("Enter your Username: ");
			uname = s.nextLine();
			System.out.print("Enter your Password: ");
			upassword = s.nextLine();
			boolean found = false;
			
			for(int i =0;i<userCount;i++)
			{
				if(userList[i].username.equals(uname)&&userList[i].password.equals(upassword))
				{
					c = userList[i];
					found = true;
					run = false;
					System.out.println("You have succesfully logged in.");
				}
			}
			if(!found)
			{
				
				System.out.println("The Username and Password you have entered are wrong.");
				System.out.println("TRY AGAIN.");
			}
			
		}
		return c;
	}
	
	Customer newregister()
	{
		Customer c = new Customer();
		Scanner sc = new Scanner(System.in);
		String uNAME="";
		String uname="";
		String upassword="";
		int uage = 0;
		String uemail="";
		String uphone="";
		System.out.println("Enter the following details:");
		boolean flag = true;
		while(flag) 
		{
			System.out.println("NAME: ");
			uNAME = uNAME+sc.nextLine();
			if(uNAME.equals(""))
			{
				System.out.println("Do not leave the name field blank.");
			}
			else {flag=false;}
		}
		flag = true;
		
		while(flag) 
		{
			System.out.println("EMAIL: ");
			uemail = uemail+sc.nextLine();
			if(uemail.equals(""))
			{
				System.out.println("Do not leave the email field blank.");
			}
			else {flag=false;}
		}
		flag = true;
		
		while(flag) 
		{
			System.out.println("PHONE NUMBER: ");
			uphone = uphone+sc.nextLine();
			if(uphone.equals(""))
			{
				System.out.println("Do not leave the phone number field blank.");
			}
			else {flag=false;}
		}
		flag = true;
		
		
		while(flag) 
		{
			System.out.println("AGE: ");
			uage = Integer.parseInt(sc.nextLine());
			if(uage<=0)
			{
				System.out.println("Enter a valid age.");
			}
			else {flag=false;}
		}
		flag = true;
		
		while(flag) 
		{
			System.out.println("USERNAME: ");
			uname = uname+sc.nextLine();
			if(uname.equals(""))
			{
				System.out.println("Do not leave the username field blank.");
			}
			else {flag=false;}
		}
		flag = true;
		
		while(flag) 
		{
			System.out.println("PASSWORD: ");
			upassword = upassword+sc.nextLine();
			String upasswordCheck;
			System.out.println("Re-enter the password: ");
			upasswordCheck = sc.nextLine();
			if(!upassword.equals(upasswordCheck))
			{
				System.out.println("Enter the password again. Make sure you match both the fields.");
			}
			else {flag=false;}
		}
		flag = true;
		
		System.out.println("YOU HAVE SUCCESSFULLY REGISTERED!!");
		c = new Customer(uNAME, uphone, uemail, uage, uname, upassword);
		return c;
	}
	
	
	
}

public class CarRental
{
	static Location[] locations = {new Location("VNIT", 0),new Location("Ajni Station", 1), new Location("Eternity Mall", 2), new Location("Empress Mall", 3), new Location("INOX Jaswant Tuli", 4)}; 

	static Car[] car_list_Economy={new Car("MH05DO1017","Toyota","Etios"),

			new Car("MH08GO1018","Tata","Indica"),
			new Car("MH05JO0067","Maruti Suzuki","Ritz"),
			new Car("MH75HO1019","Maruti Zuzuki","WagonR")};
	static Car[] car_list_Sedan={new Car("MH05DO1055","Toyota","Prius"),
			new Car("MH05JO1010","Chevrolet","Suburban"),
			new Car("MH69JK9999","Toyota","Camry"),
			new Car("MH27AA8889","Honda","Civic")};
	static Car[] car_list_SUV={new Car("MH85DO10543","Hyundai","Venue"),
			new Car("MH05JO1011","Maruti","Brezza"),
			new Car("MH99AO0097","Toyota","Fortuner"),
			new Car("MH12SO1019","Mahindra","TUV300")};

	public static void main(String[] args)
	{
		Customer[] userList = new Customer[10];
		userList[0] = new Customer("Praneeth","8989898989","praneeth@gmail.com",19,"praneeth1441","password1");
		userList[1] = new Customer("Anirudh","8989898987","anirudh@gmail.com",18,"sarma30","maccBookPro");
		userList[2] = new Customer("Rahul","8989898986","rahul@gmail.com",19,"rahul87","asusZenfone");
		int userCount = 3;
		//Registration.
		System.out.println("WELCOME TO CAR RENTAL!!!!!");
		System.out.println("Would you like to:");
		System.out.println("1) LOGIN");
		System.out.println("2) REGISTER AS NEW USER");
		int registrationChoice = 0;
		System.out.print("Your choice: ");
		
		registrationChoice = Integer.valueOf(sc.nextLine());
		Customer currentCustomer = new Customer();
		Registration r = new Registration();
		if(registrationChoice == 1)
		{
			currentCustomer = r.Login(userList, userCount);
			currentCustomer.printDetails();
		}
		
		else if(registrationChoice==2)
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
		int start,end,via = -1;
		System.out.println("Enter the number corresponding to the location you would like to avail the services from.");
		System.out.print("Enter the starting location - ");
		start = Integer.valueOf(sc.nextLine());
		System.out.print("Enter your destination - ");
		end = Integer.parseInt(sc.nextLine());
		System.out.println("Would you like to add a stop on the way?");
		System.out.println("Enter y for YES or n for NO");
		String svia = sc.nextLine();
		if((svia.equalsIgnoreCase("y"))||(svia.equalsIgnoreCase("yes")))
		{
			System.out.print("Enter the location you would like to stop on the way - ");
			via = Integer.parseInt(sc.nextLine());
		}
		Price p = new Price();
		double fare = 0;
		if(via == -1)
		{
			fare += p.getPrice(locations[start-1], locations[end-1]);
		}
		else
		{
			fare += p.getPrice(locations[start-1], locations[via-1]);
			fare += p.getPrice(locations[via-1], locations[end-1]);
		}
		System.out.println("What type of Car would you like?");
		System.out.println("(1)Compact  (2)Sedan  (3)SUV");
		System.out.println("Your choice - ");
		int vehicleTypeChoice = Integer.parseInt(sc.nextLine());
		
	}
	
}
}
