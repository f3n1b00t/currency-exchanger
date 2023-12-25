package ru.f3n1b00t.currencyexchanger.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.f3n1b00t.currencyexchanger.dto.response.CurrencyExchangeResponse;
import ru.f3n1b00t.currencyexchanger.dto.response.GetAllCountryCurrenciesResponse;

/**
 * A class that represents a currency client.
 * This class provides methods for interacting with a currency service.
 */
@Component
@FeignClient(name = "currencies", url = "https://v6.exchangerate-api.com/v6/cfcbd38cc419be7d3e611ef9")
public interface CurrencyClient {
    @GetMapping(value = "/pair/{from-currency}/{to-currency}/{amount}", consumes = "application/json")
    CurrencyExchangeResponse exchange(@PathVariable("from-currency") String fromCurrency,
                                      @PathVariable("to-currency") String toCurrency,
                                      @PathVariable("amount") double amount);

    @GetMapping(value = "/codes", consumes = "application/json")
    GetAllCountryCurrenciesResponse getAllCountryCurrencies();
}
