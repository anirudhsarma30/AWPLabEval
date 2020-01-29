package allObjects;

public class Customer implements Person
{
    String name;
    String phone;
    String email;
    int age;
    public String username;
    public String password;

    public Customer()
    {
    }

    public Customer(String t_name, String t_phone, String t_email, int t_age, String t_Username, String t_Password)
    {
        name = t_name;
        phone = t_phone;
        email = t_email;
        age = t_age;
        username = t_Username;
        password = t_Password;
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

    public void printDetails()
    {
        System.out.println("NAME: " + name);
        System.out.println("PHONE: " + phone);
        System.out.println("EMAIL: " + email);
        System.out.println("AGE: " + age);
    }
}

