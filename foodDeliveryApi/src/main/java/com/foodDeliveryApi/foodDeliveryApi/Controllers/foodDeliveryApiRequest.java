package com.foodDeliveryApi.foodDeliveryApi.Controllers;


import com.foodDeliveryApi.foodDeliveryApi.Entities.Item;
import com.foodDeliveryApi.foodDeliveryApi.Entities.Organization;
import com.foodDeliveryApi.foodDeliveryApi.Entities.Pricing;
import com.foodDeliveryApi.foodDeliveryApi.models.DeliveryRequest;
import com.foodDeliveryApi.foodDeliveryApi.models.DeliveryResponse;
import com.foodDeliveryApi.foodDeliveryApi.services.foodDeliveryApiService;
import com.foodDeliveryApi.foodDeliveryApi.services.foodDeliveryApiServiceImplementation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class foodDeliveryApiRequest {

    @Autowired
    private foodDeliveryApiServiceImplementation api;

  @PostMapping("/save/item")
  public ResponseEntity<Item> save(@RequestBody Item item) {
    try {
      Item itemObject = api.saveItem(item);
      return ResponseEntity.status(HttpStatus.OK).body(itemObject);

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PostMapping("/save/organization")
  public ResponseEntity<Organization> save(@RequestBody Organization organization) {
    try{
      Organization organizationObject = api.saveOrganization(organization);
      return ResponseEntity.status(HttpStatus.OK).body(organizationObject);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PostMapping("/save/pricing")
  public ResponseEntity<Pricing> save(@RequestBody Pricing pricing) {
    try {
      Pricing pricingObject = api.savePricing(pricing);
      return ResponseEntity.status(HttpStatus.OK).body(pricingObject);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/totalPrice")
  public ResponseEntity<DeliveryResponse> getTotalPrice(@RequestBody DeliveryRequest deliveryRequest) {
    try {
      DeliveryResponse deliveryResponse = api.calculatePrice(deliveryRequest);
      return ResponseEntity.status(HttpStatus.OK).body(deliveryResponse);
    } catch(Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
