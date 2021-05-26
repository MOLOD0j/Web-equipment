package com.sportEquipment.kursov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("title", "Регистрация");
        return "registration";
    }

    @RequestMapping("/log_in")
    public String log_in(Model model) {
        model.addAttribute("title", "Логин");
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "log_in";
    }

    @RequestMapping("registration_add_user")
    public String assortmentPostAdd(@RequestParam String name, @RequestParam String email,
                                    @RequestParam String login, @RequestParam String password, Model model){
        User user = new User(name, email, login, password);
        userRepository.save(user);
        return "redirect:/assortment";
    }
}
