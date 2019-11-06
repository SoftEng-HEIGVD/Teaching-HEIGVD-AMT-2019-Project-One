package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.services.dao.OrdersDAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/orders")
public class OrdersServlet extends HttpServlet {

    @EJB
    OrdersDAO ordersDAO = new OrdersDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ordersDAO.getAllOrders();
        request.getRequestDispatcher("/WEB-INF/pages/orders.jsp").forward(request, response);
    }
}
