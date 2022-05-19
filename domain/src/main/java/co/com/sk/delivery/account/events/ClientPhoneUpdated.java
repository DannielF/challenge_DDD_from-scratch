package co.com.sk.delivery.account.events;

import co.com.sk.delivery.account.values.ClientId;
import co.com.sk.delivery.account.values.Phone;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * ClientPhoneUpdated class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class ClientPhoneUpdated extends DomainEvent {
    private final ClientId clientId;
    private final Phone phone;

    public ClientPhoneUpdated(ClientId clientId, Phone phone) {
        super("co.com.sk.delivery.ClientPhoneUpdated");
        this.clientId = clientId;
        this.phone = phone;
    }

    public ClientId clientId() {
        return clientId;
    }

    public Phone phone() {
        return phone;
    }
}
