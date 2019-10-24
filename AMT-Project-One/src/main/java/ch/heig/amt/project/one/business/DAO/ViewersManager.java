package ch.heig.amt.project.one.business.DAO;

import ch.heig.amt.project.one.business.interfaces.ViewersManagerLocal;
import ch.heig.amt.project.one.model.User;
import ch.heig.amt.project.one.model.Viewer;

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
public class ViewersManager implements ViewersManagerLocal {
    @Resource(lookup = "jdbc/amtDatasource")
    private DataSource dataSource;

    @Override
    public boolean create(Viewer v) {
        boolean created = false;
        try {
            Connection connection = dataSource.getConnection();
            String querySql = "INSERT INTO Viewer(Firstname, Lastname, Username, Genre, Birthdate, OwnerID) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(querySql);
            preparedStatement.setString(1, v.getFirstname());
            preparedStatement.setString(2, v.getLastname());
            preparedStatement.setString(3, v.getUsername());
            preparedStatement.setString(4, v.getGenre());
            java.util.Date dateViewer = v.getBirthDate();
            java.sql.Date dateViewerDB = new java.sql.Date(dateViewer.getTime());
            preparedStatement.setDate(5, dateViewerDB);
            preparedStatement.setLong(6, v.getOwner());
            int row = preparedStatement.executeUpdate();
            if(row == 1) {
                created = true;
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.ViewersManager.class.getName()).log(Level.SEVERE, null, e);
        }

        return created;
    }

    @Override
    public List<Viewer> findAll(User u, int index, int offset) {
        List<Viewer> viewers = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Viewer WHERE OwnerID = ? LIMIT ?, ?");
            preparedStatement.setLong(1, u.getId());
            preparedStatement.setInt(2, index);
            preparedStatement.setInt(3, offset);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                long id = rs.getLong("ID");
                String firstname = rs.getString("Firstname");
                String lastname = rs.getString("Lastname");
                String username = rs.getString("Username");
                String genre = rs.getString("Genre");
                java.util.Date birthdate = rs.getDate("Birthdate");
                long ownerID = rs.getLong("OwnerID");

                Viewer viewer = Viewer.builder().firstname(firstname).lastname(lastname).username(username).genre(genre).birthDate(birthdate).build();
                viewer.setId(id);
                viewer.setOwner(ownerID);
                viewers.add(viewer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.ViewersManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return viewers;
    }

    @Override
    public Viewer findById(long id) {
        Viewer viewer = Viewer.builder().build();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Viewer WHERE ID = ?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                long idDb = rs.getLong("ID");
                String firstname = rs.getString("Firstname");
                String lastname = rs.getString("Lastname");
                String username = rs.getString("Username");
                String genre = rs.getString("Genre");
                java.util.Date birthdate = rs.getDate("Birthdate");
                long ownerID = rs.getLong("OwnerID");

                viewer = Viewer.builder().firstname(firstname).lastname(lastname).username(username).genre(genre).birthDate(birthdate).build();
                viewer.setId(idDb);
                viewer.setOwner(ownerID);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.ViewersManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return viewer;
    }

    @Override
    public boolean update(Viewer v) {
        boolean updated = false;
        try {
            Connection connection = dataSource.getConnection();
            String querySql = "UPDATE Viewer SET Firstname = ?, Lastname = ?, Username = ?, Genre = ?, Birthdate = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(querySql);
            preparedStatement.setString(1, v.getFirstname());
            preparedStatement.setString(2, v.getLastname());
            preparedStatement.setString(3, v.getUsername());
            preparedStatement.setString(4, v.getGenre());
            java.util.Date dateViewer = v.getBirthDate();
            java.sql.Date dateViewerDB = new java.sql.Date(dateViewer.getTime());
            preparedStatement.setDate(5, dateViewerDB);
            preparedStatement.setLong(6, v.getId());
            int row = preparedStatement.executeUpdate();
            if(row == 1) {
                updated = true;
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.ViewersManager.class.getName()).log(Level.SEVERE, null, e);
        }

        return updated;
    }

    @Override
    public boolean delete(long id) {
        boolean deleted = false;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Viewer WHERE ID = ?");
            preparedStatement.setLong(1, id);
            int row = preparedStatement.executeUpdate();
            if(row == 1) {
                deleted = true;
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.ViewersManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return deleted;
    }
}
