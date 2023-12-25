package ru.f3n1b00t.currencyexchanger.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * A class that represents a validation error response for currency operations.
 * This class contains information about the validation errors that occurred during currency operations.
 */
@Data
@Builder
public class CurrencyValidationErrorResponse {
    @JsonProperty("message")
    String message;
}
