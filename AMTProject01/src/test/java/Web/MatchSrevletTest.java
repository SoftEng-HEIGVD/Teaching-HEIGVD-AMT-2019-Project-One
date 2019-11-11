/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;
import Model.Match;
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
public class MatchSrevletTest {
    
    
    @Mock
    HttpServletRequest request;
    
    @Mock
    HttpServletResponse response;
    
    @Mock
    MatchServlet servlet;
    
    @Mock
    PlayerManagerSQL playerManager; 
    
    @Mock
    MatchesManagerSQL matchManager;
    
    @Mock
    RequestDispatcher dispatcher;
    
    @Mock
    Player player;
    
    @Mock
    HttpSession session;
    
    @Mock
    Match match;
   
    
    @BeforeEach
    public void setup() {
        servlet = new MatchServlet();
        servlet.pm = playerManager;
        servlet.mm = matchManager;
        
            
    }
    
    @Test
    public void doGetshouldsetMatchrRight() throws ServletException, IOException{
        
        
        when(request.getParameter("id")).thenReturn("2");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("id")).thenReturn(1);
        when(matchManager.getMatch(2,1)).thenReturn(match);
        when(request.getRequestDispatcher("WEB-INF/pages/Match.jsp")).thenReturn(dispatcher);
        servlet.doGet(request, response);
        
        
        verify(dispatcher, atLeastOnce()).forward(request, response);
        verify(request, atLeastOnce()).setAttribute("match", match);
        
        
    }
    
   
}


