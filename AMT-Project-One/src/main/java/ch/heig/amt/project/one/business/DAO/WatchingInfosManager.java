package ch.heig.amt.project.one.business.DAO;

import ch.heig.amt.project.one.business.interfaces.WatchingInfosManagerLocal;
import ch.heig.amt.project.one.model.Serie;
import ch.heig.amt.project.one.model.User;
import ch.heig.amt.project.one.model.Viewer;
import ch.heig.amt.project.one.model.WatchingInfo;

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
public class WatchingInfosManager implements WatchingInfosManagerLocal {
    @Resource(lookup = "jdbc/amtDatasource")
    private DataSource dataSource;

    @Override
    public boolean create(WatchingInfo w, User u) {
        boolean created = false;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO WatchingInfo(IDSerie, IDViewer, TimeSpent, BeginningDate, OwnerID) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setLong(1, w.getIdSerie());
            preparedStatement.setLong(2, w.getIdViewer());
            preparedStatement.setInt(3, w.getTimeSpent());
            java.util.Date dateWatchingInfo = w.getBeginningDate();
            java.sql.Date dateWatchingInfoDB = new java.sql.Date(dateWatchingInfo.getTime());
            preparedStatement.setDate(4, dateWatchingInfoDB);
            preparedStatement.setLong(5, u.getId());
            int row = preparedStatement.executeUpdate();
            if(row == 1) {
                created = true;
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.WatchingInfosManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return created;
    }

    public List<WatchingInfo> findByViewer(User u, Viewer viewer, int index, int offset) {
        List<WatchingInfo> watchingInfos = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM WatchingInfo WHERE IDViewer = ?, OwnerID = ?");
            preparedStatement.setLong(1, viewer.getId());
            preparedStatement.setLong(2, u.getId());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                long idSerie = rs.getLong("IDSerie");
                long idViewer = rs.getLong("IDViewer");
                int timeSpent = rs.getInt("TimeSpent");
                java.util.Date beginningDate = rs.getDate("BeginningDate");
                long idOwner = rs.getLong("OwnerID");

                WatchingInfo watchingInfo = WatchingInfo.builder().idSerie(idSerie).idViewer(idViewer).timeSpent(timeSpent).beginningDate(beginningDate).build();
                watchingInfo.setOwner(idOwner);
                watchingInfos.add(watchingInfo);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.WatchingInfosManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return watchingInfos;
    }

    @Override
    public WatchingInfo findOne(User u, long idSerie, long idViewer) {
        WatchingInfo watchingInfo = WatchingInfo.builder().build();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM WatchingInfo WHERE OwnerID = ? AND IDSerie = ? AND IDViewer = ?");
            preparedStatement.setLong(1, u.getId());
            preparedStatement.setLong(2, idSerie);
            preparedStatement.setLong(3, idViewer);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                long idSerieDB = rs.getLong("IDSerie");
                long idViewerDB = rs.getLong("IDViewer");
                int timeSpent = rs.getInt("TimeSpent");
                java.util.Date beginningDate = rs.getDate("BeginningDate");
                long idOwner = rs.getLong("OwnerID");

                watchingInfo = WatchingInfo.builder().idSerie(idSerieDB).idViewer(idViewerDB).timeSpent(timeSpent).beginningDate(beginningDate).build();
                watchingInfo.setOwner(idOwner);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.WatchingInfosManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return watchingInfo;
    }

    @Override
    public boolean update(WatchingInfo w) {
        boolean updated = false;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE WatchingInfo SET TimeSpent = ?, BeginningDate = ? WHERE IDSerie = ? AND IDViewer = ? AND OwnerID = ?");
            preparedStatement.setInt(1, w.getTimeSpent());
            java.util.Date dateWatchingInfo = w.getBeginningDate();
            java.sql.Date dateWatchingInfoDB = new java.sql.Date(dateWatchingInfo.getTime());
            preparedStatement.setDate(2, dateWatchingInfoDB);
            preparedStatement.setLong(3, w.getIdSerie());
            preparedStatement.setLong(4, w.getIdViewer());
            preparedStatement.setLong(5, w.getOwner());
            int row = preparedStatement.executeUpdate();
            if(row == 1) {
                updated = true;
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.WatchingInfosManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return updated;
    }

    @Override
    public boolean delete(long idSerie, long idViewer) {
        boolean deleted = false;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM WatchingInfo WHERE IDSerie = ? AND IDViewer = ?");
            preparedStatement.setLong(1, idSerie);
            preparedStatement.setLong(2, idViewer);
            int row = preparedStatement.executeUpdate();
            if(row == 1) {
                deleted = true;
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.WatchingInfosManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return deleted;
    }
}
