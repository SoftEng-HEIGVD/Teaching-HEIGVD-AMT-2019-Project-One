package ch.heigvd.amt.project.business;

import javax.ejb.Local;

@Local
public interface IAuthenticationService {

  String hashPassword(String plainTextPassword);
  boolean checkPassword(String plainTextPassword, String hashedPassword);
}
