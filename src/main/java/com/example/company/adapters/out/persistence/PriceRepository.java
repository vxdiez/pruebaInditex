package com.example.company.adapters.out.persistence;

import com.example.company.adapters.out.persistence.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p WHERE p.startDate <= ?1 AND p.endDate > ?1 AND p.productId = ?2 AND p.brandId = ?3")
    List<PriceEntity> findByDateAndProductIdAndBrandId(LocalDateTime applicationDate, Long productId, Long brandId);
}
