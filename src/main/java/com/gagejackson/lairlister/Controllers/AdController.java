package com.gagejackson.lairlister.Controllers;

import com.gagejackson.lairlister.Models.*;
import com.gagejackson.lairlister.Repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class AdController {

    private final AdRepository adDao;
    private final ItemRepository itemDao;
    private final LairRepository lairDao;
    private final MinionRepository minionDao;
    private final MinionClassRepository minionClassDao;
    private final MinionLevelRepository minionLevelDao;
    private final MinionSizeRepository minionSizeDao;
    private final MinionSkillRepository minionSkillDao;
    private final MinionTypeRepository minionTypeDao;

    public AdController(AdRepository adDao, ItemRepository itemDao, LairRepository lairDao,
                        MinionRepository minionDao, MinionClassRepository minionClassDao,
                        MinionLevelRepository minionLevelDao, MinionSizeRepository minionSizeDao,
                        MinionSkillRepository minionSkillDao, MinionTypeRepository minionTypeDao) {

        this.adDao = adDao;
        this.itemDao = itemDao;
        this.lairDao = lairDao;
        this.minionDao = minionDao;
        this.minionClassDao = minionClassDao;
        this.minionLevelDao = minionLevelDao;
        this.minionSizeDao = minionSizeDao;
        this.minionSkillDao = minionSkillDao;
        this.minionTypeDao = minionTypeDao;

    }

    @GetMapping("/ads/create")
    public String showCreateItemSelection(){

        return "/ads/create_type";
    }

    @GetMapping("/ads/create/lair")
    public String showCreateLairForm(Model model){
        model.addAttribute("item", new Item());
        model.addAttribute("lair", new Lair());

        return "/ads/create_lair";
    }

    @GetMapping("/ads/create/minion")
    public String showCreateMinionForm(Model model) {
        Date currentDate = Calendar.getInstance().getTime();
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("ad", new Ad(currentDate, currentDate));
        model.addAttribute("item", new Item());
        model.addAttribute("minion", new Minion());
        model.addAttribute("minionClasses", minionClassDao.findAll());
        model.addAttribute("minionLevels", minionLevelDao.findAll());
        model.addAttribute("minionSizes", minionSizeDao.findAll());
        model.addAttribute("minionSkills", minionSkillDao.findAll());
        model.addAttribute("minionTypes", minionTypeDao.findAll());

        return "/ads/create_minion";
    }

    @PostMapping("/ads/create/minion")
    public String create(@ModelAttribute Ad ad, @ModelAttribute Item item, @ModelAttribute Minion minion,
                         @RequestParam("newItemImage") String itemImage, @RequestParam("minion_skill")List<Long> minionSkillIds){
        AdLocation adLocation = new AdLocation();
        adLocation.setId(1);
        ad.setAd_location(adLocation);

        AdStatus adStatus = new AdStatus();
        adStatus.setId(1);
        ad.setAd_status(adStatus);

        ItemType itemType = new ItemType();
        itemType.setId(2);
        item.setItemType(itemType);

        item.setImage(itemImage);

        List<MinionSkill> minionSkills = new ArrayList<>();
        for (long minionSkillId : minionSkillIds) {
            Optional<MinionSkill> optionalMinionSkill = minionSkillDao.findById(minionSkillId);
            optionalMinionSkill.ifPresent(minionSkills::add);
        }
        minion.setMinionSkills(minionSkills);


        item.setAd(ad);
        minion.setItem(item);

        adDao.save(ad);
        itemDao.save(item);
        minionDao.save(minion);

        return "redirect:/ads";
    }


    @GetMapping("/ads")
    public String showAll(Model model) {
        model.addAttribute("allAds", adDao.findAll());
        model.addAttribute("allItems", itemDao.findAll());

        return "/ads/index";
    }

    @PostMapping ("/ads")
    public String getOne(Model model) {
        model.addAttribute("allAds", adDao.findAll());
        model.addAttribute("allItems", itemDao.findAll());

        return "/ads/index";
    }

    @GetMapping("/ads/{id}")
    public String viewPost(@PathVariable long id, Model model){
        Optional<Ad> ad = adDao.findById(id);
        Optional<Item> item = itemDao.findById(id);

        Ad adObject = ad.get();
        model.addAttribute("ad", adObject);

        Item itemObject = item.get();
        model.addAttribute("item", itemObject);

        ItemType itemType = itemObject.getItemType();
        String itemTypeName = itemType.getName();

        if(itemType.getId() == 1){
            Lair lair = lairDao.findByItemId(itemObject.getId());
            model.addAttribute("lair", lair);

        } else if(itemType.getId() == 2){
            Minion minion = minionDao.findByItemId(itemObject.getId());
            model.addAttribute("minion", minion);

        } else {
            System.out.println("nothing");
        }

        return "/ads/show";
    }
}