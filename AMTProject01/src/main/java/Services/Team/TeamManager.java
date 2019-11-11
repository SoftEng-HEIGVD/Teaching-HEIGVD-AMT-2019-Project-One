/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Team;

import Model.Team;
import java.util.List;

/**
 *
 * @author benjamin
 */
public interface TeamManager {
    
    public List<Team> getAllTeams();
    public Team getTeam(String name);
    
    public void addTeam(Team t);
    
}
