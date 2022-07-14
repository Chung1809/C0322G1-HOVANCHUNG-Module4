package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
@RequestMapping("sandwich")
public class SandwichService {

    @GetMapping("")
    public String list(){
        return "home";
    }
    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment" , defaultValue = "") String[] sandwich, Model model){
        model.addAttribute("condiment", Arrays.toString(sandwich));
        return "home";
    }
}
