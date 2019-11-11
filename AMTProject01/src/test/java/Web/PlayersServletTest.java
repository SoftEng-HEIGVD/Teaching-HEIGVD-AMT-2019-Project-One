/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;


import Services.Match.MatchesManagerSQL;
import Services.Player.PlayerManagerSQL;
import Web.PlayersServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


/**
 *
 * @author benjamin
 */

@ExtendWith(MockitoExtension.class)
public class PlayersServletTest {
    
    
    @Mock
    HttpServletRequest request;
    
    @Mock
    HttpServletResponse response;
    
    @Mock
    PlayersServlet servlet;
    
    @Mock
    PlayerManagerSQL playerManager;   
    
    @Mock
    RequestDispatcher dispatcher;
    
    
    
    @BeforeEach
    public void setup() {
        servlet = new PlayersServlet();
        servlet.playerManager = playerManager;
    }
    
    @Test
    public void basicTest(){
    
    assertEquals(true,true);
}
    
   
}
