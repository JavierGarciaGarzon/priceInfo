package com.hiberusTM.priceInfo.price.service;

import com.hiberusTM.priceInfo.price.dao.PriceRepository;
import com.hiberusTM.priceInfo.price.model.Price;
import com.hiberusTM.priceInfo.price.model.PriceSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public Price getPrice(PriceSearchDto priceSearchDto) {
        PriorityQueue<Price> prices = priceRepository.findByBrandProductAndDate(priceSearchDto.getBrandId(), priceSearchDto.getProductId(), priceSearchDto.getDate());
        Price price = null;
        if (!prices.isEmpty()) {
            price = prices.peek();
        }
        return price;
    }

}
