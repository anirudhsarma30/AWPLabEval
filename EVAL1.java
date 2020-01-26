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
	Car(String number, String manufacturer, String MODEL, String type)
	{
		//Write your code here.
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
	
	Driver(String Name, String phone, String email, int age, String lNumber, Car dcar)
	{
		//Write your code here
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
	String Username;
	String Password;
	Customer(String Name, String Phone, String Email, int age, String Username, String Password)
	{
		//Write your code here.
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
	ArrayList<Car> SUV = new ArrayList<Car>();
	ArrayList<Car> Sedan = new ArrayList<Car>();
	ArrayList<Car> Hatchback = new ArrayList<Car>();
	ArrayList<Car> Van = new ArrayList<Car>();
}
