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

    public boolean createCustomer()
    {

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

            if(nbRow > 0)//if row are updated, return true
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

    }
}
