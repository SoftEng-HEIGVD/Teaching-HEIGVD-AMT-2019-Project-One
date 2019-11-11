package ch.heigvd.amt.projectone.presentation;

import ch.heigvd.amt.projectone.DAO.ICoachDAO;
import ch.heigvd.amt.projectone.model.Coach;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegistrationServletTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    ICoachDAO coachDAO;

    @Mock
    PrintWriter responseWriter;

    @Mock
    RequestDispatcher rd;

    @Mock
    Coach coach;

    RegistrationServlet regServlet;

    @BeforeEach
    public void setup() throws IOException {
        regServlet = new RegistrationServlet();
        regServlet.cd = coachDAO;
        when(response.getWriter()).thenReturn(responseWriter);

    }

    @Test
    void doPostRegistration() throws ServletException, IOException, DuplicateKeyException, SQLException {
        when(request.getParameter(anyString())).thenReturn("test");
        when(coachDAO.create(any())).thenReturn(coach);
        when(request.getRequestDispatcher("index.jsp")).thenReturn(rd);

        regServlet.doPost(request, response);

        verify(coachDAO, atLeastOnce()).create(any());
    }
}