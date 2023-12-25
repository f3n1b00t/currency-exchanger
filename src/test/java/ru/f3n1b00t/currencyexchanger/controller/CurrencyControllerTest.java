package ru.f3n1b00t.currencyexchanger.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.f3n1b00t.currencyexchanger.dto.request.ExchangeCurrencyRequest;
import ru.f3n1b00t.currencyexchanger.dto.request.GetCurrencyPairsRequest;
import ru.f3n1b00t.currencyexchanger.dto.CurrencyDto;
import ru.f3n1b00t.currencyexchanger.dto.response.ExchangeCurrencyResponse;
import ru.f3n1b00t.currencyexchanger.dto.response.GetCurrencyPairsResponse;
import ru.f3n1b00t.currencyexchanger.service.CurrencyExchangeService;
import ru.f3n1b00t.currencyexchanger.service.CurrencyService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyControllerTest {
    @Mock
    private CurrencyService currencyService;
    @Mock
    private CurrencyExchangeService currencyExchangeService;
    @InjectMocks
    private CurrencyController currencyController;

    @Test
    void testGetCurrencyPairs_callServiceAndIsOk() {
        String currency = "USD";
        List<CurrencyDto> currencyPairs = List.of(
                new CurrencyDto("USD"),
                new CurrencyDto("EUR")
        );

        GetCurrencyPairsRequest request = GetCurrencyPairsRequest.builder()
                .symbol(currency)
                .build();

        when(currencyService.getCurrencyPairs(currency))
                .thenReturn(currencyPairs);

        GetCurrencyPairsResponse response = currencyController.getCurrencyPairs(request);
        assertEquals(currencyPairs, response.getCurrencies());

        verify(currencyService).getCurrencyPairs(currency);
    }

    @Test
    void testExchangeCurrency_callServiceAndIsNotOk() {
        ExchangeCurrencyRequest request = ExchangeCurrencyRequest.builder()
                .from("USD")
                .to("RUB")
                .amount(100)
                .build();

        when(currencyExchangeService.exchange(
                request.getFrom(),
                request.getTo(),
                request.getAmount()
            )
        ).thenReturn(100.0);


        ExchangeCurrencyResponse response = currencyController
                .exchangeCurrency(request);

        assertEquals(100.0, response.getAmount());

        verify(currencyExchangeService).exchange(
                request.getFrom(),
                request.getTo(),
                request.getAmount()
        );
    }
}