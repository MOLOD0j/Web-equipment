package com.sportEquipment.kursov.repo;

import com.sportEquipment.kursov.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}