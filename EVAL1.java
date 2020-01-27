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
	String Type;
	Car(String number, String manufacturer, String mODEL, String type)
	{
		plateNumber=number;
		company=manufacturer;
		model=mODEL;
		Type=type;
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
	
	Driver(String t_name, String t_phone, String t_email, int t_age, String lNumber, Car dcar)
	{
		name=t_name;
		phone=t_phone;
		email=t_email;
		age=t_age;
		licenseNumber=lNumber;
		C=dcar;
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

public class CarRental
{
	static Location[] locations = {new Location("VNIT", 0),new Location("Ajni Station", 1), new Location("Eternity Mall", 2), new Location("Empress Mall", 3), new Location("INOX Jaswant Tuli", 4)}; 
	static double[][] distances = {{0,5,4.6,6.5,6.3},{5,0,3.8,3.3,7.7},{4.6,3.8,0,2.4,6.2},{6.5,3.3,2.4,0,4.8},{6.3,7.7,6.2,4.8,0}};
	static double getPrice(Location one, Location two)
	{
		final int perKM = 25;
		return (perKM*distances[one.number][two.number]);
	}
	public static void main(String[] args)
	{
		Customer[] userList = new Customer[10];
		userList[0] = new Customer("Praneeth","8989898989","praneeth@gmail.com",19,"praneeth1441","password1");
		userList[1] = new Customer("Anirudh","8989898987","anirudh@gmail.com",18,"sarma30","maccBookPro");
		userList[2] = new Customer("Rahul","8989898986","rahul@gmail.com",19,"rahul87","asusZenfone");
		int userCount = 3;
		Scanner sc = new Scanner(System.in);
		//Registration.
		System.out.println("WELCOME TO CAR RENTAL!!!!!");
		System.out.println("Would you like to:");
		System.out.println("1) LOGIN");
		System.out.println("2) REGISTER AS NEW USER");
		int registrationChoice = 0;
		System.out.print("Your choice: ");
		registrationChoice = Integer.parseInt(sc.nextLine());
		Customer c;
		if(registrationChoice == 1)
		{
			String uname;
			String upassword;
			System.out.print("Enter your Username: ");
			uname = sc.nextLine();
			System.out.print("Enter your Password: ");
			upassword = sc.nextLine();
			for(int i =0;i<userCount;i++)
			{
				if(userList[i].username.equals(uname)&&userList[i].password.equals(upassword))
				{
					c = userList[i];
					System.out.println("You have succesfully logged in.");
					System.out.println("Your details are:");
					c.printDetails();
				}
			}
		}
		else if(registrationChoice==2)
		{
			String uname;
			String upassword;
		}
	}
}
}
