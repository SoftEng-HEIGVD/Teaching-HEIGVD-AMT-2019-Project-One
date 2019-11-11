/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Team;

import Model.Team;
import Services.Player.PlayerManagerSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author goturak
 */
public class TeamManagerSQL implements TeamManager{
    
    @Resource(lookup = "jdbc/TeamEsport")
    private DataSource dataSource;   
    
    
    
    public TeamManagerSQL() {
        
        try{InitialContext ctx = new InitialContext();
        dataSource =(DataSource)ctx.lookup("jdbc/TeamEsport");
        }catch(Exception e){}
    }
    
    @Override
    public List<Team> getAllTeams(int creator){
        
            ArrayList<Team> teams = new ArrayList();

        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `Team` WHERE creator_id="+creator);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          int id = rs.getInt("team_id");
          String name = rs.getString("name");
          teams.add(new Team(id,name));
        }
        pstmt.close();
        connection.close();
    
    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  teams;
  }
       
    @Override
    public Team getTeam(String name,int creator){
        
        int id = 0;
        String team ="";
        
         try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Team WHERE creator_id="+creator+" AND name = '"+name+"'");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          id = rs.getInt("team_id");
          team = rs.getString("name");
        }
        pstmt.close();
        connection.close();
      
    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  new Team(id,team);

    }
    
    @Override
    public ArrayList<Team> getTeamPartial(String name,int creator){
        
        ArrayList<Team> teams = new ArrayList();
        
         try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Team WHERE creator_id="+creator+" AND name LIKE '"+name+"%'");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          int id = rs.getInt("team_id");
          String team = rs.getString("name");
          teams.add(new Team(id,team));
        }
        pstmt.close();
              connection.close();

        } catch (SQLException ex) {
          Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  teams;

    }
    
    
    
    
    @Override
    public int getNumberOfTeams(int creator ){
        
        int number = 0;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(*) AS count FROM Team WHERE creator_id="+creator);
              ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
           number = rs.getInt("count");
        }
            pstmt.close();
            connection.close();

        } catch (SQLException ex) {
          Logger.getLogger(PlayerManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return number;
    }
    
    @Override
    public void addTeam(Team t){
        
       try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `Team`(`name`,`creator_id`) VALUES\n" +
                                                              "('"+t.getName()+"',"+t.getCreatorId()+")");
         pstmt.execute();
       
        pstmt.close();
        connection.close();
      
    } catch (SQLException ex) {
      Logger.getLogger(PlayerManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }        
    }
    
    
    @Override
    public void deleteTeam(Team t, int creator){
        
        try {
        Connection connection = dataSource.getConnection();
        
        
        PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Team WHERE creator_id="+creator+" AND team_id="+t.getId());
         pstmt.execute();
       
        pstmt.close();
        
      
    } catch (SQLException ex) {
      Logger.getLogger(PlayerManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    } 
        
    }
          
    
}
