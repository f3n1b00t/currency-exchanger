package ru.f3n1b00t.currencyexchanger.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;
import ru.f3n1b00t.currencyexchanger.validation.CurrencySymbol;

/**
 * A class that represents a request to exchange currencies.
 * This class contains information about the currencies to be exchanged and the desired exchange rate.
 */
@Data
@Builder
public class ExchangeCurrencyRequest {
    @CurrencySymbol
    @JsonProperty("from_symbol")
    String from;
    @CurrencySymbol
    @JsonProperty("to_symbol")
    String to;
    @Min(0)
    @JsonProperty("amount")
    double amount;
}
