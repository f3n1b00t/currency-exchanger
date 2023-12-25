package ru.f3n1b00t.currencyexchanger.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * A class that represents a response for currency exchange.
 */
@Data
@Builder
public class CurrencyExchangeResponse {
    @JsonProperty("result")
    String result;
    @JsonProperty("documentation")
    String documentation;
    @JsonProperty("terms_of_use")
    String termsOfUse;
    @JsonProperty("time_last_update_unix")
    String timeLastUpdateUnix;
    @JsonProperty("time_last_update_utc")
    String timeLastUpdateUTC;
    @JsonProperty("time_next_update_unix")
    String timeNextUpdateUnix;
    @JsonProperty("time_next_update_utc")
    String timeNextUpdateUTC;
    @JsonProperty("base_code")
    String baseCode;
    @JsonProperty("target_code")
    String targetCode;
    @JsonProperty("conversion_rate")
    String conversionRate;
    @JsonProperty("conversion_result")
    double conversionResult;
}
