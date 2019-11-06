package ch.heigvd.amt.projectone.DAO;

import ch.heigvd.amt.projectone.business.IAuthentification;
import ch.heigvd.amt.projectone.model.Coach;
import ch.heigvd.amt.projectone.model.Team;

import javax.annotation.Resource;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless
public class CoachDAO implements ICoachDAO {

    @Resource(lookup = "java:/jdbc/fmDS")
    DataSource dataSource;



    @Override
    public Coach create(Coach entity) throws DuplicateKeyException {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("INSERT INTO amt_coaches (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, NAMETEAM, ISADMIN) VALUES (?, ?, ?, ?, ?,?)");
            statement.setString(1, entity.getUsername());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getFirstName());
            statement.setString(4, entity.getLastName());
            statement.setString(5, entity.getTeam().getName());
            statement.setBoolean(6, entity.getIsAdmin());
            statement.execute();
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(con);
        }
    }

    @Override
    public Coach findById(String username) {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, NAMETEAM, LOCATION, CREATIONDATE, ISADMIN FROM amt_coaches,amt_teams WHERE USERNAME = ?");

            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            boolean hasRecord = rs.next();
            if (!hasRecord) {
                // code d erreur
            }
            Coach existingCoach = Coach.builder()
                    .username(rs.getString(1))
                    .password(rs.getString(2))
                    .firstName(rs.getString(3))
                    .lastName(rs.getString(4))
                    .team(Team.builder()
                            .name(rs.getString(5))
                            .location(rs.getString(6))
                            .dateCreation(rs.getDate(7))
                            .build())
                    .isAdmin(rs.getBoolean(8))
                    .build();
            return existingCoach;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(con);
        }

    }

    @Override
    public void update(Coach entity) {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("UPDATE amt_coaches SET USERNAME=?, PASSWORD=?, FIRST_NAME=?, LAST_NAME=?, NAMETEAM=?, ISADMIN=? WHERE USERNAME = ?");
            statement.setString(1, entity.getUsername());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getFirstName());
            statement.setString(4, entity.getLastName());
            statement.setObject(5, entity.getTeam());
            statement.setBoolean(6, entity.getIsAdmin());
            int numberOfUpdatedUsers = statement.executeUpdate();
            if (numberOfUpdatedUsers != 1) {
                // erreur
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(con);
        }
    }

    @Override
    public void deleteById(String username) {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("DELETE FROM amt_coaches WHERE USERNAME = ?");
            statement.setString(1, username);
            int numberOfDeletedUsers = statement.executeUpdate();
            if (numberOfDeletedUsers != 1) {
               // throw new KeyNotFoundException("Could not find user with username = " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(con);
        }
    }

    private void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


