package com.pablito.servlet;

import com.pablito.db.UserDb;
import com.pablito.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDb userDb;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/login.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final String username = httpServletRequest.getParameter("username");
        final String password = httpServletRequest.getParameter("password");

        Optional<User> optionalUser = userDb.checkLogin(username, password);
        if (optionalUser.isPresent()) {
            final User user = optionalUser.get();
            httpServletRequest.getSession().setAttribute("user", user);
            httpServletResponse.sendRedirect("/index");
        } else {
            httpServletRequest.getRequestDispatcher("/WEB-INF/login.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void init() throws ServletException {
        userDb = UserDb.getInstance();
    }
}
