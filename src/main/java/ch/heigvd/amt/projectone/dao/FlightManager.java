package main.java.ch.heigvd.amt.projectone.dao;

import main.java.ch.heigvd.amt.projectone.model.Flight;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless
public class FlightManager
{
    @Resource(lookup = "java:/jdbc/FlightCompany")
    private DataSource dataSource;

    public Flight getCustomer(long id)
    {
        Flight flight = null;
        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement sql = connection.prepareStatement("SELECT * FROM flight WHERE flight_id = ?");
            sql.setObject(1, id);

            ResultSet result = sql.executeQuery();

            while(result.next())
            {

                String name = result.getString("name");
                int departureTime = result.getInt("departure_time");
                int arrivalTime = result.getInt("arrival_time");
                String startPoint = result.getString("start_point");
                String endPoint = result.getString("end_point");
                int price = result.getInt("price");

                //To create timestamp convert, peut etre proposé deux getter dans le model ??
                flight = new Flight(id, pseudo, firstname, lastname, age, passwd);



            }
            connection.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }

        return flight;
    }

    public boolean createCustomer(Flight customer)
    {
        return createCustomer(customer.getCustomer_pseudo(),customer.getFirstname(), customer.getLastname(), customer.getAge(), customer.getCustomer_pw());
    }
    public boolean createCustomer(String pseudo, String firstname, String lastname, int age, String passwd)
    {
        boolean success = false;
        int nbRow;
        try{
            Connection connection = dataSource.getConnection();

            PreparedStatement sql = connection.prepareStatement("INSERT INTO flight (customer_pseudo, firstname, lastname, age, customer_pw) VALUES (?,?,?,?,?)");

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

    public boolean updateCustomer(Flight customer)
    {
        boolean success = false;
        if(customer != null)
        {
            int nbRow;
            try{
                Connection connection = dataSource.getConnection();

                PreparedStatement sql = connection.prepareStatement("UPDATE Flight SET customer_pseudo = ?, firstname = ?, lastname = ?, age = ?, customer_pw = ? WHERE customer_id = ?");

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

    public Flight Connection(String pseudo, String passwd)
    {
        Flight customer = null;
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
