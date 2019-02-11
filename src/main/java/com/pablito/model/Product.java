package com.pablito.model;

import java.time.LocalDateTime;

public class Product {
    private Long id;
    private LocalDateTime creationDate;
    private String name;
    private String description;
    private long price;

    public Product(Long id, LocalDateTime creationDate, String name, String description, long price) {
        this.id = id;
        this.creationDate = creationDate;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
