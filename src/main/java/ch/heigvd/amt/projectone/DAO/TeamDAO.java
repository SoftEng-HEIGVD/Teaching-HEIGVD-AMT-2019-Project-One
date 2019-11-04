package ch.heigvd.amt.projectone.DAO;

import ch.heigvd.amt.projectone.business.IAuthentification;
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
public class TeamDAO implements ITeamDAO {

    @Resource(lookup = "java:/jdbc/fmDS")
    DataSource dataSource;

    @Override
    public Team create(Team entity) throws DuplicateKeyException {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("INSERT INTO amt_teams (NAME, CREATIONDATE, LOCATION) VALUES (?, ?, ?)");
            statement.setString(1, entity.getName());
            statement.setDate(2, entity.getDateCreation());
            statement.setString(3, entity.getLocation());
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
    public Team findById(String name) {

        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT NAME, CREATIONDATE, LOCATION FROM amt_teams WHERE NAME = ?");

            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            boolean hasRecord = rs.next();
            if (!hasRecord) {
                // code d erreur
            }
            Team existingTeam = Team.builder()
                    .name(rs.getString(1))
                    .dateCreation(rs.getDate(2))
                    .location(rs.getString(3))
                    .build();
            return existingTeam;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(con);
        }

    }

    @Override
    public void update(Team entity) {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("UPDATE amt_teams SET NAME=?, CREATIONDATE=?, LOCATION=? WHERE NAME = ?");
            statement.setString(1, entity.getName());
            statement.setDate(2, entity.getDateCreation());
            statement.setString(3, entity.getLocation());
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
    public void deleteById(String name) {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("DELETE FROM amt_teams WHERE NAME = ?");
            statement.setString(1, name);
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
