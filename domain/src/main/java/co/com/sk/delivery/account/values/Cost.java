package co.com.sk.delivery.account.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.lang3.Validate;

/**
 * Cost class - Value Object
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public record Cost(Integer value) implements ValueObject<Integer> {

    public Cost(Integer value) {
        if (0 > value) {
            throw new IllegalArgumentException("Cannot be a negative value");
        }
        this.value = Validate.notNull(value, "There's must be a value");
    }
}
