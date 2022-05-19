package co.com.sk.delivery.account.events;

import co.com.sk.delivery.generic.values.Name;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * ClientNameUpdated class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class ClientNameUpdated extends DomainEvent {
    private final Name name;

    public ClientNameUpdated(Name name) {
        super("co.com.sk.delivery.ClientNameUpdated");
        this.name = name;
    }

    public Name name() {
        return name;
    }
}
