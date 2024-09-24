package ru.netology.sql.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.List;

@Repository
public class SqlRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SqlRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<String> fetchProductsByName(String name){
        List<String> products;

        String sql = "SELECT A.product_name " +
                "FROM netology.orders A " +
                "JOIN netology.customers B ON A.customer_id = B.id " +
                "WHERE LOWER(B.name) = LOWER(:name);";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("name", name);

        products = namedParameterJdbcTemplate.queryForList(sql, parameters, String.class);

        if (products.isEmpty()) {
            return Collections.singletonList(name + " в списках покупателей не найден");
        }
        return products;
    }
}
