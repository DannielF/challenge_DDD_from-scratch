package co.com.sk.delivery.sales.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.lang3.Validate;

/**
 * NumberOfSales class - Value Object
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public record NumberOfSales(Double value) implements ValueObject<Double> {
    public NumberOfSales(Double value) {
        this.value = Validate.notNull(value, "There's must be a value");
    }
}
