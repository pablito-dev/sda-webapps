package com.pablito.servlet;

import com.pablito.db.ArticleDb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final ArticleDb db = ArticleDb.getInstance();
        httpServletRequest.setAttribute("articles", db.getArticles());
        httpServletRequest.getRequestDispatcher("/WEB-INF/index.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
