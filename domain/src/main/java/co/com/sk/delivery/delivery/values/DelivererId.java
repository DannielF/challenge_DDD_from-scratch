package co.com.sk.delivery.delivery.values;

import co.com.sofka.domain.generic.Identity;

/**
 * DelivererId class - Identity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class DelivererId extends Identity {
    public DelivererId(String id) {
        super(id);
    }

    public DelivererId() {
    }

    public static DelivererId of(String id) {
        return new DelivererId(id);
    }
}
