package com.techinsights.accounts.client;

import com.techinsights.accounts.dto.LoanDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "loans", fallback = LoansFallback.class)
public interface LoansFeignClient {

    @GetMapping(value = "/api/fetch",consumes = "application/json")
    ResponseEntity<LoanDTO> fetchLoanDetails(@RequestHeader("finsafebank-correlation-id") String correlationID, @RequestParam String mobileNumber);

}
