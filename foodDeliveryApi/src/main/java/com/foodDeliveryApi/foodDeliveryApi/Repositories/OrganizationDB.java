package com.foodDeliveryApi.foodDeliveryApi.Repositories;

import com.foodDeliveryApi.foodDeliveryApi.Entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationDB extends JpaRepository<Organization,Integer> {

}
