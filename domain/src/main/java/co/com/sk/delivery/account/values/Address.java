package co.com.sk.delivery.account.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.lang3.Validate;

/**
 * Address class - Value Object
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public record Address(String value) implements ValueObject<String> {

    public Address(String value) {
        this.value = Validate.notNull(value, "There's must be a value");
    }
}
