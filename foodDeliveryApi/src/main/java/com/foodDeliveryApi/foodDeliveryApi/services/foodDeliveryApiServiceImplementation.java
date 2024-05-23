package com.foodDeliveryApi.foodDeliveryApi.services;

import com.foodDeliveryApi.foodDeliveryApi.Entities.Item;
import com.foodDeliveryApi.foodDeliveryApi.Entities.Organization;
import com.foodDeliveryApi.foodDeliveryApi.Entities.Pricing;
import com.foodDeliveryApi.foodDeliveryApi.Repositories.ItemDB;
import com.foodDeliveryApi.foodDeliveryApi.Repositories.OrganizationDB;
import com.foodDeliveryApi.foodDeliveryApi.Repositories.PricingDB;
import com.foodDeliveryApi.foodDeliveryApi.models.DeliveryRequest;
import com.foodDeliveryApi.foodDeliveryApi.models.DeliveryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class foodDeliveryApiServiceImplementation implements foodDeliveryApiService {

    @Autowired
    private ItemDB itemdb;
    private OrganizationDB organizationdb;
    private PricingDB pricingdb;


    /*public DeliveryResponse calculateDeliveryRate(DeliveryRequest deliveryRequest) {

        return DeliveryResponse;
    }*/

    @Override
    public Item saveItem(Item item) {
         return itemdb.save(item);
    }
    @Override
    public Organization saveOrganization(Organization organization) {
        return organizationdb.save(organization);
    }
    @Override
    public Pricing savePricing(Pricing pricing) {
        return pricingdb.save(pricing);
    }

}
