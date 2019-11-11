package ch.heigvd.amt.projectone.model;

import org.junit.Test;

import java.sql.Date;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class CoachTest {
    private LinkedList<Player> players = new LinkedList<>();
    private Team team;

    @Test
    public void createCoach(){


        team = new Team("HEIG", "Yverdon", new Date(22051993));
        players.add(new Player("Teklehaimanot", "Nair","AVG",22,team));
        players.add(new Player("Alic","Robel","AVD",33,team));


        Coach coach = Coach.builder()
                .lastName("Alic")
                .firstName("Robel").build();
        assertNotNull(coach);
        assertEquals("Alic",coach.getLastName());
        assertEquals("Robel", coach.getFirstName());
    }

}