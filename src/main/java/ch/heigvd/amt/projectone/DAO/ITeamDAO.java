package ch.heigvd.amt.projectone.DAO;

import ch.heigvd.amt.projectone.model.Team;

import javax.ejb.Local;

@Local
public interface ITeamDAO extends IDAO<String, Team> {
}
