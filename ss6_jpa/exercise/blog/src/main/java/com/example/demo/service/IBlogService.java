package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
//    Page<Blog> findAllSearch(String title ,Pageable pageable);
    List<Blog> findAll();
    void save(Blog blog);

    void update(Blog blog);

    void delete(Integer id);

    Blog findById(Integer id);

}
