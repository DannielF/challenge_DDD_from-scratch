package co.com.sk.delivery.delivery.commands;

import co.com.sk.delivery.delivery.values.DelivererId;
import co.com.sk.delivery.delivery.values.DeliveryId;
import co.com.sk.delivery.delivery.values.TypeContract;
import co.com.sofka.domain.generic.Command;

/**
 * UpdateTypeContractDeliverer class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class UpdateTypeContractDeliverer extends Command {
    private final DeliveryId deliveryId;
    private final DelivererId delivererId;
    private final TypeContract typeContract;

    public UpdateTypeContractDeliverer(DeliveryId deliveryId, DelivererId delivererId, TypeContract typeContract) {
        this.deliveryId = deliveryId;
        this.delivererId = delivererId;
        this.typeContract = typeContract;
    }

    public DeliveryId deliveryId() {
        return deliveryId;
    }

    public DelivererId delivererId() {
        return delivererId;
    }

    public TypeContract typeContract() {
        return typeContract;
    }
}
