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
public class MatchTest {
    
    @Test
    public void shouldCreateCorrectMatch(){
        
        Match match = new Match(1,new Team(1,"astralis"),new Team(2,"sunshine"),5,3);
        assertEquals(1,match.getId());
        assertEquals(5,match.getTeam1EndScore());
        assertEquals(3,match.getTeam2EndScore());
        assertEquals(1,match.getTeam1().getId());
        assertEquals(2,match.getTeam2().getId());
        
    }
    
}
