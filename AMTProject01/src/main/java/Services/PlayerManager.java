/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Player;
import Model.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

public interface PlayerManager {
    
    public Player getRandomPlayer();
    
    public List<Player> getAllPLayers();
    
    public Player getPlayer(String userName);

    
    public void Add(Player p);
    public List<Player> getPlayersFrom(Team t) ;
    
    
}
