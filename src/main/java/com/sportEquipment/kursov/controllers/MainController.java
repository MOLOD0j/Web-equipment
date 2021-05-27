package com.sportEquipment.kursov.controllers;

import com.sportEquipment.kursov.models.User;
import com.sportEquipment.kursov.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Autowired
    private UserRepository userRepository;

    @PostMapping("registration_add_user")
    public String assortmentPostAdd(@RequestParam String name, @RequestParam String email,
                                    @RequestParam String login, @RequestParam String password, Model model) {
        User user = new User(name, email, login, password);

        userRepository.save(user);
        return "redirect:/assortment";
    }

    @RequestMapping("/log_in")
    public String log_in(Model model) {
        model.addAttribute("title", "Логин");
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "log_in";
    }
    @RequestMapping("/log_in_back")
    public String LogIn(@RequestParam String username, @RequestParam String password, Model model){
        try{
            ArrayList<User> login = userRepository.findByLogin(username);
            List<String> all = Arrays.asList(String.valueOf(login.get(0).getPassword()), String.valueOf(password) ,String.valueOf(login.get(0).getLogin()), String.valueOf(username));
            if ((all.get(2)==all.get(3))){
                model.addAttribute("login", all);
                return "welcome";
            }
            else{
                return "log_in";
            }
        }
        catch(Exception e){
            return "log_in";
        }
    }
}

