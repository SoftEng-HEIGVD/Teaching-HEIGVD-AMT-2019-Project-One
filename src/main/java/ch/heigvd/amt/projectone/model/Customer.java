package main.java.ch.heigvd.amt.projectone.model;

public class Customer
{
    private long customer_id;
    private String customer_pseudo;
    private String firstname;
    private String lastname;
    private int age;
    private String customer_pw;

    public Customer(long customer_id, String customer_pseudo, String firstname, String lastname, int age, String customer_pw)
    {
        this.customer_id = customer_id;
        this.customer_pseudo = customer_pseudo;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.customer_pw = customer_pw;
    }

    public long getCustomer_id()
    {
        return customer_id;
    }

    public String getCustomer_pseudo()
    {
        return customer_pseudo;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public int getAge()
    {
        return age;
    }

    public String getCustomer_pw()
    {
        return customer_pw;
    }
}
