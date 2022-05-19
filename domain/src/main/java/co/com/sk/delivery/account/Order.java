package co.com.sk.delivery.account;

import co.com.sk.delivery.account.values.Address;
import co.com.sk.delivery.account.values.Description;
import co.com.sk.delivery.account.values.OrderId;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;

/**
 * Order class - Entity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class Order extends Entity<OrderId> {

    protected Description description;
    protected Address address;

    public Order(OrderId entityId, Description description, Address address) {
        super(entityId);
        this.description = description;
        this.address = address;
    }

    /**
     * Update an order description
     *
     * @param description String
     */
    public void updateDescription(Description description) {
        this.description = description;
    }

    /**
     * Update an order address
     *
     * @param address String
     */
    public void updateAddress(Address address) {
        this.address = address;
    }
}
