package com.sportEquipment.kursov.repo;

import com.sportEquipment.kursov.models.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    ArrayList<Admin> findByLogin(String adminname);
}
