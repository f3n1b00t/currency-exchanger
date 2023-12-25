package ru.f3n1b00t.currencyexchanger.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import ru.f3n1b00t.currencyexchanger.validation.CurrencySymbol;

/**
 * A class that represents a request to get currency pairs.
 * This class contains information about the request parameters for retrieving currency pairs.
 */
@Data
@Builder
public class GetCurrencyPairsRequest {
    @CurrencySymbol
    @JsonProperty("symbol")
    String symbol;
}
