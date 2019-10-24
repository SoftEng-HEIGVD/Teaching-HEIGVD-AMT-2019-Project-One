package ch.heig.amt.project.one.business.interfaces;

import ch.heig.amt.project.one.model.User;

import javax.ejb.Local;

@Local
public interface UsersManagerLocal {
    public boolean create(String username, String password);
    public boolean validConnection(String username, String password);
    public User findUserByUsername(String username);
}
