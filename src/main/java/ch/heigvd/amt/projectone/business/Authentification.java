package ch.heigvd.amt.projectone.business;



import javax.ejb.Stateless;

@Stateless
public class Authentification implements  IAuthentification {
    @Override
    public String hashPassword(String plainTextPassword) {
        return plainTextPassword;
    }

    @Override
    public boolean checkPassword(String plainTextPassword, String hashedPassword) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}