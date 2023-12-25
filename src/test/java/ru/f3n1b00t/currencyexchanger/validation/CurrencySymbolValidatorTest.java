package ru.f3n1b00t.currencyexchanger.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.f3n1b00t.currencyexchanger.service.CurrencyService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencySymbolValidatorTest {
    @Mock
    private CurrencyService currencyService;
    @InjectMocks
    private CurrencySymbolValidator currencySymbolValidator;

    @Test
    void testIsValid_callServiceAndIsOk() {
        String symbol = "USD";

        when(currencyService.existsBySymbol(symbol))
                .thenReturn(true);

        assertTrue(currencySymbolValidator.isValid(symbol, null));

        verify(currencyService).existsBySymbol(symbol);
    }
}