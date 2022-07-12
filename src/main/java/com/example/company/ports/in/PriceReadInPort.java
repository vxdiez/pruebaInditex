package com.example.company.ports.in;

import com.example.company.core.vos.Price;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public interface PriceReadInPort {

    Optional<Price> findByDateAndProductIdAndBrandId(final LocalDateTime applicationDate, final Long productId,
                                                     final Long brandId);
}
