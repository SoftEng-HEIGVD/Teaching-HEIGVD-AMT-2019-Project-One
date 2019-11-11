package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.model.Product;
import ch.heigvd.amt.projectone.services.dao.ProductsManager;
import ch.heigvd.amt.projectone.services.dao.ProductsManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {

    @EJB
    private ProductsManagerLocal productsManagerLocal;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error;

        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("desc");

        if (name.isEmpty() || price.isEmpty() || description.isEmpty()){
            error = "Cannot have empty params";
            request.setAttribute("error", error);
            request.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(request, response);
        } else {
            try {
                Product product = new Product(name, Double.parseDouble(price), description);
                product = productsManagerLocal.create(product);
                List<Product> products = productsManagerLocal.getAllProducts();
                products.add(product);
                HttpSession session = request.getSession();
                session.removeAttribute("products");
                session.setAttribute("products", products);
                request.getRequestDispatcher("WEB-INF/pages/products.jsp").forward(request, response);
            } catch (DuplicateKeyException e) {
                e.printStackTrace();
            }



        }

        response.setContentType("text/html;charset=UTF-8");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("products", productsManagerLocal.getAllProducts());
        request.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(request, response);
    }
}
