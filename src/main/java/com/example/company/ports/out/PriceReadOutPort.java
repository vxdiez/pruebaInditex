package com.example.company.ports.out;

import com.example.company.core.vos.Price;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface PriceReadOutPort {
    List<Price> findByDateAndProductIdAndBrandId(final LocalDateTime applicationDate, final Long productId,
                                                 final Long brandId);
}
