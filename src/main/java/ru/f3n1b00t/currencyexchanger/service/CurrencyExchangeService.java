package ru.f3n1b00t.currencyexchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.f3n1b00t.currencyexchanger.client.CurrencyClient;

@Service
public class CurrencyExchangeService {
    private final CurrencyClient currencyClient;

    @Autowired
    public CurrencyExchangeService(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }
    public double exchange(String fromSymbol, String toSymbol, double amount) {
        return currencyClient.exchange(fromSymbol, toSymbol, amount).getConversionResult();
    }
}
