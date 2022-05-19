package co.com.sk.delivery.account.values;

import co.com.sofka.domain.generic.Identity;

/**
 * OrderId class - Identity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class OrderId extends Identity {
    public OrderId(String id) {
        super(id);
    }

    public static OrderId of(String id) {
        return new OrderId(id);
    }
}
