package ru.f3n1b00t.currencyexchanger.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.f3n1b00t.currencyexchanger.client.CurrencyClient;
import ru.f3n1b00t.currencyexchanger.dto.response.GetAllCountryCurrenciesResponse;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CurrencyFetcherServiceTest {
    @Mock
    private CurrencyClient currencyClient;
    @Mock
    private CurrencyService currencyService;
    @InjectMocks
    private CurrencyFetcherService currencyFetcherService;

    @Test
    public void testFetchCurrencies_callServiceAndIsOk() {

        GetAllCountryCurrenciesResponse response = GetAllCountryCurrenciesResponse.builder()
                .countryCurrencies(List.of(
                        Collections.singletonList("USD"),
                        Collections.singletonList("RUB"),
                        Collections.singletonList("EUR"),
                        Collections.singletonList("JPY")
                    )
                ).build();

        when(currencyClient.getAllCountryCurrencies())
                .thenReturn(response);

        currencyFetcherService.fetchCurrencies();

        verify(currencyService).clear();
        verify(currencyService).save("USD");
        verify(currencyService).save("RUB");
        verify(currencyService).save("EUR");
        verify(currencyService).save("JPY");
    }
}