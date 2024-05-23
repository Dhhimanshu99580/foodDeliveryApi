package com.foodDeliveryApi.foodDeliveryApi.Controllers;


import com.foodDeliveryApi.foodDeliveryApi.Entities.Item;
import com.foodDeliveryApi.foodDeliveryApi.services.foodDeliveryApiService;
import com.foodDeliveryApi.foodDeliveryApi.services.foodDeliveryApiServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
