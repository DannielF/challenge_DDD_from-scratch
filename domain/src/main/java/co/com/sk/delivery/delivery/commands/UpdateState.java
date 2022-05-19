package co.com.sk.delivery.delivery.commands;

import co.com.sk.delivery.delivery.values.DeliveryId;
import co.com.sk.delivery.delivery.values.State;
import co.com.sofka.domain.generic.Command;

/**
 * UpdateState class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class UpdateState extends Command {
    private final DeliveryId deliveryId;
    private final State state;

    public UpdateState(DeliveryId deliveryId, State state) {
        this.deliveryId = deliveryId;
        this.state = state;
    }

    public DeliveryId deliveryId() {
        return deliveryId;
    }

    public State state() {
        return state;
    }
}
