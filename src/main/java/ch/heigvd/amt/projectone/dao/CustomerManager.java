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

            PreparedStatement sql = connection.prepareStatement("SELECT * FROM customer WHERE id = ?");
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

    public Customer Connection(String pseudo, String passwd)
    {

    }
}
