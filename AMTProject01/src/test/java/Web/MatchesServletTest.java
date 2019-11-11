/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;


import Model.Player;
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
public class MatchesServletTest {
    
    
    @Mock
    HttpServletRequest request;
    
    @Mock
    HttpServletResponse response;
    
    @Mock
    MatchesServlet servlet;
    
    @Mock
    MatchesManagerSQL matchManager;   
    
    @Mock
    RequestDispatcher dispatcher;
    
    @Mock
    Player player;
    
    
    
    @BeforeEach
    public void setup() {
        servlet = new MatchesServlet();
        servlet.mm = matchManager;
    }
    
    @Test
    public void doGetShouldDispatch() throws ServletException, IOException{
    
        when(request.getRequestDispatcher("WEB-INF/pages/matches.jsp")).thenReturn(dispatcher);
        

        servlet.doGet(request, response);

        verify(dispatcher, atLeastOnce()).forward(request, response);
        
}
    
    
   
}
