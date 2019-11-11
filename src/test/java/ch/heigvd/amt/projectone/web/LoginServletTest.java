package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.services.dao.ClientsManagerLocal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginServletTest {


    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    ClientsManagerLocal clientsManagerLocal;

    LoginServlet servlet;

    @BeforeEach
    public void setup() throws IOException {
        servlet = new LoginServlet();
        servlet.clientsManagerLocal = clientsManagerLocal;
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        when(request.getParameter("username")).thenReturn(username);
    }
}
