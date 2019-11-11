package ch.heigvd.amt.projectone.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LoginServletTest {


    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;

    LoginServlet servlet;

    @BeforeEach
    public void setup() {
        servlet = new LoginServlet();
        when(request.getContextPath()).thenReturn("projectone");
        when(request.getSession()).thenReturn(session);
    }
    @Test
    void doPost() {
    }
}