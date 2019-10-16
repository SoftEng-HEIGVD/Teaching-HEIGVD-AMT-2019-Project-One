package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.model.Character;
import javax.ejb.Local;
import java.util.List;

@Local
public interface CharacterManagerLocal {
    public List<Character> findAllCharacters();
}
