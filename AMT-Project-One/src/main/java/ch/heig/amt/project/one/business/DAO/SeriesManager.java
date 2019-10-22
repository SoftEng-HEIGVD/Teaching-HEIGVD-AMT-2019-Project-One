package ch.heig.amt.project.one.business.DAO;

import ch.heig.amt.project.one.business.interfaces.SeriesManagerLocal;
import ch.heig.amt.project.one.model.Serie;

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
public class SeriesManager implements SeriesManagerLocal {
    @Resource(lookup = "jdbc/amtDatasource")
    private DataSource dataSource;

    @Override
    public boolean create(Serie s) {
        return false;
    }

    @Override
    public List<Serie> findAll() {
        List<Serie> series = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Serie");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("ID");
                long ownerID = rs.getLong("OwnerID");
                String title = rs.getString("Title");
                String producer = rs.getString("Producer");
                String synopsis = rs.getString("Synopsis");
                String genre = rs.getString("Genre");
                int ageRestriction = rs.getInt("AgeRestriction");
                Serie tmp = Serie.builder().genre(genre).title(title).producer(producer).synopsis(synopsis).ageRestriction(ageRestriction).build();
                tmp.setId(id);
                tmp.setOwner(ownerID);
                series.add(tmp);
            }
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.SeriesManager.class.getName()).log(Level.SEVERE, null, e);
        }

        return series;
    }

    @Override
    public Serie findById(long id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Serie WHERE ID = ?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            long idSerie = rs.getLong("ID");
            long ownerID = rs.getLong("OwnerID");
            String title = rs.getString("Title");
            String producer = rs.getString("Producer");
            String synopsis = rs.getString("Synopsis");
            String genre = rs.getString("Genre");
            int ageRestriction = rs.getInt("AgeRestriction");
            Serie serie = Serie.builder().genre(genre).title(title).producer(producer).synopsis(synopsis).ageRestriction(ageRestriction).build();
            serie.setId(idSerie);
            serie.setOwner(ownerID);
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.SeriesManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean update(Serie s) {
        return false;
    }

    @Override
    public boolean delete(Serie s) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Serie WHERE ID = ?");
            preparedStatement.setLong(1, s.getId());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.SeriesManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
