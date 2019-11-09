/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Services.Player.PlayerManagerSQL;
import Model.Match;
import Model.Player;
import Model.Team;
import Services.Team.TeamManagerSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author goturak
 */
public class MatchesManager {
    
    @Resource(lookup = "jdbc/TeamEsport")
    private DataSource dataSource;   
//    PlayerManagerSQL pm= new PlayerManagerSQL();
//    Map<Long,Match> matches= new HashMap<Long, Match>();

    public MatchesManager() {       //
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
    
    public ArrayList<Match> getAll(){
        
        ArrayList<Match> matches = new ArrayList();
        
         try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `MatchWithTeam`");
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
          
    
    public Match getMatch(long id){
        
        Match match = null;
        
         try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `MatchWithTeam` WHERE match_id ="+id);
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
    
    public  ArrayList<Match>  getMatchesPlayedBy(Player p){
        ArrayList<Match> matches=new ArrayList<>();
        try {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `MatchWithTeam`JOIN Matches_Player "
                + "ON MatchWithTeam.match_id = Matches_Player.match_id WHERE Matches_Player.player_id="+p.getId());
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
}
