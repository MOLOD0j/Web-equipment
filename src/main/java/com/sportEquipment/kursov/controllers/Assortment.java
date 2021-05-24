package com.sportEquipment.kursov.controllers;

import com.sportEquipment.kursov.models.Post;
import com.sportEquipment.kursov.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class Assortment {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/assortment")
    public String assortment(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "assortment-main";
    }

    @GetMapping("/assortment/add")
    public String assortmentAdd(Model model){
        return "assortment-add";
    }

    @PostMapping("/assortment/add")
    public String assortmentPostAdd(@RequestParam String name, @RequestParam String category,
                                    @RequestParam String electricity_required, @RequestParam Integer weight_equipment,
                                    @RequestParam Integer max_weight_user, @RequestParam Integer price,
                                    @RequestParam String about_equipment, Model model){
        Post post = new Post(name, category, electricity_required, weight_equipment, max_weight_user, price, about_equipment);
        postRepository.save(post);
        return "redirect:/assortment";
    }

    @GetMapping("/assortment/{id}")
    public String assortmentDetail(@PathVariable(value = "id") long id, Model model){
        if(!postRepository.existsById(id)){
            return "redirect:/assortment";
        }

        Optional<Post> post =  postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "assortment-details";
    }

    @GetMapping("/assortment/{id}/edit")
    public String assortmentEdit(@PathVariable(value = "id") long id, Model model){
        if(!postRepository.existsById(id)){
            return "redirect:/assortment";
        }

        Optional<Post> post =  postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "assortment-edit";
    }

    @PostMapping("/assortment/{id}/edit")
    public String assortmentPostUpdate(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String category,
                                       @RequestParam String electricity_required, @RequestParam Integer weight_equipment,
                                       @RequestParam Integer max_weight_user, @RequestParam Integer price,
                                       @RequestParam String about_equipment, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        post.setName(name);
        post.setCategory(category);
        post.setElectricity_required(electricity_required);
        post.setWeight_equipment(weight_equipment);
        post.setMax_weight_user(max_weight_user);
        post.setPrice(price);
        post.setAbout_equipment(about_equipment);
        postRepository.save(post);

        return "redirect:/assortment";
    }

    @PostMapping("/assortment/{id}/remove")
    public String assortmentPostDelete(@PathVariable(value = "id") long id, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);

        return "redirect:/assortment";
    }
}
