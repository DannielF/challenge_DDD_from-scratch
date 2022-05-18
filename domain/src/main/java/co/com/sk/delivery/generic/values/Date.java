package co.com.sk.delivery.generic.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.lang3.Validate;

import java.time.DateTimeException;
import java.time.Instant;

/**
 * Date class - Value Object
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public record Date(Instant value) implements ValueObject<Instant> {

    private static final String VALIDATION_MESSAGE = "Cannot be empty";

    public Date(Instant value) {
        if (value.isAfter(Instant.now())) {
            throw new DateTimeException("That's no possible");
        }
        this.value = Validate.notNull(value, VALIDATION_MESSAGE);
    }
}
