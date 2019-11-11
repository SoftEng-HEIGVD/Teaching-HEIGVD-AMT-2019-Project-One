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
        return new Player("Goturak","Luca",1);
    }
    @Override
    public List<Player> getAllPlayers(int creator){  
        
        ArrayList<Player> players = new ArrayList();
        
        
        try {
        Connection connection = dataSource.getConnection();
//        PreparedStatement pstmt = connection.prepareStatement("SELECT Player.pseudo AS pseudo, Player.name AS name, Team.name AS team "
//                                                            + "FROM Player JOIN Team ON Player.team_id = Team.team_id");
        PreparedStatement pstmt = connection.prepareStatement("SELECT player_id,pseudo,name,team,team_id,creator_id FROM PlayerWithTeam WHERE creator_id="+creator);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          String name = rs.getString("name");
          String pseudo = rs.getString("pseudo");
          String team = rs.getString("team");
          int player_id = rs.getInt("player_id");
          int team_id = rs.getInt("team_id");
          
          players.add(new Player(player_id,pseudo,name,new Team(team_id,team),0));
        }
        pstmt.close();
        connection.close();
     
    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }        
          return players;
    }
    @Override
    public Player getPlayer(String userName,int creator){
        
        int player_id =0;
        int team_id = 0;
        String name ="";
        String pseudo="";
        String team = "";
        int creatorId=0;
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT player_id,pseudo,name,team,team_id,creator_id FROM PlayerWithTeam WHERE creator_id="+creator+" AND pseudo='"+userName+"'");
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
           name = rs.getString("name");
           pseudo = rs.getString("pseudo"); 
           team = rs.getString("team");
           player_id = rs.getInt("player_id");
           team_id = rs.getInt("team_id");
           creatorId = rs.getInt("creator_id");

        }
        pstmt.close();
          connection.close();
    
    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }        
        return  new Player(player_id,pseudo,name,new Team(team_id,team),creatorId);
    }
    
    @Override
    public ArrayList<Player> getPlayerPartial(String userName,int creator){
        
        
        ArrayList<Player> players = new ArrayList();
    
        
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT player_id,pseudo,name,team,team_id,creator_id FROM PlayerWithTeam WHERE creator_id="+creator+" AND pseudo LIKE'"+userName+"%'");
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
          String name = rs.getString("name");
          String pseudo = rs.getString("pseudo"); 
          String team = rs.getString("team");
           int player_id = rs.getInt("player_id");
          int team_id = rs.getInt("team_id");
           int creatorId = rs.getInt("creator_id");
           players.add(new Player(player_id,pseudo,name,new Team(team_id,team),creatorId));
        }
        pstmt.close();
      connection.close();
    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }        
        return  players;
    }
    
    @Override
    public List<Player> getPlayersFrom(Team t,int creator){
    
        ArrayList<Player> players = new ArrayList();
        
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT player_id,pseudo,name,creator_id FROM PlayerWithTeam WHERE creator_id="+creator+" AND team_id = "+t.getId());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          String name = rs.getString("name");
          String pseudo = rs.getString("pseudo");
          int id = rs.getInt("player_id");
                    int creatorId = rs.getInt("creator_id");

          players.add(new Player(id,pseudo,name,new Team(t.getId(),t.getName()),creatorId));
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
          int creatorId = rs.getInt("creator_id");
          players.add(new Player(player_id,pseudo,name,new Team(team_id,team),creatorId));
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
           int creatorId = rs.getInt("creator_id");
          players.add(new Player(player_id,pseudo,name,new Team(team_id,team),creatorId));
        }
        pstmt.close();
        connection.close();

    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }        
          return players;
    }


    @Override
    public void changePlayerTeam(Player p, Team t){
        
         try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("UPDATE `Player` SET team_id ="+t.getId()+ "WHERE player_id ="+p.getId());
         pstmt.execute();
       
        pstmt.close();
        connection.close();

    } catch (SQLException ex) {
      Logger.getLogger(PlayerManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        
    }
    
    @Override
    public void Add(Player p){
        
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `Player`(`pseudo`,`name`,`team_id`,`creator_id`) VALUES\n" +
                                                               "('"+p.getUserName()+"','"+p.getName()+"',"+p.getTeam().getId()+","+p.getCreatorId()+")");
             pstmt.execute();

            pstmt.close();
connection.close();
        } catch (SQLException ex) {
          Logger.getLogger(PlayerManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @Override
    public int getNumberOfPlayers(int creator){
        
        int number = 0;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(*) AS count FROM Player WHERE creator_id="+creator);
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
    public void DeletePlayer(Player p){
        
        try {
        Connection connection = dataSource.getConnection();
        
        
        PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Player WHERE player_id="+p.getId());
         pstmt.execute();
       
        pstmt.close();
        connection.close();

      
    } catch (SQLException ex) {
      Logger.getLogger(PlayerManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    } 
        
        
        
    }
 
}
