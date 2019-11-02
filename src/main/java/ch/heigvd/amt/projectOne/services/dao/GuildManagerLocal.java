package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.model.Character;
import ch.heigvd.amt.projectOne.model.Guild;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GuildManagerLocal {

    List<Guild> getAllGuilds();

    Guild getGuildById(int id);

    boolean addGuild(Guild guild);

    boolean updateGuild(Guild guild);

    boolean deleteGuild(Guild guild);

}
