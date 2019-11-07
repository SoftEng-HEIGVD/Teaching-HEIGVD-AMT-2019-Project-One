package main.java.ch.heigvd.amt.projectone.dao;

import main.java.ch.heigvd.amt.projectone.model.Customer;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless
public class CustomerManager
{
    @Resource(lookup = "java:/jdbc/FlightCompany")
    private DataSource dataSource;

    public Customer getCustomer(long id)
    {
        Customer customer = null;
        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement sql = connection.prepareStatement("SELECT * FROM customer WHERE customer_id = ?");
            sql.setObject(1, id);

            ResultSet result = sql.executeQuery();

            while(result.next())
            {

                String pseudo = result.getString("customer_pseudo");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");
                int age = result.getInt("age");
                String passwd = result.getString("customer_pw");

                customer = new Customer(id, pseudo, firstname, lastname, age, passwd);

            }
            connection.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }

        return customer;
    }

    public boolean createCustomer(Customer customer)
    {
        return createCustomer(customer.getCustomer_pseudo(),customer.getFirstname(), customer.getLastname(), customer.getAge(), customer.getCustomer_pw());
    }
    public boolean createCustomer(String pseudo, String firstname, String lastname, int age, String passwd)
    {
        boolean success = false;
        int nbRow;
        try{
            Connection connection = dataSource.getConnection();

            PreparedStatement sql = connection.prepareStatement("INSERT INTO customer (customer_pseudo, firstname, lastname, age, customer_pw) VALUES (?,?,?,?,?)");

            sql.setObject(1,pseudo);
            sql.setObject(2, firstname);
            sql.setObject(3, lastname);
            sql.setObject(4, age);
            sql.setObject(5, passwd);

            nbRow = sql.executeUpdate();
            connection.close();

            if(nbRow > 0)//if row are created, return true
            {
                success = true;
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }

        return success;
    }

    public boolean deleteCustomer(long id)
    {
        boolean success = false;
        int nbRow;
        try{
            Connection connection = dataSource.getConnection();

            PreparedStatement sql = connection.prepareStatement("DELETE FROM customer WHERE customer_id = ?");

            sql.setLong(1, id);
            nbRow = sql.executeUpdate();
            connection.close();

            if(nbRow > 0)//if row are deleted, return true
            {
                success = true;
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return success;

    }

    public boolean updateCustomer(Customer customer)
    {
        boolean success = false;
        if(customer != null)
        {
            int nbRow;
            try{
                Connection connection = dataSource.getConnection();

                PreparedStatement sql = connection.prepareStatement("UPDATE Customer SET customer_pseudo = ?, firstname = ?, lastname = ?, age = ?, customer_pw = ? WHERE customer_id = ?");

                sql.setObject(1, customer.getCustomer_pseudo());
                sql.setObject(2, customer.getFirstname());
                sql.setObject(3, customer.getLastname());
                sql.setObject(4, customer.getAge());
                sql.setObject(5, customer.getCustomer_pw());
                sql.setObject(6, customer.getCustomer_id());

                nbRow = sql.executeUpdate();
                connection.close();

                if(nbRow > 0)//if row are updated, return true
                {
                    success = true;
                }
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return success;
    }

    public Customer Connection(String pseudo, String passwd)
    {
        Customer customer = null;
        try{
            Connection connection = dataSource.getConnection();

            PreparedStatement sql = connection.prepareStatement("SELECT * FROM customer WHERE customer_pseudo = ? AND customer_pw = ?");

            sql.setObject(1,pseudo);
            sql.setObject(2,passwd);

            ResultSet result = sql.executeQuery();
            if(result.next())
            {
                customer = getCustomer(result.getLong("customer_id"));
            }

            connection.close();
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }
}
