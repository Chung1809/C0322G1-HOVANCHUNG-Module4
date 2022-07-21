package com.example.demo.service;


import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAllSearch(String name, Pageable pageable);
    void save(Product product);

    void update(Product product);

    void delete(Integer id);

    Product findById(Integer id);
}
