package ru.f3n1b00t.currencyexchanger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO for {@link ru.f3n1b00t.currencyexchanger.domain.Currency}
 */
@Data
@AllArgsConstructor
public class CurrencyDto {
    String symbol;
}