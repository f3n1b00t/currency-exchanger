package ru.f3n1b00t.currencyexchanger.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.f3n1b00t.currencyexchanger.dto.request.ExchangeCurrencyRequest;
import ru.f3n1b00t.currencyexchanger.dto.request.GetCurrencyPairsRequest;
import ru.f3n1b00t.currencyexchanger.dto.response.CurrencyValidationErrorResponse;
import ru.f3n1b00t.currencyexchanger.dto.response.ExchangeCurrencyResponse;
import ru.f3n1b00t.currencyexchanger.dto.response.GetCurrencyPairsResponse;
import ru.f3n1b00t.currencyexchanger.service.CurrencyExchangeService;
import ru.f3n1b00t.currencyexchanger.service.CurrencyService;

@RestController
@RequestMapping("/v1/currency")
public class CurrencyController {
    private final CurrencyService currencyService;
    private final CurrencyExchangeService currencyExchangeService;

    public CurrencyController(CurrencyService currencyService, CurrencyExchangeService currencyExchangeService) {
        this.currencyService = currencyService;
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping("/pair")
    public GetCurrencyPairsResponse getCurrencyPairs(@Valid GetCurrencyPairsRequest request) {
        return GetCurrencyPairsResponse.builder()
                .currencies(currencyService.getCurrencyPairs(request.getSymbol()))
                .build();
    }

    @PostMapping("/exchange")
    public ExchangeCurrencyResponse exchangeCurrency(@Valid @RequestBody ExchangeCurrencyRequest request) {
        return ExchangeCurrencyResponse.builder()
                .amount(currencyExchangeService.exchange(request.getFrom(), request.getTo(), request.getAmount()))
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CurrencyValidationErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        return CurrencyValidationErrorResponse.builder()
                .message(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                .build();
    }

}
