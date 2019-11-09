package ch.heigvd.amt.projectone.DAO;

import ch.heigvd.amt.projectone.model.Coach;
import javax.ejb.Local;
import java.util.List;

@Local
public interface ICoachDAO extends IDAO<String, Coach>  {
    List<Coach> findAllCoach();

}
