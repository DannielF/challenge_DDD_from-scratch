package co.com.sk.delivery.delivery.values;

import co.com.sofka.domain.generic.Identity;

/**
 * DeliveryId class - Identity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class DeliveryId extends Identity {
    public DeliveryId(String id) {
        super(id);
    }

    public static DeliveryId of(String id) {
        return new DeliveryId(id);
    }
}
