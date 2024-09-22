package ru.netology.sql;

import org.springframework.stereotype.Service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    public List<String> fetchProductsByName(String name) throws SQLException {
        List<String> products = new ArrayList<>();

        try (var connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", // Проверьте имя базы данных
                "postgres",
                "123");
             var statement = connection.prepareStatement(
                     "SELECT A.product_name " +
                             "FROM netology.orders A " +
                             "JOIN netology.customers B ON A.customer_id = B.id " +
                             "WHERE LOWER(B.name) = LOWER(?);")) {
            statement.setString(1, name);

            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                products.add(resultSet.getString("product_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        if (products.isEmpty()) {
            return Collections.singletonList(name + " в списках покупателей не найден");
        }
        return products;
    }
}