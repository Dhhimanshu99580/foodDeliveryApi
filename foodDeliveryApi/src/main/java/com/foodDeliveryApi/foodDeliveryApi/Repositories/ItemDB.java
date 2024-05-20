package com.foodDeliveryApi.foodDeliveryApi.Repositories;

import com.foodDeliveryApi.foodDeliveryApi.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDB extends JpaRepository<Item,Integer> {

}
