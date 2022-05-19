package co.com.sk.delivery.delivery.commands;

import co.com.sk.delivery.delivery.values.Constraints;
import co.com.sk.delivery.delivery.values.DeliveryId;
import co.com.sk.delivery.generic.values.Date;
import co.com.sofka.domain.generic.Command;

/**
 * AddInvoice class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class AddInvoice extends Command {
    private final DeliveryId deliveryId;
    private final Constraints constraints;
    private final Date date;

    public AddInvoice(DeliveryId deliveryId, Constraints constraints, Date date) {
        this.deliveryId = deliveryId;
        this.constraints = constraints;
        this.date = date;
    }

    public DeliveryId deliveryId() {
        return deliveryId;
    }

    public Constraints constraints() {
        return constraints;
    }

    public Date date() {
        return date;
    }
}
