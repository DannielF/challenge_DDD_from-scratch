package co.com.sk.delivery.delivery.events;

import co.com.sk.delivery.delivery.values.DelivererId;
import co.com.sk.delivery.delivery.values.TypeContract;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * TypeContractDelivererUpdated class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class TypeContractDelivererUpdated extends DomainEvent {
    private final DelivererId delivererId;
    private final TypeContract typeContract;

    public TypeContractDelivererUpdated(DelivererId delivererId, TypeContract typeContract) {
        super("co.com.sk.delivery.TypeContractDelivererUpdated");
        this.delivererId = delivererId;
        this.typeContract = typeContract;
    }

    public DelivererId delivererId() {
        return delivererId;
    }

    public TypeContract typeContract() {
        return typeContract;
    }
}
