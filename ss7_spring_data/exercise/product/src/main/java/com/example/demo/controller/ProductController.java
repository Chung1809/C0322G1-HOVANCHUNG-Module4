package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public String list(@PageableDefault(value = 3)Pageable pageable,
            @RequestParam(value = "name" ,defaultValue = "") String name, Model model) {
        model.addAttribute("list", productService.findAllSearch(name, pageable));
        model.addAttribute("name",name);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("create", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String createList(Product product) {
        productService.save(product);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        productService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editList(Product product) {
        productService.update(product);
        return "redirect:/list";
    }


}
