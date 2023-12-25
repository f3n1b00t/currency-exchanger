package ru.f3n1b00t.currencyexchanger.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllCountryCurrenciesResponse {
    @JsonProperty("result")
    String result;
    @JsonProperty("documentation")
    String documentation;
    @JsonProperty("terms_of_use")
    String termsOfUse;
    @JsonProperty("supported_codes")
    List<List<String>> countryCurrencies;
}
