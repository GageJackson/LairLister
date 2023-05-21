package com.gagejackson.lairlister.Repositories;

import com.gagejackson.lairlister.Models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findByTitle(String title);
    Ad findFirstByTitle(String title);

}
