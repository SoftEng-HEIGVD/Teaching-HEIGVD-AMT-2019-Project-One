/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Match;

import Model.Team;
import Model.Match;
import Model.Player;
import Model.Team;
import java.util.ArrayList;

/**
 *
 * @author benjamin
 */
public interface MatchesManager {
    
    public ArrayList<Match> getAll(int creator);
    
    public Match getMatch(long id,int creator);
    
    public  ArrayList<Match>  getMatchesPlayedBy(Player p,int creator);
    


    public ArrayList<Match> getMatchesPlayedbyTeam(Team t,int creator);


    
    public void addMatch(Match match,ArrayList<Player>team1,ArrayList<Player>team2);
    
    public void addMatch(Match match,int[] team1,int[]team2);
    
        public int getNumberOfMatch(int creator);
         public void DeleteMatch(long id);
          
}
