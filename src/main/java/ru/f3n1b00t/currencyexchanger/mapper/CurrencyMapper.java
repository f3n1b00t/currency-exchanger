package ru.f3n1b00t.currencyexchanger.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.f3n1b00t.currencyexchanger.domain.Currency;
import ru.f3n1b00t.currencyexchanger.dto.CurrencyDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CurrencyMapper {
    CurrencyDto toCurrencyDto(Currency currency);
    @SuppressWarnings("unused")
    Currency toCurrency(CurrencyDto currencyDto);
}
