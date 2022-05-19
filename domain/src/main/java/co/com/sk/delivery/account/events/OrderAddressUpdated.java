package co.com.sk.delivery.account.events;

import co.com.sk.delivery.account.values.Address;
import co.com.sk.delivery.account.values.OrderId;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * OrderAddressUpdated class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class OrderAddressUpdated extends DomainEvent {
    private final OrderId orderId;
    private final Address address;

    public OrderAddressUpdated(OrderId orderId, Address address) {
        super("co.com.sk.delivery.OrderAddressUpdated");
        this.orderId = orderId;
        this.address = address;
    }

    public OrderId orderId() {
        return orderId;
    }

    public Address address() {
        return address;
    }
}
