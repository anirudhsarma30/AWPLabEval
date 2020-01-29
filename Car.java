package allObjects;

public class Car
{
    private String plateNumber;
    private String company;
    private String model;
    public boolean Free = true;

    public Car()
    {
    }

    public Car(String number, String manufacturer, String mODEL)
    {
        plateNumber = number;
        company = manufacturer;
        model = mODEL;

    }

    public void printoutcardetails()
    {
        System.out.println(company + " " + model);
        System.out.println(plateNumber);
    }

    public void printDuringSelection()
    {
        System.out.println(company + " " + model);
    }
}
