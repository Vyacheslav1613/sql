package ru.netology.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/fetch-product")
    @ResponseBody
    public List<String> fetchProducts(@RequestParam String name) throws SQLException {
        return productService.fetchProductsByName(name);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}