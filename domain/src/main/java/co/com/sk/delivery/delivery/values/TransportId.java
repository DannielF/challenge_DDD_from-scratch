package co.com.sk.delivery.delivery.values;

import co.com.sofka.domain.generic.Identity;

/**
 * TransportId class - Identity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class TransportId extends Identity {
    public TransportId(String id) {
        super(id);
    }

    public static TransportId of(String id) {
        return new TransportId(id);
    }
}
