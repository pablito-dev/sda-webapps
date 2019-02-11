package com.pablito.servlet;

import com.pablito.db.ProductDb;
import com.pablito.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/product")
public class ProductViewServlet extends HttpServlet {
    private ProductDb productDb;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        final long id = Long.valueOf(httpServletRequest.getParameter("id"));
        Optional<Product> optionalProduct = productDb.getProducts().stream()
                .filter(product -> product.getId().equals(id)).findFirst();

        if (optionalProduct.isPresent()) {
            final Product product = optionalProduct.get();
            httpServletRequest.setAttribute("product", product);
            httpServletResponse.addCookie(new Cookie("lastProductView", String.valueOf(id)));
            httpServletRequest.getRequestDispatcher("/WEB-INF/product.jsp").forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.getRequestDispatcher("/WEB-INF/index.jsp").forward(httpServletRequest, httpServletResponse);
        }

    }

    @Override
    public void init() throws ServletException {
        productDb = ProductDb.getInstance();
    }
}
