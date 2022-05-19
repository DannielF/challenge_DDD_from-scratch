package co.com.sk.delivery.delivery.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.lang3.Validate;

/**
 * Constraints class - Value Object
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public record Constraints(String value) implements ValueObject<String> {
    public Constraints(String value) {
        this.value = Validate.notNull(value, "Cannot be empty");
    }
}
