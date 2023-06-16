package com.tokopedia.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tokopedia.assignment.models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    
}
