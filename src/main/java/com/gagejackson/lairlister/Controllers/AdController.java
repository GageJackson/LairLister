package com.gagejackson.lairlister.Controllers;

import com.gagejackson.lairlister.Models.Ad;
import com.gagejackson.lairlister.Repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdController {

    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads/create")
    public String showCreateForm(Model model){
        model.addAttribute("ad", new Ad());

        return "/ads/create";
    }

    @PostMapping("/ads/create")
    public String create(@ModelAttribute Ad ad){
        adDao.save(ad);

        return "redirect:/ads";
    }

    @GetMapping("/ads")
    public String showAll(Model model) {
        model.addAttribute("allAds", adDao.findAll());

        return "/ads/index";
    }

    @PostMapping ("/ads")
    public String getOne(Model model) {
        model.addAttribute("allAds", adDao.findAll());

        return "/ads/index";
    }

    @GetMapping("/ads/{id}")
    public String viewPost(@PathVariable long id, Model model){
        Optional<Ad> ad = adDao.findById(id);
        model.addAttribute("ad", ad.orElse(null));

        return "/ads/show";
    }
}