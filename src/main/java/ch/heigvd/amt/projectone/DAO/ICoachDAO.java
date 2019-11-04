package ch.heigvd.amt.projectone.DAO;

import ch.heigvd.amt.projectone.model.Coach;

import javax.ejb.Local;

@Local
public interface ICoachDAO extends IDAO<String, Coach>  {
}
