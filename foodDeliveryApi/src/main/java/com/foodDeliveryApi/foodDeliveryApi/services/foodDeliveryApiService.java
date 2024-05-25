package com.foodDeliveryApi.foodDeliveryApi.services;

import com.foodDeliveryApi.foodDeliveryApi.Entities.Item;
import com.foodDeliveryApi.foodDeliveryApi.Entities.Organization;
import com.foodDeliveryApi.foodDeliveryApi.Entities.Pricing;
import com.foodDeliveryApi.foodDeliveryApi.models.DeliveryRequest;
import com.foodDeliveryApi.foodDeliveryApi.models.DeliveryResponse;

public interface foodDeliveryApiService {
    // public void rateCalculation();
    //public void deliveryRequest();

    public Item saveItem(Item item);

    public Organization saveOrganization(Organization organization);

    public Pricing savePricing(Pricing pricing);
    public DeliveryResponse calculatePrice(DeliveryRequest deliveryRequest);
    
}
