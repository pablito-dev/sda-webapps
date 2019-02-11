package com.pablito.servlet;

import com.pablito.db.ProductDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addProduct")
public class ProductAdminServlet extends HttpServlet {
    private ProductDb productDb;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/addProduct.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        final String name = httpServletRequest.getParameter("name");
        final String description = httpServletRequest.getParameter("description");
        final int price = Integer.parseInt(httpServletRequest.getParameter("price"));

        long id = productDb.addNewProduct(name, description, price);
        httpServletResponse.sendRedirect(String.format("/product?id=%s", id));
    }

    @Override
    public void init() throws ServletException {
        productDb = ProductDb.getInstance();
    }
}
