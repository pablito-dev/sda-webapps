package com.pablito.db;

import com.pablito.model.Product;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ProductDb {
    private static ProductDb db;
    private static long currentId = 0L;

    private List<Product> products;

    private ProductDb() {
        this.products = new LinkedList<>();
    }

    public static ProductDb getInstance() {
        if (db == null) {
            db = new ProductDb();
        }
        return db;
    }

    public List<Product> getProducts() {
        return products;
    }

    public long addNewProduct(final String name, final String description, final long price) {
        final long id =+ currentId;
        Product newProduct = new Product(id, LocalDateTime.now(), name, description, price);
        this.products.add(newProduct);
        return id;
    }
}
