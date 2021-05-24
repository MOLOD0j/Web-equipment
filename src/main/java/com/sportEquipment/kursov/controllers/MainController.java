package com.sportEquipment.kursov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная старница");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Старница про нас");
        return "about";
    }

    @GetMapping("/support")
    public String support(Model model) {
        model.addAttribute("title", "Помощь");
        return "support";
    }

    @GetMapping("/FAQ")
    public String FAQ(Model model) {
        model.addAttribute("title", "Часто задаваемые вопросы");
        return "FAQ";
    }

}
