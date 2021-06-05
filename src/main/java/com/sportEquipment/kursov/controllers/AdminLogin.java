package com.sportEquipment.kursov.controllers;

import com.sportEquipment.kursov.models.Admin;
import com.sportEquipment.kursov.repo.AdminRepository;
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
public class AdminLogin {

    @Autowired
    private AdminRepository adminRepository;

    @RequestMapping("/registration_admin")
    public String registrationAdmin(Model model) {
        model.addAttribute("title", "Регистрация");
        return "registration_admin";
    }

    @PostMapping("registration_add_admin")
    public String newAdminAdd(@RequestParam String name, @RequestParam String email,
                              @RequestParam String login, @RequestParam String password, Model model) {
        Admin admin = new Admin(name, email, login, password);

        adminRepository.save(admin);
        return "redirect:/assortment_admin";
    }

    @RequestMapping("/login_in_admin")
    public String login_in_admin(Model model) {
        model.addAttribute("title", "Логин");
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "login_in_admin";
    }



    @RequestMapping("/log_in_admin_back")
    public String LogInAdmin(@RequestParam String adminname, @RequestParam String password, Model model){
        try{
            ArrayList<Admin> login = adminRepository.findByLogin(adminname);
            List<String> all = Arrays.asList(login.get(0).getPassword(), password ,login.get(0).getLogin(), adminname);
            System.out.println(all);

            String par =  login.get(0).getPassword();
            String log = login.get(0).getLogin();
            /*Boolean parEq = par.equals(password);
            Boolean logEq = username.equals(log);*/
            if (par.equals(password) && adminname.equals(log)){
                //model.addAttribute("login", all);
                return "redirect:/assortment_admin";
            }
            else{
                //model.addAttribute("login", all);
                return "login_in_admin";
            }
        }
        catch(Exception e){
            return "login_in_admin";
        }

    }
}
