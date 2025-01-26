package com.techinsights.accounts.client;

import com.techinsights.accounts.dto.CardDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards", fallback = CardsFallback.class)
public interface CardsFeignClient {

    @GetMapping(value = "/api/fetch",consumes = "application/json")
    ResponseEntity<CardDTO> fetchCardDetails(@RequestHeader("finsafebank-correlation-id") String correlationID, @RequestParam String mobileNumber);

}
