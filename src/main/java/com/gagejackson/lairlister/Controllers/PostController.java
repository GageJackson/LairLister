package com.gagejackson.lairlister.Controllers;

import com.gagejackson.lairlister.Models.Post;
import com.gagejackson.lairlister.Repositories.PostRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model){
        model.addAttribute("post", new Post());

        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post){
        postDao.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String showAllPosts(Model model) {
        model.addAttribute("savedPosts", postDao.findAll());

        return "/posts/index";
    }

    @PostMapping ("/posts")
    public String showPost(Model model) {
        model.addAttribute("savedPosts", postDao.findAll());

        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model){
        Optional<Post> post = postDao.findById(id);
        model.addAttribute("post", post.orElse(null));

        return "/posts/show";
    }
}