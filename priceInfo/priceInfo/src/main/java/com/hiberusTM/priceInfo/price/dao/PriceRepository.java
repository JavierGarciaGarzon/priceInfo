package com.hiberusTM.priceInfo.price.dao;

import com.hiberusTM.priceInfo.price.model.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.PriorityQueue;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

    @Query("""
            SELECT pr
            FROM Price pr
            JOIN pr.brand b
            WHERE b.id = :brandId AND pr.productId = :productId AND (:date BETWEEN pr.startDate AND pr.endDate)
            ORDER BY pr.priority ASC
            """)
    PriorityQueue<Price> findByBrandProductAndDate(@Param("brandId") Long brandId, @Param("productId") Long productId, @Param("date") LocalDateTime appDate);
}
