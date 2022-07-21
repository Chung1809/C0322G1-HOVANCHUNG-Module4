package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private IBlogService service;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String listBlog(@PageableDefault(value = 3,sort = "date_write",direction = Sort.Direction.DESC)Pageable pageable,
          @RequestParam(value = "title",defaultValue = "") String title, Model model){
         model.addAttribute("list",service.findAllSearch(title,pageable));
         model.addAttribute("title",title);
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",categoryService.findAll());
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
        model.addAttribute("category",categoryService.findAll());
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
