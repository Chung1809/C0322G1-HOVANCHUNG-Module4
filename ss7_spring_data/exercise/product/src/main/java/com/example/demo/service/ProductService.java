package com.example.demo.service;


import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Override
    public Page<Product> findAllSearch(String name, Pageable pageable) {
        return repository.findAllSearch("%"+name+"%",pageable);
    }

    @Override
    public void save(Product product) {
          repository.save(product.getName(),product.getPrice(),product.getDescription(),product.getProducer());
    }

    @Override
    public void update(Product product) {
          repository.updateProduct(product.getName(),product.getPrice(),product.getDescription(),product.getProducer(),product.getId());
    }

    @Override
    public void delete(Integer id) {
        repository.deleteProduct(id);
    }

    @Override
    public Product findById(Integer id) {
        return repository.findByIdProduct(id);
    }
}
