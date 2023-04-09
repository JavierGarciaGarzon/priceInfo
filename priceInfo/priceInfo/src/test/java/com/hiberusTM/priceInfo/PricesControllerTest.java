package com.hiberusTM.priceInfo;

import com.hiberusTM.priceInfo.price.controller.PriceController;
import com.hiberusTM.priceInfo.price.model.Price;
import com.hiberusTM.priceInfo.price.model.PriceSearchDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class PricesControllerTest {

    @Autowired
    private PriceController priceController;

    private List<String> inputDates;

    private List<Long> expectedPriceIds;

    @Test
    void testPriceService() {
        inputDates = Arrays.asList("2020-06-14-10.00.00","2020-06-14-16.00.00", "2020-06-14-21.00.00","2020-06-15-10.00.00","2020-06-16-21.00.00");
        expectedPriceIds = Arrays.asList(1l,2l,1l,3l,4l);
        Long brandId = 1l;
        Long productId = 35455l;
        int i = 0;
        for (String dateString : inputDates) {
            LocalDateTime date = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));
            PriceSearchDto priceSearchDto = new PriceSearchDto();
            priceSearchDto.setBrandId(brandId);
            priceSearchDto.setProductId(productId);
            priceSearchDto.setDate(date);
            runServiceTest(priceSearchDto, expectedPriceIds.get(i));
            i++;
        }

    }

    private void runServiceTest(PriceSearchDto priceSearchDto, Long expectedPriceId) {

        ResponseEntity<Price> responseEntity = priceController.getPrice(priceSearchDto);
        assertNotNull(responseEntity.getBody());
        assertEquals(priceSearchDto.getProductId(), responseEntity.getBody().getProductId());
        assertEquals(priceSearchDto.getBrandId(), responseEntity.getBody().getBrand().getId());
        assertEquals(expectedPriceId, responseEntity.getBody().getId());
    }
}
