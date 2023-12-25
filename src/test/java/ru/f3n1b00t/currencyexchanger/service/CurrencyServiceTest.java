package ru.f3n1b00t.currencyexchanger.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.f3n1b00t.currencyexchanger.domain.Currency;
import ru.f3n1b00t.currencyexchanger.dto.CurrencyDto;
import ru.f3n1b00t.currencyexchanger.mapper.CurrencyMapper;
import ru.f3n1b00t.currencyexchanger.repository.CurrencyRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceTest {
    @Mock
    private CurrencyRepository currencyRepository;
    @Mock
    private CurrencyMapper currencyMapper;
    @InjectMocks
    private CurrencyService currencyService;


    @Test
    void testGetCurrencyPairs_callRepositoryAndMapper() {
        List<Currency> domainCurrencies = List.of(
                new Currency("RUB")
        );

        List<CurrencyDto> expectedCurrencyPairs = List.of(
                new CurrencyDto("RUB")
        );

        when(currencyRepository.getCurrencyPairs("USD"))
                .thenReturn(domainCurrencies);

        when(currencyMapper.toCurrencyDto(domainCurrencies.get(0)))
                .thenReturn(expectedCurrencyPairs.get(0));

        List<CurrencyDto> currencyPairs = currencyService.getCurrencyPairs("USD");

        assertEquals(expectedCurrencyPairs, currencyPairs);

        verify(currencyRepository).getCurrencyPairs("USD");
        verify(currencyMapper).toCurrencyDto(domainCurrencies.get(0));
    }

    @Test
    void testExistsBySymbol_callRepositoryAndMapper() {
        String symbol = "USD";
        when(currencyRepository.existsBySymbol(symbol))
                .thenReturn(true);

        assertTrue(currencyService.existsBySymbol(symbol));

        verify(currencyRepository).existsBySymbol(symbol);
    }
}