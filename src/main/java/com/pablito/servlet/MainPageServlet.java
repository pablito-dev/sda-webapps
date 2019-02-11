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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet("/index")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final ProductDb db = ProductDb.getInstance();
        final String category = httpServletRequest.getParameter("category");
        List<Product> products = db.getProducts();

        for (final Cookie cookie: httpServletRequest.getCookies()) {
               if (cookie.getName().equalsIgnoreCase("lastProductView")) {
                   products.stream().filter(product -> product.getId().equals(Long.valueOf(cookie.getValue())))
                           .findFirst().ifPresent(product -> httpServletRequest.setAttribute("lastViewed", product));

               }
        }
        if (category != null) {
            products = products.stream().filter(product -> product.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
        }

        httpServletRequest.setAttribute("products", products);
        httpServletRequest.getRequestDispatcher("/WEB-INF/index.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
