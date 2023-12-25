package ru.f3n1b00t.currencyexchanger.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import ru.f3n1b00t.currencyexchanger.dto.CurrencyDto;

import java.util.List;

/**
 * A class that represents a response for retrieving currency pairs.
 * This class contains information about the currency pairs retrieved from the server.
 */
@Data
@Builder
public class GetCurrencyPairsResponse {
    @JsonProperty("currencies")
    List<CurrencyDto> currencies;
}
