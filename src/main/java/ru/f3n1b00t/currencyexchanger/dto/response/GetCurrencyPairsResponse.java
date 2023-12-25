package ru.f3n1b00t.currencyexchanger.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import ru.f3n1b00t.currencyexchanger.dto.CurrencyDto;

import java.util.List;

@Data
@Builder
public class GetCurrencyPairsResponse {
    @JsonProperty("currencies")
    List<CurrencyDto> currencies;
}
