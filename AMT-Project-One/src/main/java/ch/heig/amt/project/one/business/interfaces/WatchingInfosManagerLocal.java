package ch.heig.amt.project.one.business.interfaces;

import ch.heig.amt.project.one.model.Serie;
import ch.heig.amt.project.one.model.User;
import ch.heig.amt.project.one.model.Viewer;
import ch.heig.amt.project.one.model.WatchingInfo;

import javax.ejb.Local;
import java.util.List;

@Local
public interface WatchingInfosManagerLocal {
    public boolean create(WatchingInfo w);
    public List<WatchingInfo> findByViewer(User u, Viewer viewer, int index, int offset);
    public WatchingInfo findOne(User u, long idSerie, long idViewer);
    public boolean update(WatchingInfo w);
    public boolean delete(long idSerie, long idViewer);
}
