package com.gagejackson.lairlister.Repositories;

import com.gagejackson.lairlister.Models.Ad;
import com.gagejackson.lairlister.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByAd_Id(long AdId);

}
