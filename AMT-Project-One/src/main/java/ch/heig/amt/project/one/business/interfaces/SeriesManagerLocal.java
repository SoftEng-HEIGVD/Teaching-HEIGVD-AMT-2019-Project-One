package ch.heig.amt.project.one.business.interfaces;

import ch.heig.amt.project.one.model.Serie;

import javax.ejb.Local;
import java.util.List;

@Local
public interface SeriesManagerLocal {
    public boolean create(Serie s);
    public List<Serie> findAll();
    public Serie findById(long id);
    public boolean update(Serie s);
    public boolean delete(Serie s);
}
