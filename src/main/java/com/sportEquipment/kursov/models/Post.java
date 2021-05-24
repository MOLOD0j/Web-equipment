package com.sportEquipment.kursov.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name, category, electricity_required, about_equipment;
    private int weight_equipment, max_weight_user, price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getElectricity_required() {
        return electricity_required;
    }

    public void setElectricity_required(String electricity_required) {
        this.electricity_required = electricity_required;
    }

    public int getWeight_equipment() {
        return weight_equipment;
    }

    public void setWeight_equipment(int weight_equipment) {
        this.weight_equipment = weight_equipment;
    }

    public int getMax_weight_user() {
        return max_weight_user;
    }

    public void setMax_weight_user(int max_weight_user) {
        this.max_weight_user = max_weight_user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAbout_equipment() {
        return about_equipment;
    }

    public void setAbout_equipment(String about_equipment) {
        this.about_equipment = about_equipment;
    }

    public Post() {
    }

    public Post(String name, String category, String electricity_required,
                int weight_equipment, int max_weight_user, int price, String about_equipment) {
        this.name = name;
        this.category = category;
        this.electricity_required = electricity_required;
        this.weight_equipment = weight_equipment;
        this.max_weight_user = max_weight_user;
        this.price = price;
        this.about_equipment = about_equipment;
    }


}
