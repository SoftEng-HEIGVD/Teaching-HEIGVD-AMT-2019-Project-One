/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author benjamin
 */
public class TeamTest {
    
    
    @Test
    public void shouldCreateCorrectTeam(){
        
        Team team = new Team(2,"astralis");
        assertEquals(2,team.getId());
        assertEquals("astralis",team.getName());
    }
    
}
