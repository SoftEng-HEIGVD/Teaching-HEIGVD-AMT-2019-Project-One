package ch.heigvd.amt.projectone.business;
import org.mindrot.jbcrypt.BCrypt;



import javax.ejb.Stateless;

@Stateless
public class Authentification implements  IAuthentification {
    @Override
    public String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }


    @Override
    public boolean checkPassword(String plainTextPassword, String hashedPassword) {
        try {
            boolean correct = BCrypt.checkpw(plainTextPassword, hashedPassword);

            return correct;
        } catch (Exception e) {
            return false;
        }
    }
}