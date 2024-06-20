package com.ps.product_api_playground.controllers;

import com.ps.product_api_playground.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ps.product_api_playground.data.mysql.MySqlProductsDao;

import java.util.List;
@RestController
public class ProductsController {
    private MySqlProductsDao mySqlProductsDao;

    @Autowired
    public ProductsController(MySqlProductsDao mySqlProductsDao){
        this.mySqlProductsDao = mySqlProductsDao;
    }

    // Filter product by name
    @GetMapping("/products")
    public List<Product> getProducts(){
        return mySqlProductsDao.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
        return mySqlProductsDao.getProductById(id);
    }

    @PostMapping("/products")
    public Product postProduct(@RequestBody Product product){
        return mySqlProductsDao.createProduct(product);
    }

    @PutMapping("/products/{id}")
    public void putProduct(@PathVariable int id, @RequestBody Product product){
        mySqlProductsDao.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void removeProduct(@PathVariable int id){
        mySqlProductsDao.deleteProduct(id);
    }

    // GET, POST, PUT, DELETE

}
