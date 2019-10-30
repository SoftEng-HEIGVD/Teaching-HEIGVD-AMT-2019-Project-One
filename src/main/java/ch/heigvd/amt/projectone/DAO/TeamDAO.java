package ch.heigvd.amt.projectone.DAO;

import ch.heigvd.amt.projectone.business.IAuthentification;
import ch.heigvd.amt.projectone.model.Team;

import javax.annotation.Resource;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJB;
import javax.sql.DataSource;

public class TeamDAO implements ITeamDAO {

    @Resource(lookup = "java:/jdbc/fmDS")
    DataSource dataSource;

    @EJB
    IAuthentification authentication;

    @Override
    public Team create(Team entity) throws DuplicateKeyException {
        return null;
    }

    @Override
    public Team findById(String id) {
        return null;
    }

    @Override
    public void update(Team entity) {

    }

    @Override
    public void deleteById(String id) {

    }
}
