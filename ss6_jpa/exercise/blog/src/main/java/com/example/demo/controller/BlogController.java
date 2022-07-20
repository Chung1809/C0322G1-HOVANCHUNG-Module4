package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private IBlogService service;

    @GetMapping("/list")
    public String listBlog( Model model){
        model.addAttribute("list",service.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String createBlog(Blog blog){
        service.save(blog);
        return "redirect:/blog/list";
    }
    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("blog", service.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateBlog(Blog blog) {
        service.update(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/delete")
    public String delete( Integer id) {
        service.delete(id);
        return "redirect:/blog/list";
    }
    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("blog", service.findById(id));
        return "view";
    }
}
