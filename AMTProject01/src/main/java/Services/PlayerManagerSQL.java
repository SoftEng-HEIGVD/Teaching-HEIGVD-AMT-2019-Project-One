/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Player;
import Model.Team;
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
 * @author benjamin
 */
public class PlayerManagerSQL implements PlayerManager{
    
    @Resource(lookup = "jdbc/TeamEsport")
    private DataSource dataSource;   
    
     
    public PlayerManagerSQL() {
        
        try{InitialContext ctx = new InitialContext();
        dataSource =(DataSource)ctx.lookup("jdbc/TeamEsport");
        }catch(Exception e){}
    }
    
    @Override
    public Player getRandomPlayer(){
        return new Player("Goturak","Luca");
    }
    @Override
    public List<Player> getAllPlayers(){  
        
        ArrayList<Player> players = new ArrayList();
        
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT Player.pseudo AS pseudo, Player.name AS name, Team.name AS team "
                                                            + "FROM Player JOIN Team ON Player.team_id = Team.team_id");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          String name = rs.getString("name");
          String pseudo = rs.getString("pseudo");
          String team = rs.getString("team");
          players.add(new Player(pseudo,name,new Team(team)));
        }
        pstmt.close();
      
    } catch (SQLException ex) {
      Logger.getLogger(TeamManager.class.getName()).log(Level.SEVERE, null, ex);
    }        
          return players;
    }
    @Override
    public Player getPlayer(String userName){
        
        String name ="";
        String pseudo="";
        String team = "";
        
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT Player.pseudo AS pseudo, Player.name AS name, Team.name AS team "
                                                            + "FROM Player JOIN Team ON Player.team_id = Team.team_id WHERE pseudo= '"+userName+"'");
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
           name = rs.getString("name");
           pseudo = rs.getString("pseudo"); 
           team = rs.getString("team");
        }
        pstmt.close();
      
    } catch (SQLException ex) {
      Logger.getLogger(TeamManager.class.getName()).log(Level.SEVERE, null, ex);
    }        
        return  new Player(pseudo,name,new Team(team));
    }
    
    @Override
    public List<Player> getPlayersFrom(Team t){
    
          ArrayList<Player> players = new ArrayList();
        
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT Player.pseudo AS pseudo, Player.name AS name, Team.name AS team "
                                                            + "FROM Player JOIN Team ON Player.team_id = Team.team_id WHERE team= '"+t.getName()+"'");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          String name = rs.getString("name");
          String pseudo = rs.getString("pseudo");
          //long id = rs.getLong("actor_id");
          players.add(new Player(pseudo,name,new Team(t.getName())));
        }
        pstmt.close();
      
    } catch (SQLException ex) {
      Logger.getLogger(TeamManager.class.getName()).log(Level.SEVERE, null, ex);
    }        
          return players;
        
    }


    @Override
    public void Add(Player p){
//        
//    }
//    public List<Player> getPlayersFrom(Team t) {
//        List<Player> res= new ArrayList<Player>();
//        for(Player p: players.values()){
//            if(p.getTeam()!=null&& p.getTeam().getName()==t.getName()){
//                res.add(p);
//            }
//        }
//        
//        return res;
    }
    
    
    
}
