package com.techinsights.cards.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;


//public record CardContactInfoDTO(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
//}

@ConfigurationProperties(prefix = "cards")
@Data
public class CardContactInfoDTO {
    private String message;
    private Map<String, String> contactDetails;
    private  List<String> onCallSupport;
}
