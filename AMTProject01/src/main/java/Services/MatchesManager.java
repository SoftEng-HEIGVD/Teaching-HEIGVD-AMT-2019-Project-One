/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Match;
import Model.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author goturak
 */
public class MatchesManager {
    PlayerManager pm= new PlayerManager();
    Map<Long,Match> matches= new HashMap<Long, Match>();

    public MatchesManager() {       ArrayList<Player> ps=new ArrayList(pm.getAllPLayers());
        Player[] tp1={ps.get(0),ps.get(1),ps.get(2),ps.get(3),ps.get(4)};
        Player[] tp2={ps.get(5),ps.get(6),ps.get(7),ps.get(8),ps.get(9)};
        matches.put( 1l,new Match(1,tp1,tp2,15,9));
        matches.put( 2l,new Match(2,tp2,tp1,15,2));
        matches.put( 3l,new Match(3,tp1,tp2,15,5));
        matches.put( 4l,new Match(4,tp2,tp1,13,15));
        matches.put( 5l,new Match(5,tp2,tp1,16,19));

    }
    
    public ArrayList<Match> getAll(){
        return new ArrayList<Match>(matches.values());
    }
          
    public Match getRandomMatch(){
        return matches.get(2);
    }
    
    public Match getMatch(long id){
        return matches.get(id);
    }
    
    public  ArrayList<Match>  getMatchesPlayedBy(Player p){
        ArrayList<Match> res=new ArrayList<>();
        for(Match m: getAll()){
            if(Arrays.asList(m.getTeam1Players()).contains(p)){
                res.add(m);
            }else if( Arrays.asList(m.getTeam2Players()).contains(p)){
                res.add(m);
            
            }
        }
        
        return res;
    }
}
