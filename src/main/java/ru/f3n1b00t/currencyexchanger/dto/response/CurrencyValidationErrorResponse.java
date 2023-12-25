package ru.f3n1b00t.currencyexchanger.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyValidationErrorResponse {
    @JsonProperty("message")
    String message;
}
