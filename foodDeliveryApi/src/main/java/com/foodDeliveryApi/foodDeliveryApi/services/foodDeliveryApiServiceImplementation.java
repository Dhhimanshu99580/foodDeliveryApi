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

import java.util.List;

@Component
public class foodDeliveryApiServiceImplementation implements foodDeliveryApiService {

    @Autowired
    private ItemDB itemdb;
    @Autowired
    private OrganizationDB organizationdb;
    @Autowired
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
       Organization organization =  organizationdb.findById(pricing.getOrganization().getId())
               .orElseThrow(()-> new RuntimeException("Organization_id not found"));
       Item item = itemdb.findById(pricing.getItem().getId())
               .orElseThrow(()-> new RuntimeException("item_id not found"));

       pricing.setOrganization(organization);
       pricing.setItem(item);
       return pricingdb.save(pricing);
    }
    @Override
    public DeliveryResponse calculatePrice(DeliveryRequest deliveryRequest) {
        List<Item> listOfItems = itemdb.findByType(deliveryRequest.getItemType());
        if(listOfItems.isEmpty()) {
            throw new RuntimeException("Item not found for the given type:" +deliveryRequest.getItemType());
        }
        Pricing pricingObject=null;
        for(Item list: listOfItems) {
            pricingObject = pricingdb.findByOrganizationIdAndItemIdAndZone(deliveryRequest.getOrganizationId()
                                     ,list.getId(),deliveryRequest.getZone());
        }
        if(pricingObject==null) {
            throw new RuntimeException("PricingObject not found for the given type:" +deliveryRequest.getItemType());
        }
        double per_km_price = 1;
        double km = pricingObject.getBase_distance_in_km();
        double constantPrice = 10;
        if(deliveryRequest.getTotalDistance()>5) {
            if(deliveryRequest.getItemType().equals("Perishable")) {
                per_km_price = 1.5;
                km = deliveryRequest.getTotalDistance()-5;
            } else {
                per_km_price = 1;
                km= deliveryRequest.getTotalDistance()-5;
            }
        }
        DeliveryResponse deliveryResponse = new DeliveryResponse();
         deliveryResponse.setTotal_price(km*per_km_price+10);
        return deliveryResponse;
    }
}
