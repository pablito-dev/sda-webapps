package com.pablito.model;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private LocalDateTime creationDate;
    private String title;
    private String text;

    public Article(final Long id, final LocalDateTime creationDate, final String title, final String text) {
        this.id = id;
        this.creationDate = creationDate;
        this.title = title;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
