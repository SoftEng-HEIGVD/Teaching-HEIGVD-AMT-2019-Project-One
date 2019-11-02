package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.model.Character;
import ch.heigvd.amt.projectOne.model.Guild;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class GuildManager implements GuildManagerLocal {

    @Resource(lookup = "jdbc/amt")
    private DataSource dataSource;


    @Override
    public List<Guild> getAllGuilds() {
        List<Guild> guilds = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM guild");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                guilds.add(Guild.builder().id(id).name(name).description(description).build());
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return guilds;
    }

    @Override
    public Guild getGuildById(int id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM guild WHERE id=?");
            pstmt.setObject(1, id);

            ResultSet rs = pstmt.executeQuery();

            rs.next();
            String name = rs.getString("name");
            String description = rs.getString("description");

            connection.close();
            return Guild.builder().id(id).name(name).description(description).build();

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean addGuild(Guild guild) {
        ;

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO guild(name, description) VALUES (?, ?)");
            pstmt.setObject(1, guild.getName());
            pstmt.setObject(2, guild.getDescription());

            int row = pstmt.executeUpdate();

            connection.close();

            return row > 0;

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean updateGuild(Guild guild) {
        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE guild SET name=?, description=? WHERE id=?;");
            pstmt.setObject(1, guild.getName());
            pstmt.setObject(2, guild.getDescription());
            pstmt.setObject(2, guild.getId());

            int row = pstmt.executeUpdate();

            connection.close();

            return row > 0;


        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteGuild(Guild guild) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM guild WHERE id=?");
            pstmt.setObject(1, guild.getId());

            int row = pstmt.executeUpdate();

            connection.close();

            return row > 0;


        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
