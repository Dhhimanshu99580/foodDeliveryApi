package com.foodDeliveryApi.foodDeliveryApi.Repositories;

import com.foodDeliveryApi.foodDeliveryApi.Entities.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingDB extends JpaRepository<Pricing,Integer> {

}
