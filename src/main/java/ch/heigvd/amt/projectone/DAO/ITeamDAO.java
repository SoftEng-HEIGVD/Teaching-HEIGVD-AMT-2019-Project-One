package ch.heigvd.amt.projectone.DAO;

import ch.heigvd.amt.projectone.model.Team;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ITeamDAO extends IDAO<String, Team> {
    List<Team> findAllTeam();
    List<Team> findMyTeam(String coach);
    public void addCoach(String c,String t);
}

