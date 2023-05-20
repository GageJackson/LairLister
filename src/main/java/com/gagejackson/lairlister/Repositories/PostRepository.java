package com.gagejackson.lairlister.Repositories;

import com.gagejackson.lairlister.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
    Post findFirstByTitle(String title);

}
