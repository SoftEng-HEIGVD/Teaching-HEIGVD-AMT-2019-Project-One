package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.model.Character;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CharacterManagerLocal {

    int countRows(String table, String pattern);

    List<Character> getCharactersByPattern(String letter, int pageNumber);

    List<Character> getCharactersByPage(int pageNumber);

    boolean addCharacter(String username, String password, boolean isAdmin);

    boolean updateCharacter(int id, String username, String password, boolean isAdmin, boolean updatePassword);

    Character getCharacterById(int id);

    Character getCharacterByUsername(String username);

    boolean isUsernameFree(String username);

    boolean checkPassword(String username, String password);

    boolean deleteCharacter(int id);
}
