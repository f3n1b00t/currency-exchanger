package ru.f3n1b00t.currencyexchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.f3n1b00t.currencyexchanger.client.CurrencyClient;

import java.util.List;

/**
 * A class that fetches currency data from an external API.
 * This class provides methods for retrieving currency data from an external API and updating the local currency database.
 */
@Service
public class CurrencyFetcherService {
    private final CurrencyClient currencyClient;
    private final CurrencyService currencyService;

    @Autowired
    public CurrencyFetcherService(CurrencyClient currencyClient, CurrencyService currencyService) {
        this.currencyClient = currencyClient;
        this.currencyService = currencyService;
    }

    @Scheduled(fixedDelay = 3600000)
    public void fetchCurrencies() {
        currencyService.clear();

        for(List<String> currency : currencyClient.getAllCountryCurrencies().getCountryCurrencies()) {
            currencyService.save(currency.get(0));
        }
    }
}
