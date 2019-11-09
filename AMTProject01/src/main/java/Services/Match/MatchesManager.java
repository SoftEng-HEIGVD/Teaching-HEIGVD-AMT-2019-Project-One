/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Match;

import Model.Match;
import Model.Player;
import java.util.ArrayList;

/**
 *
 * @author benjamin
 */
public interface MatchesManager {
    
    public ArrayList<Match> getAll();
    
    public Match getMatch(long id);
    
    public  ArrayList<Match>  getMatchesPlayedBy(Player p);
    
    public void addMatch(Match match,ArrayList<Player>team1,ArrayList<Player>team2);
    
    public void addMatch(Match match,int[] team1,int[]team2);
}
