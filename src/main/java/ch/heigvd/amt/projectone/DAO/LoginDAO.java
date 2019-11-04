package ch.heigvd.amt.projectone.DAO;

import ch.heigvd.amt.projectone.business.IAuthentification;

import javax.annotation.Resource;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Stateless
public class LoginDAO {
    @Resource(lookup = "java:/jdbc/fmDS")
    DataSource dataSource;

    @EJB
    IAuthentification authentification;

    public boolean authentificate(String username, String pwd) throws SQLException {
        Boolean isLogin = false;
        Connection conn;
        try {
            conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT USERNAME,PASSWORD FROM amt_coaches WHERE USERNAME = ?");

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();
            boolean hasRecord = result.next();
            System.out.println(result.next());

            if (!hasRecord) {
            }

            if(pwd.equals(result.getString(2))){
                isLogin = true;
                System.out.println("User authenticated successfully");
            } else {
                System.out.println("Invalid username or password!");
            }

            return isLogin;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        }
    }

}
