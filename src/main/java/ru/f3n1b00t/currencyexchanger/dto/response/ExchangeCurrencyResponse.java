package ru.f3n1b00t.currencyexchanger.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * A class that represents a response for exchanging currencies.
 * This class contains information about the result of the currency exchange operation.
 */
@Data
@Builder
public class ExchangeCurrencyResponse {
    @JsonProperty("amount")
    double amount;
}
