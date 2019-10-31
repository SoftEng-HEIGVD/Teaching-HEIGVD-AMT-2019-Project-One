/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Team;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

/**
 *
 * @author goturak
 */
public class TeamManager {
    
    private Map<String,Team>teams= new HashMap<String,Team>();

    public TeamManager() {
        teams.put("Solary",new Team("Solary"));
    }
    
    
    public List<Team> getAllTeams(){
        return new ArrayList<Team>(teams.values());
        
    }
    
    public Team getTeam(String name){
        return teams.get(name);
    }
    
}
