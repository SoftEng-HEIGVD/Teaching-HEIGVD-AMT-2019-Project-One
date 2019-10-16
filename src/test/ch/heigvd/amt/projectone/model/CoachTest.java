package ch.heigvd.amt.projectone.model;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class CoachTest {
    private LinkedList<Player> players = new LinkedList<>();
    private Team team;

    @Test
    public void createCoach(){
        players.add(new Player("Teklehaimanot", "Nair","AVG"));
        players.add(new Player("Alic","Robel","AVD"));

        team = new Team("HEIG", players);


        Coach coach = Coach.builder()
                .nom("Alic")
                .prenom("Robel")
                .team(team).build();

        assertNotNull(coach);
        assertEquals("Alic",coach.getNom());
    }

}