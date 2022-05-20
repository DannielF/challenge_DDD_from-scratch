package co.com.sk.delivery.account.values;

import co.com.sofka.domain.generic.Identity;

/**
 * ClientId class - Identity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class ClientId extends Identity {
    public ClientId(String id) {
        super(id);
    }

    public ClientId() {
    }

    public static ClientId of(String id) {
        return new ClientId(id);
    }
}
