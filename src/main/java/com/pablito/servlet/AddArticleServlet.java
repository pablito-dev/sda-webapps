package com.pablito.servlet;

import com.pablito.db.ArticleDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addArticle")
public class AddArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/addArticle.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final ArticleDb db = ArticleDb.getInstance();
        db.addArticle(httpServletRequest.getParameter("title"), httpServletRequest.getParameter("text"));
        httpServletResponse.sendRedirect("/index");
    }
}
