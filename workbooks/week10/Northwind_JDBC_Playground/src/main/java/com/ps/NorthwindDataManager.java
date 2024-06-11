package com.ps;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NorthwindDataManager {
    private DataSource dataSource;

    public NorthwindDataManager(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

        try(
                Connection connection = this.dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet results = statement.executeQuery();
        ){
            while(results.next()){
                Product product = new Product(
                        results.getInt("ProductID"),
                        results.getString("ProductName"),
                        results.getFloat("UnitPrice"),
                        results.getInt("UnitsInStock")
                );
                products.add(product);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return products;
    }

//    public List<Category> getAllCategories(){
//
//    }
//
//    public List<Order> getAllOrders(){
//
//    }

}
