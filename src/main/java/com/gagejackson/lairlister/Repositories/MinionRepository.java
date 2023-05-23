package com.gagejackson.lairlister.Repositories;

import com.gagejackson.lairlister.Models.Minion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinionRepository extends JpaRepository<Minion, Long> {
    Minion findByItemId(long itemId);

}
