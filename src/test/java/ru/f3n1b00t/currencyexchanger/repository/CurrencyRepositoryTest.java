package ru.f3n1b00t.currencyexchanger.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.f3n1b00t.currencyexchanger.domain.Currency;
import ru.f3n1b00t.currencyexchanger.service.CurrencyFetcherService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = {CurrencyRepositoryTest.Initializer.class})
public class CurrencyRepositoryTest {
    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:14-alpine");
    @Autowired
    private CurrencyRepository currencyRepository;
    @SuppressWarnings("unused")
    @MockBean //Disable auto fetching of symbols
    private CurrencyFetcherService currencyFetcherService;

    @BeforeEach
    public void setUp() {
        currencyRepository.deleteAll();
        currencyRepository.save(new Currency("RUB"));
        currencyRepository.save(new Currency("USD"));
        currencyRepository.save(new Currency("EUR"));
    }

    @Test
    public void testGetCurrencyPairs_isOk(){
        assertEquals(2, currencyRepository.getCurrencyPairs("RUB").size());
        assertEquals(2, currencyRepository.getCurrencyPairs("USD").size());
        assertEquals(2, currencyRepository.getCurrencyPairs("EUR").size());
    }

    @Test
    public void testExistBySymbol_isOk() {
        assertTrue(currencyRepository.existsBySymbol("RUB"));
        assertTrue(currencyRepository.existsBySymbol("USD"));
        assertTrue(currencyRepository.existsBySymbol("EUR"));
    }

    @AfterEach
    public void tearDown() {
        currencyRepository.deleteAll();
    }

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}
