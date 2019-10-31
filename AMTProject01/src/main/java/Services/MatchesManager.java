/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Match;
import Model.Player;
import java.util.ArrayList;

/**
 *
 * @author goturak
 */
public class MatchesManager {
    PlayerManager pm= new PlayerManager();
    public Match getRandomMatch(){
        ArrayList<Player> ps=new ArrayList(pm.getAllPLayers());
        Player[] tp1={ps.get(0),ps.get(1),ps.get(2),ps.get(3),ps.get(4)};
        Player[] tp2={ps.get(5),ps.get(6),ps.get(7),ps.get(8),ps.get(9)};
        return new Match(tp1,tp2,15,9);
    }
}
