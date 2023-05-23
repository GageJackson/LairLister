package com.gagejackson.lairlister.Repositories;

import com.gagejackson.lairlister.Models.Lair;
import com.gagejackson.lairlister.Models.LairAmenity;
import com.gagejackson.lairlister.Models.LairAmenityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LairRepository extends JpaRepository<Lair, Long> {
    Lair findByItemId(long itemId);
}
