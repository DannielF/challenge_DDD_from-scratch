package co.com.sk.delivery.sales.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.lang3.Validate;

/**
 * Salary class - Value Object
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public record Salary(Integer value) implements ValueObject<Integer> {
    public Salary(Integer value) {
        this.value = Validate.notNull(value, "Cannot be empty");
    }
}
