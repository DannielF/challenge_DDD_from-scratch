package co.com.sk.delivery.delivery.events;

import co.com.sk.delivery.delivery.values.Load;
import co.com.sk.delivery.delivery.values.TransportId;
import co.com.sk.delivery.delivery.values.Vehicle;
import co.com.sk.delivery.generic.values.Product;
import co.com.sk.delivery.generic.values.Quantity;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * TransportAdded class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class TransportAdded extends DomainEvent {
    private final TransportId transportId;
    private final Vehicle vehicle;
    private final Product product;
    private final Quantity quantity;
    private final Load load;

    public TransportAdded(TransportId transportId, Vehicle vehicle, Product product, Quantity quantity, Load load) {
        super("co.com.sk.delivery.TransportAdded");
        this.transportId = transportId;
        this.vehicle = vehicle;
        this.product = product;
        this.quantity = quantity;
        this.load = load;
    }

    public TransportId transportId() {
        return transportId;
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
