package com.foodDeliveryApi.foodDeliveryApi.Repositories;

import com.foodDeliveryApi.foodDeliveryApi.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemDB extends JpaRepository<Item,Integer> {

    List<Item> findByType(String itemType);
}
