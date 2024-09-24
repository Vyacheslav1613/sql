package ru.netology.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.sql.repository.SqlRepository;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private SqlRepository sqlRepository;

    @Transactional
    public List<String> findProductsByName(String name) throws SQLException {
        String jpqlQuery = "SELECT c.name FROM Customers c WHERE LOWER(c.name) = LOWER(:name)";
        return sqlRepository.fetchProductsByName(name);
    }
}