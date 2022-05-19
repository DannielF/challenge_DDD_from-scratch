package co.com.sk.delivery.account.events;

import co.com.sk.delivery.account.values.ClientId;
import co.com.sk.delivery.account.values.Phone;
import co.com.sk.delivery.generic.values.Name;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * ClientAdded class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class ClientAdded extends DomainEvent {
    private final ClientId clientId;
    private final Name name;
    private final Phone phone;

    public ClientAdded(ClientId clientId, Name name, Phone phone) {
        super("co.com.sk.delivery.ClientAdded");
        this.clientId = clientId;
        this.name = name;
        this.phone = phone;
    }

    public ClientId clientId() {
        return clientId;
    }

    public Name name() {
        return name;
    }

    public Phone phone() {
        return phone;
    }
}
