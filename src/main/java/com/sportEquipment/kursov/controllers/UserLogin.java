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
public class UserLogin {
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

    @GetMapping("/who_are_you")
    public String who_are_you(Model model) {
        model.addAttribute("title", "Старница выбора типа пользователя");
        return "who_are_you";
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
            List<String> all = Arrays.asList(login.get(0).getPassword(), password ,login.get(0).getLogin(), username);
            System.out.println(all);

            String par =  login.get(0).getPassword();
            String log = login.get(0).getLogin();
            /*Boolean parEq = par.equals(password);
            Boolean logEq = username.equals(log);*/
            if (par.equals(password) && username.equals(log)){
                //model.addAttribute("login", all);
                return "redirect:/assortment";
            }
            else{
                model.addAttribute("login", all);
                return "log_in";
            }
        }
        catch(Exception e){
            return "log_in";
        }

    }
}
