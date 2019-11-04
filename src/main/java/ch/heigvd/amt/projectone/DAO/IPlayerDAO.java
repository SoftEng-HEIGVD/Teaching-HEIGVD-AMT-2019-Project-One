package ch.heigvd.amt.projectone.DAO;

import ch.heigvd.amt.projectone.model.Player;

import javax.ejb.Local;

@Local
public interface IPlayerDAO extends IDAO<Integer, Player>  {
}
