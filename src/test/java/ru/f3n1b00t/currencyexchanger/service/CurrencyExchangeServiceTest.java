package ru.f3n1b00t.currencyexchanger.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.f3n1b00t.currencyexchanger.client.CurrencyClient;
import ru.f3n1b00t.currencyexchanger.dto.response.CurrencyExchangeResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyExchangeServiceTest {
    @Mock
    private CurrencyClient currencyClient;
    @InjectMocks
    private CurrencyExchangeService currencyExchangeService;

    @Test
    void testExchange_callClientAndIsOk() {
        CurrencyExchangeResponse response = CurrencyExchangeResponse.builder()
                .conversionResult(100.0)
                .build();

        String fromSymbol = "USD";
        String toSymbol = "RUB";

        when(currencyClient.exchange(fromSymbol, toSymbol, 1))
                .thenReturn(response);

        assertEquals(100.0, currencyExchangeService.exchange(fromSymbol, toSymbol, 1));

        verify(currencyClient).exchange(fromSymbol, toSymbol, 1);
    }
}