package com.example.company.adapters.out.persistence.mappers;

import com.example.company.adapters.out.persistence.entities.PriceEntity;
import com.example.company.core.vos.Price;

public interface PriceEntityMapper {

    static Price of(PriceEntity priceEntity) {
        return new Price(
                priceEntity.getBrandId(),
                priceEntity.getStartDate(),
                priceEntity.getEndDate(),
                priceEntity.getPriceList(),
                priceEntity.getProductId(),
                priceEntity.getPriority(),
                priceEntity.getPrice(),
                priceEntity.getCurr()
        );
    }
}
