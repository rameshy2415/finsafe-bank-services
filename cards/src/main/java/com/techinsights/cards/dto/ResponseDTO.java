package com.techinsights.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
public class ResponseDTO {

    @Schema(
            description = "Status code in the response"
    )
    private String statusCode;

    @Schema(
            description = "Status message in the response"
    )
    private String statusMsg;

    @Schema(
            description = "Data in the response"
    )
    private Object data;

}
