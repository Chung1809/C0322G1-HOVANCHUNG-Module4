package codegym.cotroller;

import codegym.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {

    @Autowired
    private ICalculateService calculateService;

    @GetMapping("/home")
    public String list(){
        return "home";
    }
    @PostMapping("/save")
    public String add(@RequestParam("operate") String operator,
                      @RequestParam("number1") String number1,
                      @RequestParam("number2") String number2, Model model){
        String result = calculateService.calculate(operator,number1,number2);
        model.addAttribute("result",result);
        return "home";
    }
}
