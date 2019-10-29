package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.model.Character;
import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface CharacterManagerLocal {

    public int countRows(String table);

    List<Character> findAllCharacters();

    List<Character> getCharactersByFirstLetter(String letter, int pageNumber);

    List<Character> getCharactersByPage(int pageNumber);

    boolean addCharacter(String username, String password);

    Character getCharacterById(int id);

    Character getCharacterByUsername(String username);

    boolean isUsernameFree(String username);
}
