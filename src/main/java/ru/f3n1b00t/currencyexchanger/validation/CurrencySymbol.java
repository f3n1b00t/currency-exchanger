package ru.f3n1b00t.currencyexchanger.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CurrencySymbolValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrencySymbol {
    String message() default "symbol is invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
