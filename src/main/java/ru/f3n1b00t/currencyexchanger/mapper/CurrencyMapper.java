package ru.f3n1b00t.currencyexchanger.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.f3n1b00t.currencyexchanger.domain.Currency;
import ru.f3n1b00t.currencyexchanger.dto.CurrencyDto;

/**
 * A class that maps currency data between different formats.
 * This class provides methods to map currency data between different representations, such as DTOs and entity objects.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CurrencyMapper {
    CurrencyDto toCurrencyDto(Currency currency);
    @SuppressWarnings("unused")
    Currency toCurrency(CurrencyDto currencyDto);
}
