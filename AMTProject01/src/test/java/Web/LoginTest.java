/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;


import Model.Player;
import Model.User;
import Services.Match.MatchesManagerSQL;
import Services.Player.PlayerManagerSQL;
import Services.User.UserManagerSQL;
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
import javax.servlet.http.HttpSession;
import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


/**
 *
 * @author benjamin
 */

@ExtendWith(MockitoExtension.class)
public class LoginTest {
    
    
    @Mock
    HttpServletRequest request;
    
    @Mock
    HttpServletResponse response;
    
    @Mock
    HttpSession session;
    
    @Mock
    RequestDispatcher dispatcher;
    
    @Mock
    Login login;
    
    @Mock
    UserManagerSQL userManager;
    
    @Mock 
    User user;
    
    
    
    
    @BeforeEach
    public void setup() {
        login = new Login();
        login.userManager = userManager;
    }
    
    @Test
    public void doGetShouldDispatch() throws ServletException, IOException{
    
        when(request.getRequestDispatcher("WEB-INF/pages/Login.jsp")).thenReturn(dispatcher);
        

        login.doGet(request, response);

        verify(dispatcher, atLeastOnce()).forward(request, response);
        
}
    
    @Test
    public void doPotsShouldreturnOnLogout() throws ServletException, IOException{
    
        when(request.getParameter("logout")).thenReturn("true");
        
        when(request.getSession()).thenReturn(session);
        

        login.doPost(request, response);

       verify(response, atLeastOnce()).sendRedirect("login");
        
}
    
    @Test
    public void doPotsShouldForwardOnEmpty() throws ServletException, IOException{
    
        when(request.getParameter("logout")).thenReturn(null);
        
        when(request.getParameter("username")).thenReturn("");
        
        when(request.getParameter("pwd")).thenReturn("");
       when(request.getRequestDispatcher("WEB-INF/pages/Login.jsp")).thenReturn(dispatcher);
        login.doPost(request, response);

        verify(dispatcher, atLeastOnce()).forward(request, response);
  
        
}
    
    @Test
    public void doPotsShouldForwardOnFalseCredentials() throws ServletException, IOException{
    
        when(request.getParameter("logout")).thenReturn(null);
        
        when(request.getParameter("username")).thenReturn("goturak");
        
        when(request.getParameter("pwd")).thenReturn("passrd");
        
        when(request.getParameter("loginButton")).thenReturn("true");
        when(request.getRequestDispatcher("WEB-INF/pages/Login.jsp")).thenReturn(dispatcher);
        login.doPost(request, response);

        verify(dispatcher, atLeastOnce()).forward(request, response);
  
        
}
    
    
   
}
