package com.techinsights.accounts.client;

import com.techinsights.accounts.dto.CardDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient{
    @Override
    public ResponseEntity<CardDTO> fetchCardDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
