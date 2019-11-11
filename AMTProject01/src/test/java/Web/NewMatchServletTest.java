/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;


import Model.Player;
import Model.Team;
import Services.Match.MatchesManagerSQL;
import Services.Player.PlayerManagerSQL;
import Services.Team.TeamManagerSQL;
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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


/**
 *
 * @author benjamin
 */

@ExtendWith(MockitoExtension.class)
public class NewMatchServletTest {
    
    
    @Mock
    HttpServletRequest request;
    
    @Mock
    HttpSession session;
    
    @Mock
    HttpServletResponse response;
    
    @Mock
    NewMatchServlet servlet;
    
    @Mock
    TeamManagerSQL teamManager;   
    
    @Mock
    PlayerManagerSQL playerManager;   
    
    @Mock
    RequestDispatcher dispatcher;
    
    @Mock
    Player player;
    
    @Mock
    List<Team> ts;
    
    @BeforeEach
    public void setup() {
        servlet = new NewMatchServlet();
        servlet.playerManager = playerManager;
        servlet.teamManager = teamManager;
    }
    
    @Test
    public void doPostShouldForwrd() throws ServletException, IOException{
    
        when(request.getParameter("userName")).thenReturn("goturak");
        when(request.getParameter("name")).thenReturn("goturak");
        when(request.getParameter("team")).thenReturn("astralis");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("id")).thenReturn(1);
        when(request.getRequestDispatcher("WEB-INF/pages/matchAdd.jsp")).thenReturn(dispatcher);
        

        servlet.doPost(request, response);

        
        verify(dispatcher, atLeastOnce()).forward(request, response);
        
}
    
  
  
    
    
   
}
