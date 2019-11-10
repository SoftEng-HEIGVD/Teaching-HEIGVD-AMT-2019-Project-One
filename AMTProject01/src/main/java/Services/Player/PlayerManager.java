/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Player;

import Model.Player;
import Model.Team;
import java.util.List;



/**
 *
 * @author goturak
 */

public interface PlayerManager {
    
    public Player getRandomPlayer();
    
    public List<Player> getAllPlayers();
    
    public Player getPlayer(String userName);

    
    public void Add(Player p);
    public List<Player> getPlayersFrom(Team t) ;
    
    public List<Player> getPlayersFromMatchTeam1(long match_id) ;
    public List<Player> getPlayersFromMatchTeam2(long match_id) ;
    
}
