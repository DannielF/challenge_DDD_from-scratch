package co.com.sk.delivery.delivery.commands;

import co.com.sk.delivery.delivery.values.DeliveryId;
import co.com.sk.delivery.delivery.values.TypeContract;
import co.com.sk.delivery.generic.values.Name;
import co.com.sofka.domain.generic.Command;

/**
 * AddDeliverer class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class AddDeliverer extends Command {
    private final DeliveryId deliveryId;
    private final Name name;
    private final TypeContract typeContract;

    public AddDeliverer(DeliveryId deliveryId, Name name, TypeContract typeContract) {
        this.deliveryId = deliveryId;
        this.name = name;
        this.typeContract = typeContract;
    }

    public DeliveryId deliveryId() {
        return deliveryId;
    }

    public Name name() {
        return name;
    }

    public TypeContract typeContract() {
        return typeContract;
    }
}
