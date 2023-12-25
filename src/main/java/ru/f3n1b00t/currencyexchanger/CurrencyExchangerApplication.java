package ru.f3n1b00t.currencyexchanger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
public class CurrencyExchangerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangerApplication.class, args);
    }

}
