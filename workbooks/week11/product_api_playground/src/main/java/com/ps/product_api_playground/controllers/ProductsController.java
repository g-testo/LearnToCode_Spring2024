package com.ps.product_api_playground.controllers;

import com.ps.product_api_playground.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // Filter product by name /products?name=fa
    @GetMapping("/products")
    @ResponseStatus(value= HttpStatus.OK)
    public List<Product> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int categoryId
    ){
        return mySqlProductsDao.getAllProducts(name, categoryId);
    }

    @GetMapping("/products/{id}")
    @ResponseStatus(value= HttpStatus.OK)
    public Product getProduct(@PathVariable int id){
        return mySqlProductsDao.getProductById(id);
    }

    @PostMapping("/products")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product postProduct(@RequestBody Product product){
        return mySqlProductsDao.createProduct(product);
    }

    @PutMapping("/products/{id}")
    @ResponseStatus(value= HttpStatus.OK)
    public void putProduct(@PathVariable int id, @RequestBody Product product){
        mySqlProductsDao.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void removeProduct(@PathVariable int id){
        mySqlProductsDao.deleteProduct(id);
    }

    // GET, POST, PUT, DELETE

}
