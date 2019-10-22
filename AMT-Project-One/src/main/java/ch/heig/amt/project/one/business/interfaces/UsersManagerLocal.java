package ch.heig.amt.project.one.business.interfaces;

import ch.heig.amt.project.one.model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsersManagerLocal {
    public boolean create(User u);
    public List<User> findAll();
    public User findById(long id);
    public boolean update(User u);
    public boolean delete(User u);
}
