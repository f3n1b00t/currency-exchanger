package ru.f3n1b00t.currencyexchanger.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@SuppressWarnings("unused")
public class LoggingAspect {
    @Pointcut("execution(public * ru.f3n1b00t.currencyexchanger.client.CurrencyClient.*(..))")
    public void callAtCurrencyClient() {}

    @AfterReturning(value = "callAtCurrencyClient()", returning = "result")
    public void afterCallAtCurrencyClient(JoinPoint jp, Object result) {
        log.info("ExchangeRate API response: " + result);
    }
}
