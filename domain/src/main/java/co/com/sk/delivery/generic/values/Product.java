package co.com.sk.delivery.generic.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.lang3.Validate;

/**
 * Product class - Value Object
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public record Product(String value) implements ValueObject<String> {

    public Product(String value) {
        if (2 > value.length()) {
            throw new IllegalArgumentException("Must be a correct product name");
        }
        this.value = Validate.notNull(value, "Cannot be null");
    }
}
