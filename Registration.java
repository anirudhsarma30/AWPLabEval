package allObjects;

import java.util.Scanner;

public class Registration
{
    public Customer Login(Customer[] userList, int userCount)
    {
        boolean run = true;
        Customer c = new Customer();

        Scanner sc = new Scanner(System.in);

        while (run)
        {

            String uname;
            String upassword;
            System.out.print("Enter your Username: ");

            uname = sc.nextLine();
            System.out.print("Enter your Password: ");
            upassword = sc.nextLine();

            boolean found = false;

            for (int i = 0; i < userCount; i++)
            {
                if (userList[i].username.equals(uname) && userList[i].password.equals(upassword))
                {
                    c = userList[i];
                    found = true;
                    run = false;
                    System.out.println("You have succesfully logged in.");
                }
            }
            if (!found)
            {

                System.out.println("The Username and Password you have entered are wrong.");
                System.out.println("TRY AGAIN.");
            }

        }

        return c;
    }

    public Customer newregister()
    {
        Customer c = new Customer();
        Scanner sc = new Scanner(System.in);
        String uNAME = "";
        String uname = "";
        String upassword = "";
        int uage = 0;
        String uemail = "";
        String uphone = "";
        System.out.println("Enter the following details:");
        boolean flag = true;
        while (flag)
        {
            System.out.println("NAME: ");
            uNAME = uNAME + sc.nextLine();
            if (uNAME.equals(""))
            {
                System.out.println("Do not leave the name field blank.");
            } else
            {
                flag = false;
            }
        }
        flag = true;

        while (flag)
        {
            System.out.println("EMAIL: ");
            uemail = uemail + sc.nextLine();
            if (uemail.equals(""))
            {
                System.out.println("Do not leave the email field blank.");
            } else
            {
                flag = false;
            }
        }
        flag = true;

        while (flag)
        {
            System.out.println("PHONE NUMBER: ");
            uphone = uphone + sc.nextLine();
            if (uphone.equals(""))
            {
                System.out.println("Do not leave the phone number field blank.");
            } else
            {
                flag = false;
            }
        }
        flag = true;


        while (flag)
        {
            System.out.println("AGE: ");
            uage = Integer.parseInt(sc.nextLine());
            if (uage <= 0)
            {
                System.out.println("Enter a valid age.");
            } else
            {
                flag = false;
            }
        }
        flag = true;

        while (flag)
        {
            System.out.println("USERNAME: ");
            uname = uname + sc.nextLine();
            if (uname.equals(""))
            {
                System.out.println("Do not leave the username field blank.");
            } else
            {
                flag = false;
            }
        }
        flag = true;

        while (flag)
        {
            System.out.println("PASSWORD: ");
            upassword = sc.nextLine();
            String upasswordCheck;
            System.out.println("Re-enter the password: ");
            upasswordCheck = sc.nextLine();
            if (!upassword.equals(upasswordCheck))
            {
                System.out.println("Enter the password again. Make sure you match both the fields.");
            } else
            {
                flag = false;
            }
        }
        flag = true;

        System.out.println("YOU HAVE SUCCESSFULLY REGISTERED!!");
        c = new Customer(uNAME, uphone, uemail, uage, uname, upassword);

        return c;
    }


}

