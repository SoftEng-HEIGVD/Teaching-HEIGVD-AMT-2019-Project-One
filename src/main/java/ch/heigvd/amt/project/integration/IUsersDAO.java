package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.model.User;

import javax.ejb.Local;

@Local
public interface IUsersDAO extends IDAO<String, User> {

}
