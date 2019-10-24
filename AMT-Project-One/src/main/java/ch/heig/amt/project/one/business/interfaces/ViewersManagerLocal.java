package ch.heig.amt.project.one.business.interfaces;

import ch.heig.amt.project.one.model.User;
import ch.heig.amt.project.one.model.Viewer;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ViewersManagerLocal {
    public boolean create(Viewer v);
    public List<Viewer> findAll(User u, int index, int offset);
    public Viewer findById(long id);
    public boolean update(Viewer v);
    public boolean delete(long id);
}
