package ch.heigvd.amt.projectone.DAO;

import ch.heigvd.amt.projectone.model.Player;

import javax.ejb.DuplicateKeyException;

public class PlayerDAO implements IPlayerDAO {
    @Override
    public Player create(Player entity) throws DuplicateKeyException {
        return null;
    }

    @Override
    public Player findById(String id) {
        return null;
    }

    @Override
    public void update(Player entity) {

    }

    @Override
    public void deleteById(String id) {

    }
}
