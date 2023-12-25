package ru.f3n1b00t.currencyexchanger.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.f3n1b00t.currencyexchanger.service.CurrencyService;

@Component
public class CurrencySymbolValidator implements ConstraintValidator<CurrencySymbol, String> {
    private final CurrencyService currencyService;

    @Autowired
    public CurrencySymbolValidator(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return currencyService.existsBySymbol(value);
    }
}
