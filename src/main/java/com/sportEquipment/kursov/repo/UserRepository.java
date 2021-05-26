package com.sportEquipment.kursov.repo;

import com.sportEquipment.kursov.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UserRepository extends CrudRepository<User, Long> {
    ArrayList<User> findByLogin(String username);
}