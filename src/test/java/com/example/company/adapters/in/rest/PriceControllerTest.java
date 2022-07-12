package com.example.company.adapters.in.rest;

import com.example.company.adapters.in.rest.dtos.PriceRequestDto;
import com.example.company.adapters.in.rest.dtos.PriceResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PriceControllerTest {

    @Autowired
    public PriceController priceController;

    private static final Long PRODUCT_ID = 35455L;
    private static final Long NONEXISTENT_PRODUCT_ID = 11111L;
    private static final Long BRAND_ID = 1L;
    private static final Double PRICE_35_50 = 35.50;
    private static final Double PRICE_25_45 = 25.45;
    private static final Double PRICE_30_50 = 30.50;
    private static final Double PRICE_38_95 = 38.95;

    private static final LocalDateTime DATE_14_06_10_00 = LocalDateTime.of(2020, 6, 14, 10, 0);
    private static final LocalDateTime DATE_14_06_16_00 = LocalDateTime.of(2020, 6, 14, 16, 0);
    private static final LocalDateTime DATE_14_06_21_00 = LocalDateTime.of(2020, 6, 14, 21, 0);
    private static final LocalDateTime DATE_15_06_10_00 = LocalDateTime.of(2020, 6, 15, 10, 0);
    private static final LocalDateTime DATE_16_06_21_00 = LocalDateTime.of(2020, 6, 16, 21, 0);

    private static final PriceRequestDto REQUEST_14_06_10_00 = new PriceRequestDto(DATE_14_06_10_00, PRODUCT_ID, BRAND_ID);
    private static final PriceRequestDto REQUEST_14_06_16_00 = new PriceRequestDto(DATE_14_06_16_00, PRODUCT_ID, BRAND_ID);
    private static final PriceRequestDto REQUEST_14_06_21_00 = new PriceRequestDto(DATE_14_06_21_00, PRODUCT_ID, BRAND_ID);
    private static final PriceRequestDto REQUEST_15_06_10_00 = new PriceRequestDto(DATE_15_06_10_00, PRODUCT_ID, BRAND_ID);
    private static final PriceRequestDto REQUEST_16_06_21_00 = new PriceRequestDto(DATE_16_06_21_00, PRODUCT_ID, BRAND_ID);
    private static final PriceRequestDto REQUEST_NONEXISTENT_PRODUCT = new PriceRequestDto(DATE_16_06_21_00, NONEXISTENT_PRODUCT_ID, BRAND_ID);

    @Test
    @DisplayName("Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void date14061000_should_return_status_ok_and_price() {

        ResponseEntity<PriceResponseDto> responseDto = priceController.findByDateAndProductIdAndBrandId(REQUEST_14_06_10_00);

        assertEquals(HttpStatus.OK, responseDto.getStatusCode());
        assertNotNull(responseDto.getBody());
        assertEquals(PRICE_35_50, responseDto.getBody().price());
    }

    @Test
    @DisplayName("Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void date14061600_should_return_status_ok_and_price() {

        ResponseEntity<PriceResponseDto> responseDto = priceController.findByDateAndProductIdAndBrandId(REQUEST_14_06_16_00);

        assertEquals(HttpStatus.OK, responseDto.getStatusCode());
        assertNotNull(responseDto.getBody());
        assertEquals(PRICE_25_45, responseDto.getBody().price());
    }

    @Test
    @DisplayName("Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void date14062100_should_return_status_ok_and_price() {

        ResponseEntity<PriceResponseDto> responseDto = priceController.findByDateAndProductIdAndBrandId(REQUEST_14_06_21_00);

        assertEquals(HttpStatus.OK, responseDto.getStatusCode());
        assertNotNull(responseDto.getBody());
        assertEquals(PRICE_35_50, responseDto.getBody().price());
    }

    @Test
    @DisplayName("Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void date15061000_should_return_status_ok_and_price() {

        ResponseEntity<PriceResponseDto> responseDto = priceController.findByDateAndProductIdAndBrandId(REQUEST_15_06_10_00);

        assertEquals(HttpStatus.OK, responseDto.getStatusCode());
        assertNotNull(responseDto.getBody());
        assertEquals(PRICE_30_50, responseDto.getBody().price());
    }

    @Test
    @DisplayName("Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void date16062100_should_return_status_ok_and_price() {

        ResponseEntity<PriceResponseDto> responseDto = priceController.findByDateAndProductIdAndBrandId(REQUEST_16_06_21_00);

        assertEquals(HttpStatus.OK, responseDto.getStatusCode());
        assertNotNull(responseDto.getBody());
        assertEquals(PRICE_38_95, responseDto.getBody().price());
    }

    @Test
    @DisplayName("Petición con producto inexistente")
    void nonexistent_product_should_return_not_found() {

        ResponseEntity<PriceResponseDto> responseDto = priceController.findByDateAndProductIdAndBrandId(REQUEST_NONEXISTENT_PRODUCT);

        assertEquals(HttpStatus.NOT_FOUND, responseDto.getStatusCode());
        assertNull(responseDto.getBody());
    }
}