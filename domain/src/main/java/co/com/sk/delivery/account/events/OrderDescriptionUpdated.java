package co.com.sk.delivery.account.events;

import co.com.sk.delivery.account.values.Description;
import co.com.sk.delivery.account.values.OrderId;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * OrderDescriptionUpdated class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class OrderDescriptionUpdated extends DomainEvent {
    private final OrderId orderId;
    private final Description description;

    public OrderDescriptionUpdated(OrderId orderId, Description description) {
        super("co.com.sk.delivery.OrderDescriptionUpdated");
        this.orderId = orderId;
        this.description = description;
    }

    public OrderId orderId() {
        return orderId;
    }

    public Description description() {
        return description;
    }
}
