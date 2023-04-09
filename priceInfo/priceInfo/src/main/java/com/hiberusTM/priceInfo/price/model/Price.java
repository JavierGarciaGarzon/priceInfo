package com.hiberusTM.priceInfo.price.model;

import com.hiberusTM.priceInfo.brand.model.Brand;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PRICES")
public class Price implements Comparable<Price>{

    @Id
    @Column(name = "PRICE_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private Brand brand;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long priceList;

    private Long productId;

    private Integer priority;

    private Double price;

    private String currency;

    @Override
    public int compareTo(Price o) {
        return o.getPriority().compareTo(this.getPriority());
    }

}
