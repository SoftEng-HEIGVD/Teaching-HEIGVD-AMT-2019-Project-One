package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.model.Class;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ClassManagerLocal {

    public List<Class> fetchAllClass();

    public Class getClassById(int id);
}
