package com.ps.product_api_playground.controllers;

import com.ps.product_api_playground.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ps.product_api_playground.data.mysql.MySqlProductsDao;

import java.util.List;
@RestController
public class ProductsController {
    private MySqlProductsDao mySqlProductsDao;

    @Autowired
    public ProductsController(MySqlProductsDao mySqlProductsDao){
        this.mySqlProductsDao = mySqlProductsDao;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return mySqlProductsDao.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
        return mySqlProductsDao.getProductById(id);
    }

}
