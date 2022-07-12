package com.example.company.adapters.in.rest.dtos;

import java.time.LocalDateTime;

public record PriceResponseDto(Long productId,Long brandId,Long priceList,
                               LocalDateTime startDate,LocalDateTime endDate,Double price) {
}
