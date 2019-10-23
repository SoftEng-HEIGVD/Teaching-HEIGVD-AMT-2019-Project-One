package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.model.Character;
import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface CharacterManagerLocal {

    public List<Character> findAllCharacters();

    public boolean addCharacter(String username, String password);

    public Character getCharacterById(int id);

    Character getCharacterByUsername(String username);

    public boolean isUsernameFree(String username);
}
