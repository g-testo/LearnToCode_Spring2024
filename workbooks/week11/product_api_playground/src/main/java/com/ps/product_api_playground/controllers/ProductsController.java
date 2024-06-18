package com.ps.product_api_playground.controllers;

import com.ps.product_api_playground.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
public class ProductsController {
    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(1, "Soap", 1, 2.99f),
                    new Product(2, "Tooth Brush", 1, 3.99f),
                    new Product(3, "Sun Glasses", 2, 9.99f)
            )
    );

    @GetMapping("/products")
    public List<Product> getProducts(){
        return products;
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
        for(Product product: products){
            if(product.getProductId() == id){
                return product;
            }
        }
        return null;
    }

}
