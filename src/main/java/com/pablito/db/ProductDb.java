package com.pablito.db;

import com.pablito.model.Product;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ProductDb {
    private static ProductDb db;
    private static long currentId = 3L;

    private List<Product> products;

    private ProductDb() {
        this.products = new LinkedList<>();
        this.products.add(new Product(0L, LocalDateTime.now(), "Supercolider",
                "After you attack a minion, force it to attack one of its neighbors.", 5, "Warrior"));
        this.products.add(new Product(1L, LocalDateTime.now(), "Bloodclaw",
                "Battlecry: Deal 5 damage to your hero.", 1, "Paladin"));
        this.products.add(new Product(2L, LocalDateTime.now(), "Headhunter's Hatchet",
                "Battlecry: If you control a Beast, gain +1 Durability.", 2, "Hunter"));
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

    public long addNewProduct(final String name, final String description, final long price, final String category) {
        currentId = currentId++;
        Product newProduct = new Product(currentId, LocalDateTime.now(), name, description, price, category);
        this.products.add(newProduct);
        return currentId;
    }
}
