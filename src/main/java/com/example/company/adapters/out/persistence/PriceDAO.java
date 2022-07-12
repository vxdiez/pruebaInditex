package com.example.company.adapters.out.persistence;

import com.example.company.adapters.out.persistence.mappers.PriceEntityMapper;
import com.example.company.core.vos.Price;
import com.example.company.ports.out.PriceReadOutPort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PriceDAO implements PriceReadOutPort {

    private PriceRepository priceRepository;

    public PriceDAO(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<Price> findByDateAndProductIdAndBrandId(LocalDateTime applicationDate, Long productId, Long brandId) {
        return priceRepository.findByDateAndProductIdAndBrandId(applicationDate, productId, brandId)
                .stream()
                .map(PriceEntityMapper::of)
                .toList();
    }
}
