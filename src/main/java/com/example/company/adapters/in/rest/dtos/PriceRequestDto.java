package com.example.company.adapters.in.rest.dtos;

import java.time.LocalDateTime;

public record PriceRequestDto(LocalDateTime applicationDate, Long productId, Long brandId) {
}
