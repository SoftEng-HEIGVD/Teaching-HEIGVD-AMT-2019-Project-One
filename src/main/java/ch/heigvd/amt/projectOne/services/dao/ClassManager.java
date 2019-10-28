package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.model.Class;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class ClassManager implements ClassManagerLocal {

    @Resource(lookup = "jdbc/amt")
    private DataSource dataSource;


    @Override
    public List<Class> fetchAllClass() {

        List<Class> classes = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM class");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String weapon = rs.getString("weapon");
                String armor = rs.getString("armor");
                String description = rs.getString("description");

                classes.add(new Class(id, name, weapon, armor, description));
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }

    @Override
    public Class getClassById(int id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM class WHERE id=?");
            pstmt.setObject(1, id);

            ResultSet rs = pstmt.executeQuery();

            rs.next();
            String name = rs.getString("name");
            String weapon = rs.getString("weapon");
            String armor = rs.getString("armor");
            String description = rs.getString("description");

            connection.close();
            return new Class(id, name, weapon, armor, description, null);

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
