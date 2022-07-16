package codegym.controller;

import codegym.model.Mailbox;
import codegym.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailboxController {
    @Autowired
    private IMailboxService service;

    @GetMapping("/create")
    public String email(Model model) {
        model.addAttribute("mail", new Mailbox());
        model.addAttribute("languageList", service.language());
        model.addAttribute("pageSizeList", service.size());
        return "create";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("list",service.findAll());
        return "list";
    }
    @PostMapping("/create")
    public String medicalDeclaration(@ModelAttribute("mail") Mailbox mailbox) {

        service.save(mailbox);

        return "redirect:/create";
    }
}
