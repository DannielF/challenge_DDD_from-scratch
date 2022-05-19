package co.com.sk.delivery.delivery.commands;

import co.com.sk.delivery.delivery.values.DeliveryId;
import co.com.sk.delivery.delivery.values.Load;
import co.com.sk.delivery.delivery.values.Vehicle;
import co.com.sk.delivery.generic.values.Product;
import co.com.sk.delivery.generic.values.Quantity;
import co.com.sofka.domain.generic.Command;

/**
 * AddTransport class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class AddTransport extends Command {
    private final DeliveryId deliveryId;
    private final Vehicle vehicle;
    private final Product product;
    private final Quantity quantity;
    private final Load load;

    public AddTransport(DeliveryId deliveryId, Vehicle vehicle, Product product, Quantity quantity, Load load) {
        this.deliveryId = deliveryId;
        this.vehicle = vehicle;
        this.product = product;
        this.quantity = quantity;
        this.load = load;
    }

    public DeliveryId deliveryId() {
        return deliveryId;
    }

    public Vehicle vehicle() {
        return vehicle;
    }

    public Product product() {
        return product;
    }

    public Quantity quantity() {
        return quantity;
    }

    public Load load() {
        return load;
    }
}
