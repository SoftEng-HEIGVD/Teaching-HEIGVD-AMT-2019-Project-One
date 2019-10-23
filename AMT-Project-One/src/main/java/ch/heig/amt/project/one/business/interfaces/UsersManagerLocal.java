package ch.heig.amt.project.one.business.interfaces;

import ch.heig.amt.project.one.model.User;

import javax.ejb.Local;

@Local
public interface UsersManagerLocal {
    public boolean create(User u);
    public boolean connection(String username, String password);
    public User getUserByUsername(String username);
}
