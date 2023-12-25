package ru.f3n1b00t.currencyexchanger.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * A custom annotation for validating currency symbols.
 * This annotation is used in conjunction with the CurrencySymbolValidator class to validate currency symbols.
 * It can be applied to fields and is evaluated at runtime.
 */
@Documented
@Constraint(validatedBy = CurrencySymbolValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrencySymbol {
    String message() default "symbol is invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
