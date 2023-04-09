package com.hiberusTM.priceInfo.price.controller;

import com.hiberusTM.priceInfo.price.dao.PriceRepository;
import com.hiberusTM.priceInfo.price.model.Price;
import com.hiberusTM.priceInfo.price.model.PriceSearchDto;
import com.hiberusTM.priceInfo.price.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/price" )
public class PriceController {

    @Autowired
    private PriceService priceService;
    @Autowired
    private PriceRepository priceRepository;

    @GetMapping("/search")
    public ResponseEntity<Price> getPrice(@RequestBody PriceSearchDto priceSearchDto) {
        Price priceResponse = priceService.getPrice(priceSearchDto);
        if (priceResponse != null) {
            return ResponseEntity.ok(priceResponse);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
