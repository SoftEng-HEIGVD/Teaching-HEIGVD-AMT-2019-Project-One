package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.model.Character;
import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface CharacterManagerLocal {

    public List<Character> findAllCharacters() throws SQLException;

    public boolean addCharacter(String username, String password) throws SQLException;
}
