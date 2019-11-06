package ch.heigvd.amt.projectone.DAO;

import ch.heigvd.amt.projectone.model.Player;
import ch.heigvd.amt.projectone.model.Team;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IPlayerDAO extends IDAO<Integer, Player>  {
    List<Player> findAllPlayers();
    List<Player> findMyTeamPlayers(Team team);

}
