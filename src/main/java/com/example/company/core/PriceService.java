package com.example.company.core;

import com.example.company.core.vos.Price;
import com.example.company.ports.in.PriceReadInPort;
import com.example.company.ports.out.PriceReadOutPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

@Service
public class PriceService implements PriceReadInPort {

    PriceReadOutPort priceReadOutPort;

    public PriceService(PriceReadOutPort priceReadOutPort) {
        this.priceReadOutPort = priceReadOutPort;
    }

    @Override
    public Optional<Price> findByDateAndProductIdAndBrandId(LocalDateTime applicationDate, Long productId, Long brandId) {
        return priceReadOutPort.findByDateAndProductIdAndBrandId(applicationDate, productId, brandId)
                .stream()
                .max(Comparator.comparing(Price::getPriority));
    }
}
