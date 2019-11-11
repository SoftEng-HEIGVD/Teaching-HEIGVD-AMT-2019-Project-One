/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.User;

import Model.User;
import Services.Player.PlayerManagerSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author goturak
 */
public class UserManagerSQL implements UserManager{

     @Resource(lookup = "jdbc/TeamEsport")
    private DataSource dataSource;   
    
    
    
    public UserManagerSQL() {
        
        try{InitialContext ctx = new InitialContext();
        dataSource =(DataSource)ctx.lookup("jdbc/TeamEsport");
        }catch(Exception e){}
    }
    
    @Override
    public void add(User u) {
       
        try {
           Connection connection = dataSource.getConnection();
           PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `User`(`name`,`pwd`) VALUES\n" +
                                                                 "('"+u.getName()+"','"+u.getPwd()+"')");
            pstmt.execute();

           pstmt.close();
           connection.close();

       } catch (SQLException ex) {
         Logger.getLogger(PlayerManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
       }    
    }

    @Override
    public User get(String username) {
          int id = 0;
        String name ="";
        String pwd="";
        boolean result= false;
         try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `User` WHERE name = '"+username+"'");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            result=true;
            id = rs.getInt("user_id");
            name = rs.getString("name");
            pwd = rs.getString("pwd");
        }
        pstmt.close();
        connection.close();
      
    } catch (SQLException ex) {
      Logger.getLogger(UserManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(result){
            return new User(id,name,pwd);           
        }else{
            return null;
        }

    }

    @Override
    public void delete(int id) {
            try {
                   Connection connection = dataSource.getConnection();


                   PreparedStatement pstmt = connection.prepareStatement("DELETE FROM User WHERE user_id="+id);
                    pstmt.execute();

                   pstmt.close();


               } catch (SQLException ex) {
                 Logger.getLogger(PlayerManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
               } 
    }
    
}
