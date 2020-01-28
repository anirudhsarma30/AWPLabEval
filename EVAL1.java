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
	
}
public Class CarRental
{
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
}
