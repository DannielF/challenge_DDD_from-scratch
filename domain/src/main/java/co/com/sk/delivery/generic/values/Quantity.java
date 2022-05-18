package co.com.sk.delivery.generic.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.lang3.Validate;

/**
 * Quantity class - Value Object
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public record Quantity(Integer value) implements ValueObject<Integer> {

    public Quantity(Integer value) {
        if (0 > value) {
            throw new IllegalArgumentException("Cannot be a negative value");
        }
        this.value = Validate.notNull(value, "Cannot be empty");
    }
}
