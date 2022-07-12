package com.example.company.adapters.in.rest;

import com.example.company.adapters.in.rest.dtos.PriceRequestDto;
import com.example.company.adapters.in.rest.dtos.PriceResponseDto;
import com.example.company.adapters.in.rest.mappers.PriceRestMapper;
import com.example.company.ports.in.PriceReadInPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PriceController {

    private PriceReadInPort priceReadInPort;

    public PriceController(PriceReadInPort priceReadInPort) {
        this.priceReadInPort = priceReadInPort;
    }

    @GetMapping(value = "/findByDateAndProductIdAndBrandId")
    ResponseEntity<PriceResponseDto> findByDateAndProductIdAndBrandId(@RequestBody PriceRequestDto priceRequestDto){

        HttpStatus status = HttpStatus.OK;

        Optional<PriceResponseDto> responseDto = PriceRestMapper.of(priceReadInPort.findByDateAndProductIdAndBrandId(
                priceRequestDto.applicationDate(), priceRequestDto.productId(), priceRequestDto.brandId()));

        if(responseDto.isEmpty()){
            status = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity.status(status).body(responseDto.orElse(null));
    }
}
