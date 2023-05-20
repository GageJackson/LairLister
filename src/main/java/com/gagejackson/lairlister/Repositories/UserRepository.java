package com.gagejackson.lairlister.Repositories;

import com.gagejackson.lairlister.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
