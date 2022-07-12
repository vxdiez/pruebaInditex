package com.example.company.adapters.in.rest.mappers;

import com.example.company.adapters.in.rest.dtos.PriceResponseDto;
import com.example.company.core.vos.Price;

import java.util.Optional;

public interface PriceRestMapper {

    static PriceResponseDto of(Price price) {
        return new PriceResponseDto(
                price.getProductId(),
                price.getBrandId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice()
        );
    }

    static Optional<PriceResponseDto> of(Optional<Price> price) {
        PriceResponseDto priceResponseDto = price.isPresent() ? of(price.get()) : null;
        return Optional.ofNullable(priceResponseDto);
    }
}
