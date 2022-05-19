package co.com.sk.delivery.delivery.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.lang3.Validate;

/**
 * State class - Value Object
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public record State(State.states value) implements ValueObject<State.states> {
    public State(State.states value) {
        this.value = Validate.notNull(value, "Cannot be empty");
    }

    public enum states {
        IN_PROGRESS, CANCELLED, STAND_BY, DONE
    }
}

