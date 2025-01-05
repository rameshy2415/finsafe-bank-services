package com.techinsights.loans.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;


/*public record LoanContactInfoDTO(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}*/



@ConfigurationProperties(prefix = "loans")
@Data
public class LoanContactInfoDTO{
    private String message;
    private Map<String, String> contactDetails;
    private  List<String> onCallSupport;
}

