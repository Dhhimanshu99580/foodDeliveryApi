package com.foodDeliveryApi.foodDeliveryApi.Repositories;

import com.foodDeliveryApi.foodDeliveryApi.Entities.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PricingDB extends JpaRepository<Pricing,Integer> {
   Pricing findByOrganizationIdAndItemIdAndZone(int organizationId,int itemId,String Zone);
}
