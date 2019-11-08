package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.services.dao.OrdersManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="OrdersServlet", urlPatterns = "/login/orders")
public class OrdersServlet extends HttpServlet {

    @EJB
    private OrdersManagerLocal ordersManagerLocal;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("orders",ordersManagerLocal.getAllOrders());
        request.getRequestDispatcher("/WEB-INF/pages/orders.jsp").forward(request, response);
    }
}
