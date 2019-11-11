package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.model.User;

import javax.ejb.Local;

@Local
public interface IUsersDAO extends IDAO<String, User> {

    /**
     * authenticate user with username and password againt his stored hashed password, using
     * authentication service ejb.
     * @param username username of the user
     * @param pass input password
     * @return true if authenticated
     */
    boolean authenticateUser(String username, String pass);

}
