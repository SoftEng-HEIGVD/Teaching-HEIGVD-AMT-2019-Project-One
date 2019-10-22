package ch.heig.amt.project.one.dao;

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

    public List<Serie> findAllSeries() {
        List<Serie> series = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Serie");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("ID");
                String title = rs.getString("Title");
                String producer = rs.getString("Producer");
                String synopsis = rs.getString("Synopsis");
                String genre = rs.getString("Genre");
                int ageRestriction = rs.getInt("AgeRestriction");
                Serie tmp = Serie.builder().genre(genre).title(title).producer(producer).synopsis(synopsis).ageRestriction(ageRestriction).build();
                tmp.setId(id);
                series.add(tmp);
            }
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(SeriesManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return series;
    }
}
