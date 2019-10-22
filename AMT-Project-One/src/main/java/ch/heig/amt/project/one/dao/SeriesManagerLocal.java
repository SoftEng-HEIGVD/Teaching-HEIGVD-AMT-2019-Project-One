package ch.heig.amt.project.one.dao;

import ch.heig.amt.project.one.model.Serie;

import javax.ejb.Local;
import java.util.List;

@Local
public interface SeriesManagerLocal {
    public List<Serie> findAllSeries();
}
