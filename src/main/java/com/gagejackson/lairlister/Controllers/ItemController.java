package com.gagejackson.lairlister.Controllers;

import com.gagejackson.lairlister.Models.Item;
import com.gagejackson.lairlister.Repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ItemController {

    private final ItemRepository itemDao;
    public ItemController(ItemRepository itemDao) {
        this.itemDao = itemDao;
    }

//    @GetMapping("/ads/create")
//    public String showCreateForm(Model model){
//        model.addAttribute("item", new Item());
//
//        return "/ads/create";
//    }
//
//    @PostMapping("/ads/create")
//    public String create(@ModelAttribute Item item){
//        itemDao.save(item);
//
//        return "redirect:/ads";
//    }

//    @GetMapping("/ads")
//    public String showAll(Model model) {
//        model.addAttribute("allAItems", itemDao.findAll());
//
//        return "/ads/index";
//    }
//
//    @PostMapping ("/ads")
//    public String getOne(Model model) {
//        model.addAttribute("allAItems", itemDao.findAll());
//
//        return "/ads/index";
//    }

//    @GetMapping("/ads/{id}")
//    public String viewPost(@PathVariable long id, Model model){
//        Optional<Item> item = itemDao.findById(id);
//        model.addAttribute("item", item.orElse(null));
//
//        return "/ads/show";
//    }
}