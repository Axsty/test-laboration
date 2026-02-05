package se.iths.axel.testlaboration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.iths.axel.testlaboration.service.ATMService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final ATMService atmService;

    public HomeController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/balance")
    public String getBalance(Model model) {
        model.addAttribute("balance", atmService.getBalance());
        return "home";
    }

    @PostMapping("/withdraw")
    public String withdraw(int amount) {
        atmService.withdraw(amount);
        return "redirect:/balance";
    }

    @PostMapping("/deposit")
    public String deposit(int amount) {
        atmService.deposit(amount);
        return "redirect:/balance";
    }
}
