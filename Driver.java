package allObjects;

public class Driver implements Person
{
    String name;
    String phone;
    String email;
    int age;
    String licenseNumber;
    public boolean Free = true;

    public Driver(String t_name, String t_phone, String t_email, int t_age, String lNumber)
    {
        name = t_name;
        phone = t_phone;
        email = t_email;
        age = t_age;
        licenseNumber = lNumber;
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

    public void printoutDriverdetails()
    {
        System.out.println("Your driver for this booking is");
        System.out.println("Name: " + name);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Phone no: " + phone);
    }
}
