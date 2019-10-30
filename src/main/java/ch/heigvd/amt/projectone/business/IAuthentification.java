package ch.heigvd.amt.projectone.business;


import javax.ejb.Local;

@Local
public interface IAuthentification {
    public String hashPassword(String plainTextPassword);
    public boolean checkPassword(String plainTextPassword, String hashedPassword);
}
