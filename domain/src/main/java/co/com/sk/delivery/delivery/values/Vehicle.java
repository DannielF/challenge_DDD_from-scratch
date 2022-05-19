package co.com.sk.delivery.delivery.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.lang3.Validate;
/**
 * Vehicle class - Value Object
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public record Vehicle(String value) implements ValueObject<String> {

    public Vehicle(String value) {
        this.value = Validate.notNull(value, "Cannot be empty");
    }
}
