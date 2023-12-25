package ru.f3n1b00t.currencyexchanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.f3n1b00t.currencyexchanger.domain.Currency;

import java.util.List;

/**
 * A class that represents a repository for managing currency data.
 * This class provides methods for accessing and manipulating currency data in a data source.
 */
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Query("select c from Currency c where c.symbol <> :symbol")
    List<Currency> getCurrencyPairs(@Param("symbol") String symbol);

    @Query("select (count(c) > 0) from Currency c where upper(c.symbol) = upper(:symbol)")
    boolean existsBySymbol(@Param("symbol") String symbol);
}
