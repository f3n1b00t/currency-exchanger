package ru.f3n1b00t.currencyexchanger.domain;

import jakarta.persistence.*;
import lombok.Data;

/**
 * A class that represents a currency.
 * This class provides properties and methods for working with currencies.
 */
@Data
@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, columnDefinition = "serial")
    private Long id;

    @Column(name = "symbol", nullable = false, unique = true)
    private String symbol;

    public Currency() {}

    public Currency(String symbol) {
        this.symbol = symbol;
    }
}