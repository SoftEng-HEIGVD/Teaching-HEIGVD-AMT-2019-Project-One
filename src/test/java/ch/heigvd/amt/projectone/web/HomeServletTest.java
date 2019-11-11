package ch.heigvd.amt.projectone.web;


import org.junit.jupiter.api.Test;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HomeServletTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;

    HomeServlet servlet;

    @BeforeEach
    public void setup() {
        servlet = new HomeServlet();
//        when(request.getContextPath()).thenReturn("projectone");
//        when(request.getParameter("user")).thenReturn();
    }
    @Test
    public void doGet() throws ServletException, IOException {
    //    servlet.doGet(request, response);
    //    verify(response,atLeastOnce()).sendRedirect(request.getContextPath()+"/login");
    }
}