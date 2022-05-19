package co.com.sk.delivery.account.events;

import co.com.sk.delivery.account.values.ClientId;
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
    private final ClientId clientId;
    private final Name name;

    public ClientNameUpdated(ClientId clientId, Name name) {
        super("co.com.sk.delivery.ClientNameUpdated");
        this.clientId = clientId;
        this.name = name;
    }

    public ClientId clientId() {
        return clientId;
    }

    public Name name() {
        return name;
    }
}
