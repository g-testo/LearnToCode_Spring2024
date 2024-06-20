package com.ps.product_api_playground.data.mysql;

import com.ps.product_api_playground.data.ProductDao;
import com.ps.product_api_playground.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlProductsDao implements ProductDao {
    private DataSource dataSource;

    @Autowired
    public MySqlProductsDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();

        String query = "SELECT * FROM products";

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ){

            while(resultSet.next()){
                Product product = mapProduct(resultSet);
                products.add(product);
            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return products;
    }



    @Override
    public Product getProductById(int id) {
        Product product = null;

        String query = "SELECT * FROM products WHERE ProductID=?";

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ){
                while(resultSet.next()){
                    product = mapProduct(resultSet);
                    break;
                }
            }

        } catch(SQLException sql){
            sql.printStackTrace();
        }

        return product;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void updateProduct(int id, Product product) {

    }

    @Override
    public void deleteProduct(int id) {

    }

    private Product mapProduct(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("ProductId");
        String name = resultSet.getString("ProductName");
        int categoryId = resultSet.getInt("CategoryID");
        float unitPrice = resultSet.getFloat("UnitPrice");

        return new Product(id, name, categoryId, unitPrice);
    }
}
