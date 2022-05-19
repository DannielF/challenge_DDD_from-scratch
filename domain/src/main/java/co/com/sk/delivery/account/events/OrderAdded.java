package co.com.sk.delivery.account.events;

import co.com.sk.delivery.account.values.Address;
import co.com.sk.delivery.account.values.Description;
import co.com.sk.delivery.account.values.OrderId;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * OrderAdded class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class OrderAdded extends DomainEvent {
    private final OrderId orderId;
    private final Description description;
    private final Address address;

    public OrderAdded(OrderId orderId, Description description, Address address) {
        super("co.com.sk.delivery.OrderAdded");
        this.orderId = orderId;
        this.description = description;
        this.address = address;
    }

    public OrderId orderId() {
        return orderId;
    }

    public Description description() {
        return description;
    }

    public Address address() {
        return address;
    }
}
