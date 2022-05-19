package co.com.sk.delivery.delivery.events;

import co.com.sk.delivery.delivery.values.State;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * StateUpdated class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class StateUpdated extends DomainEvent {
    private final State state;

    public StateUpdated(State state) {
        super("co.com.sk.delivery.StateUpdated");
        this.state = state;
    }

    public State state() {
        return state;
    }
}
