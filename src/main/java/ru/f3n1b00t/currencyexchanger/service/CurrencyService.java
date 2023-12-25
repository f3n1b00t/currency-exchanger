package ru.f3n1b00t.currencyexchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.f3n1b00t.currencyexchanger.domain.Currency;
import ru.f3n1b00t.currencyexchanger.dto.CurrencyDto;
import ru.f3n1b00t.currencyexchanger.mapper.CurrencyMapper;
import ru.f3n1b00t.currencyexchanger.repository.CurrencyRepository;

import java.util.List;

@Service
public class CurrencyService {
    private final CurrencyMapper currencyMapper;
    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository, CurrencyMapper currencyMapper) {
        this.currencyRepository = currencyRepository;
        this.currencyMapper = currencyMapper;
    }
    public List<CurrencyDto> getCurrencyPairs(String currency) {
        return currencyRepository.getCurrencyPairs(currency)
                .stream()
                .map(currencyMapper::toCurrencyDto)
                .toList();
    }

    public boolean existsBySymbol(String value) {
        return currencyRepository.existsBySymbol(value);
    }

    public void save(String symbol) {
        currencyRepository.save(new Currency(symbol));
    }

    public void clear() {
        currencyRepository.deleteAll();
    }
}
