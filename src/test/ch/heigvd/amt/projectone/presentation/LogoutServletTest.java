package ch.heigvd.amt.projectone.presentation;

import name.falgout.jeffrey.testing.junit.mockito.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import javax.ejb.DuplicateKeyException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LogoutServletTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @Mock
    RequestDispatcher rd;

    LogoutServlet lgServlet;

    @BeforeEach
    public void setup() throws IOException {
        lgServlet = new LogoutServlet();
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/logoutPage");
        when(request.getRequestDispatcher("/index.jsp")).thenReturn(rd);
    }

    @Test
    void doGetBackToLoginPage() throws ServletException, IOException, DuplicateKeyException, SQLException {
        lgServlet.doGet(request, response);

        verify(request, atLeastOnce()).getSession();
        verify(session,atLeastOnce()).invalidate();
        verify(rd, atLeastOnce()).forward(request, response);

    }
}