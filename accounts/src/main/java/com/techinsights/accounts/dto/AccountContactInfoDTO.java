package com.techinsights.accounts.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
//public record AccountContactInfoDTO(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
//}

@Data
public class AccountContactInfoDTO {
    private String message;
    private Map<String, String> contactDetails;
    private  List<String> onCallSupport;
}
