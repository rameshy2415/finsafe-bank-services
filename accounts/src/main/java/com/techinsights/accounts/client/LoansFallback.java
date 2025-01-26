package com.techinsights.accounts.client;

import com.techinsights.accounts.dto.LoanDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient{
    @Override
    public ResponseEntity<LoanDTO> fetchLoanDetails(String correlationID, String mobileNumber) {
        return null;
    }
}
