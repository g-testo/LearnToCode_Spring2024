package com.ps.product_api_playground.data;

import com.ps.product_api_playground.models.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts(String name,  int categoryId);
    Product getProductById(int id);
    Product createProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);

    // Read - Get - SELECT - Get All
    // Read - Get - SELECT - Get By Id
    // Create - Post - INSERT
    // Update - Put - UPDATE
    // Delete - Delete - DELETE

}
