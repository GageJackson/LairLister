package com.gagejackson.lairlister.Repositories;

import com.gagejackson.lairlister.Models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {
    List<Ad> findAllByDescriptionContainingIgnoreCaseOrTitleContainingIgnoreCase(String description, String title);

    List<Ad> findByTitleIsLikeIgnoreCase(String title);
    List<Ad> findAllByFeaturedTrue();
}
