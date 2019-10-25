package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.model.Product;
import ch.heigvd.amt.projectone.services.ProductsManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {

    ProductsManager productsManager = new ProductsManager();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = productsManager.getRandomProduct();
    }
}
