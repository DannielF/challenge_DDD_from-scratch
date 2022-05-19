package co.com.sk.delivery.delivery.events;

import co.com.sk.delivery.delivery.values.DelivererId;
import co.com.sk.delivery.delivery.values.TypeContract;
import co.com.sk.delivery.generic.values.Name;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * DelivererAdded class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class DelivererAdded extends DomainEvent {
    private final DelivererId delivererId;
    private final Name name;
    private final TypeContract typeContract;

    public DelivererAdded(DelivererId delivererId, Name name, TypeContract typeContract) {
        super("co.com.sk.delivery.DelivererAdded");
        this.delivererId = delivererId;
        this.name = name;
        this.typeContract = typeContract;
    }

    public DelivererId delivererId() {
        return delivererId;
    }

    public Name name() {
        return name;
    }

    public TypeContract typeContract() {
        return typeContract;
    }
}
