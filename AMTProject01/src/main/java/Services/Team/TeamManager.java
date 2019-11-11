/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Team;

import Model.Team;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benjamin
 */
public interface TeamManager {
    
    public List<Team> getAllTeams(int creator);
    public Team getTeam(String name,int creator);
    public ArrayList<Team> getTeamPartial(String name,int creator);
    public void addTeam(Team t);
    public int getNumberOfTeams(int creator);
    public void deleteTeam(Team t,int creator);
    
}
