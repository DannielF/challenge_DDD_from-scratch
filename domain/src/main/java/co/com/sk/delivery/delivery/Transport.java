package co.com.sk.delivery.delivery;

import co.com.sk.delivery.delivery.values.Load;
import co.com.sk.delivery.delivery.values.TransportId;
import co.com.sk.delivery.delivery.values.Vehicle;
import co.com.sk.delivery.generic.values.Product;
import co.com.sk.delivery.generic.values.Quantity;
import co.com.sofka.domain.generic.Entity;

/**
 * Transport class - Entity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class Transport extends Entity<TransportId> {
    protected Vehicle vehicle;
    protected Product product;
    protected Quantity quantity;
    protected Load load;

    public Transport(TransportId entityId, Vehicle vehicle, Product product, Quantity quantity, Load load) {
        super(entityId);
        this.vehicle = vehicle;
        this.product = product;
        this.quantity = quantity;
        this.load = load;
    }

    /**
     * Change to a new vehicle
     *
     * @param vehicle String
     */
    public void changeVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Change a product
     *
     * @param product String
     */
    public void changeProduct(Product product) {
        this.product = product;
    }

    /**
     * Update the quantity of the product
     *
     * @param quantity Integer
     */
    public void updateQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    /**
     * Update the total weight
     *
     * @param load Double
     */
    public void updateLoad(Load load) {
        this.load = load;
    }
}
