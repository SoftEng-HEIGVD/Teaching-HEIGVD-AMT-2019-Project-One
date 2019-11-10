package ch.heigvd.amt.projectone.presentation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    }

    @Test
    void doGetBackToLoginPage() throws ServletException, IOException, DuplicateKeyException, SQLException {
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("test");

        lgServlet.doGet(request, response);

        verify(request, atLeastOnce()).getSession();
        verify(session,atLeastOnce()).invalidate();
        verify(rd, atLeastOnce()).forward(request, response);

    }
}