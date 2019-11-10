package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.services.dao.ProductsManager;
import ch.heigvd.amt.projectone.services.dao.ProductsManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ProductsServlet", urlPatterns = "/logged/products")
public class ProductsServlet extends HttpServlet {

   @EJB
   private ProductsManagerLocal productsManagerLocal;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("products", productsManagerLocal.getAllProducts());
        request.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(request, response);
    }
}
