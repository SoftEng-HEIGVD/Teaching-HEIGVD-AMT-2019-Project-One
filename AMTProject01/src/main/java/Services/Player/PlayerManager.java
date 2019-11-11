/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Player;

import Model.Player;
import Model.Team;
import java.util.ArrayList;
import java.util.List;



/**  Interface listing all the needed Operation on Player entities
 * @author goturak
 */

public interface PlayerManager {
    
    public Player getRandomPlayer();
    
    public List<Player> getAllPlayers(int creator);
    
    public Player getPlayer(String userName,int creator);

    
    public void Add(Player p);
    public List<Player> getPlayersFrom(Team t,int creator) ;
   public ArrayList<Player> getPlayerPartial(String userName,int creator); 
    public List<Player> getPlayersFromMatchTeam1(long match_id) ;
    public List<Player> getPlayersFromMatchTeam2(long match_id) ;
    
    public void changePlayerTeam(Player p, Team t);
        public int getNumberOfPlayers(int creator);
        public void DeletePlayer(Player p);
    
}
