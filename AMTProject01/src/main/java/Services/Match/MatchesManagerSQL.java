/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Match;

import Model.Match;
import Model.Player;
import Model.Team;
import Services.Player.PlayerManagerSQL;
import Services.Team.TeamManagerSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author goturak
 */
public class MatchesManagerSQL implements MatchesManager {
    
    @Resource(lookup = "jdbc/TeamEsport")
    private DataSource dataSource;   
//    PlayerManagerSQL pm= new PlayerManagerSQL();
//    Map<Long,Match> matches= new HashMap<Long, Match>();

    public MatchesManagerSQL() {       //
        //ArrayList<Player> ps=new ArrayList(pm.getAllPLayers());
//        Player[] tp1={ps.get(0),ps.get(1),ps.get(2),ps.get(3),ps.get(4)};
//        Player[] tp2={ps.get(5),ps.get(6),ps.get(7),ps.get(8),ps.get(9)};
//        matches.put( 1l,new Match(1,tp1,tp2,15,9));
//        matches.put( 2l,new Match(2,tp2,tp1,15,2));
//        matches.put( 3l,new Match(3,tp1,tp2,15,5));
//        matches.put( 4l,new Match(4,tp2,tp1,13,15));
//        matches.put( 5l,new Match(5,tp2,tp1,16,19));

            try{InitialContext ctx = new InitialContext();
        dataSource =(DataSource)ctx.lookup("jdbc/TeamEsport");
        }catch(Exception e){}




    }
    
    @Override
    public ArrayList<Match> getAll(int creator){
        
        ArrayList<Match> matches = new ArrayList();
        
         try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `MatchWithTeam` WHERE creator_id="+creator);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          int match_id = rs.getInt("match_id");
          int score_team1 = rs.getInt("score_team1");
          int score_team2 = rs.getInt("score_team2");
          int team1_id = rs.getInt("team1_id");
          int team2_id = rs.getInt("team2_id");
          String team1  = rs.getString("team1");
          String team2  = rs.getString("team2");
          
         
          matches.add(new Match(match_id,new Team(team1_id,team1),new Team(team2_id,team2),score_team1,score_team2));
                  
        }
        pstmt.close();
      
    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        return matches;
    }
          
    @Override
    public Match getMatch(long id, int creator){
        
        Match match = null;
        
         try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `MatchWithTeam` WHERE creator_id="+creator+" AND match_id ="+id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          int match_id = rs.getInt("match_id");
          int score_team1 = rs.getInt("score_team1");
          int score_team2 = rs.getInt("score_team2");
          int team1_id = rs.getInt("team1_id");
          int team2_id = rs.getInt("team1_id");
          String team1  = rs.getString("team1");
          String team2  = rs.getString("team2");
          
         
          match = new Match(match_id,new Team(team1_id,team1),new Team(team2_id,team2),score_team1,score_team2);
          
        }
        pstmt.close();
      
    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        
        
        
        
        return match;
    }
    
    @Override
     public ArrayList<Match> getMatchesPlayedbyTeam(Team t,int creator){
         
         ArrayList<Match> matches=new ArrayList<>();
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `MatchWithTeam` "
                + "WHERE creator_id="+creator+" AND (team1_id = "+t.getId()+" OR team2_id = "+t.getId()+")");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          int match_id = rs.getInt("match_id");
          int score_team1 = rs.getInt("score_team1");
          int score_team2 = rs.getInt("score_team2");
          int team1_id = rs.getInt("team1_id");
          int team2_id = rs.getInt("team1_id");
          String team1  = rs.getString("team1");
          String team2  = rs.getString("team2");
          
         
          matches.add(new Match(match_id,new Team(team1_id,team1),new Team(team2_id,team2),score_team1,score_team2));
                  
        }
        pstmt.close();
      
    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        return matches;
         
         
     }
    
    @Override
    public  ArrayList<Match>  getMatchesPlayedBy(Player p,int creator){
        ArrayList<Match> matches=new ArrayList<>();
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `MatchWithTeam`JOIN Matches_Player "
                + "ON MatchWithTeam.match_id = Matches_Player.match_id WHERE creator_id="+creator+" AND Matches_Player.player_id="+p.getId());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          int match_id = rs.getInt("match_id");
          int score_team1 = rs.getInt("score_team1");
          int score_team2 = rs.getInt("score_team2");
          int team1_id = rs.getInt("team1_id");
          int team2_id = rs.getInt("team1_id");
          String team1  = rs.getString("team1");
          String team2  = rs.getString("team2");
          
         
          matches.add(new Match(match_id,new Team(team1_id,team1),new Team(team2_id,team2),score_team1,score_team2));
                  
        }
        pstmt.close();
              connection.close();

    } catch (SQLException ex) {
      Logger.getLogger(TeamManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        return matches;
    }
    

    
    @Override
    public void addMatch(Match match,ArrayList<Player>team1,ArrayList<Player>team2){
        
    }
    
    
    @Override
    public void addMatch(Match match,int[] team1,int[]team2){
        
        int id = 0;
            try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `Matches`(`score_team1`,`score_team2`,`team1_id`,`team2_id`,`creator_id`) "
                + "VALUES ("+match.getTeam1EndScore()+","+match.getTeam2EndScore()+","+match.getTeam1().getId()+","+match.getTeam2().getId()+","+match.getCreator()+")",Statement.RETURN_GENERATED_KEYS);
         pstmt.executeUpdate();
         
         ResultSet rs=pstmt.getGeneratedKeys();
			
	if(rs.next()){
		id=rs.getInt(1);
	}
         
       
        pstmt.close();
         connection.close();
     
    } catch (SQLException ex) {
      Logger.getLogger(PlayerManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    }
            
            addPlayerToMatch(team1,1,id);
             addPlayerToMatch(team2,2,id);
        
    }
    
    
    
    @Override
    public int getNumberOfMatch(int creator){
        
        int number = 0;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(*) AS count FROM Matches WHERE creator_id="+creator);
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
    public void DeleteMatch(long id){
        
        try {
        Connection connection = dataSource.getConnection();
        
        
        PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Matches WHERE match_id="+id);
         pstmt.execute();
       
        pstmt.close();
        
      
    } catch (SQLException ex) {
      Logger.getLogger(PlayerManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    } 
        
        
        
    }
    
    
    private void addPlayerToMatch(int[] team,int teamNumber,long match_id){
        
        try {
        Connection connection = dataSource.getConnection();
        
        
        for(int i : team){
        
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `Matches_Player`(`match_id`,`team_id`,`player_id`) "
                + "VALUES ("+match_id+","+teamNumber+","+i+")");
         pstmt.execute();
       
        pstmt.close();
        connection.close();
        
        }
      
    } catch (SQLException ex) {
      Logger.getLogger(PlayerManagerSQL.class.getName()).log(Level.SEVERE, null, ex);
    } 
        
        
    }
}
