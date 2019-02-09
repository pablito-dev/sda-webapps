package com.pablito.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");

        resp.addCookie(new Cookie("my-cookie", "value"));
        dispatcher.forward(req, resp);
    }
}
