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
public class PlayerTest {
        
    @Test
    public void shouldHaveATeam(){
        
        
        Player player = new Player("kaerdhalis","benji",1);
        assertEquals(player.getTeam().getId(),1);
        assertEquals(player.getTeam().getName(),"no_team");
    }
    
    
    @Test
    public void shouldCreateCorrectPlayer(){
    
    Player player = new Player("kaerdhalis","benji",1);
    
    assertEquals(player.getUserName(),"kaerdhalis");
    assertEquals(player.getName(),"benji");
    
    player = new Player(1,"kaerdhalis","benji",new Team(1,"amt"),1);
    
    assertEquals(player.getId(),1);
    assertEquals(player.getTeam().getId(),1);
    assertEquals(player.getTeam().getName(),"amt");
    
}
    
}
