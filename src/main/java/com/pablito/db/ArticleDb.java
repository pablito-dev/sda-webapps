package com.pablito.db;

import com.pablito.model.Article;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ArticleDb {
    private static ArticleDb db;
    private static long currentId = 0L;

    private List<Article> articles;

    private ArticleDb() {
        this.articles = new LinkedList<>();
    }

    public static ArticleDb getInstance() {
        if (db == null) {
            db = new ArticleDb();
        }
        return db;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void addArticle(final String title, final String text) {
        final long id =+ currentId;
        Article newArticle = new Article(id, LocalDateTime.now(), title, text);
        this.articles.add(newArticle);
    }
}
