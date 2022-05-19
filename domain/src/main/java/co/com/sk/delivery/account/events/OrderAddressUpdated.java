package co.com.sk.delivery.account.events;

import co.com.sk.delivery.account.values.Address;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * OrderAddressUpdated class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class OrderAddressUpdated extends DomainEvent {
    private final Address address;

    public OrderAddressUpdated(Address address) {
        super("co.com.sk.delivery.OrderAddressUpdated");
        this.address = address;
    }

    public Address address() {
        return address;
    }
}
