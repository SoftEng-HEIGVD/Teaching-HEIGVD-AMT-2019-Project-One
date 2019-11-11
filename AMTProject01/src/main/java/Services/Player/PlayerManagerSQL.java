/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Player;

import Model.Player;
import Model.Team;
import Services.Team.TeamManagerSQL;
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
//        PreparedStatement pstmt = connection.prepareStatement("SELECT Player.pseudo AS pseudo, Player.name AS name, Team.name AS team "
//                                                            + "FROM Player JOIN Team ON Player.team_id = Team.team_id");
        PreparedStatement pstmt = connection.prepareStatement("SELECT player_id,pseudo,name,team,team_id FROM PlayerWithTeam");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          String name = rs.getString("name");
          String pseudo = rs.getString("pseudo");
          String team = rs.getString("team");
          int player_id = rs.getInt("player_id");
          int team_id = rs.getInt("team_id");
          players.add(new Player(player_id,pseudo,name,new Team(team_id,team)));
        }
        pstmt.close();
         connection.close();
     
    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }        
          return players;
    }
    @Override
    public Player getPlayer(String userName){
        
        int player_id =0;
        int team_id = 0;
        String name ="";
        String pseudo="";
        String team = "";
        
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT player_id,pseudo,name,team,team_id FROM PlayerWithTeam WHERE pseudo='"+userName+"'");
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
           name = rs.getString("name");
           pseudo = rs.getString("pseudo"); 
           team = rs.getString("team");
           player_id = rs.getInt("player_id");
           team_id = rs.getInt("team_id");
        }
        pstmt.close();
          connection.close();
    
    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }        
        return  new Player(player_id,pseudo,name,new Team(team_id,team));
    }
    
    @Override
    public List<Player> getPlayersFrom(Team t){
    
        ArrayList<Player> players = new ArrayList();
        
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT player_id,pseudo,name FROM PlayerWithTeam WHERE team_id = "+t.getId());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          String name = rs.getString("name");
          String pseudo = rs.getString("pseudo");
          int id = rs.getInt("player_id");
          players.add(new Player(id,pseudo,name,new Team(t.getId(),t.getName())));
        }
        pstmt.close();
        connection.close();
     
    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }        
          return players;
        
    }
    @Override
    public List<Player> getPlayersFromMatchTeam1(long match_id){
        
        ArrayList<Player> players = new ArrayList();
        
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT  PlayerWithTeam.player_id,pseudo,name, PlayerWithTeam.team_id as team_id,team FROM PlayerWithTeam\n" +
"                INNER JOIN Matches_Player ON PlayerWithTeam.player_id = Matches_Player.player_id WHERE Matches_Player.team_id=1 AND Matches_Player.match_id ="+match_id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          String name = rs.getString("name");
          String pseudo = rs.getString("pseudo");
          int player_id = rs.getInt("player_id");
          int team_id = rs.getInt("team_id");
          String team = rs.getString("team");
          players.add(new Player(player_id,pseudo,name,new Team(team_id,team)));
        }
        pstmt.close();
        connection.close();
    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }       
        
          return players;
        
    }
    @Override
    public List<Player> getPlayersFromMatchTeam2(long match_id) {
        
        
         ArrayList<Player> players = new ArrayList();
        
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT  PlayerWithTeam.player_id,pseudo,name, PlayerWithTeam.team_id as team_id,team FROM PlayerWithTeam\n" +
"                INNER JOIN Matches_Player ON PlayerWithTeam.player_id = Matches_Player.player_id WHERE Matches_Player.team_id=2 AND Matches_Player.match_id ="+match_id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          String name = rs.getString("name");
          String pseudo = rs.getString("pseudo");
          int player_id = rs.getInt("player_id");
          int team_id = rs.getInt("team_id");
          String team = rs.getString("team");
          players.add(new Player(player_id,pseudo,name,new Team(team_id,team)));
        }
        pstmt.close();
        connection.close();

    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }        
          return players;
    }


    @Override
    public void Add(Player p){
        
    try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `Player`(`pseudo`,`name`,`team_id`) VALUES\n" +
"    ('"+p.getUserName()+"','"+p.getName()+"',"+p.getTeam().getId()+")");
         pstmt.execute();
       
        pstmt.close();
        connection.close();

    } catch (SQLException ex) {
      Logger.getLogger(PlayerManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }        
    }
    
    
    
}
