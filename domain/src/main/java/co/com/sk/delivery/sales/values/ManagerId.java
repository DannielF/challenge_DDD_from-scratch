package co.com.sk.delivery.sales.values;

import co.com.sofka.domain.generic.Identity;

/**
 * ManagerId class - Identity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class ManagerId extends Identity {
    public ManagerId(String id) {
        super(id);
    }

    public static ManagerId of(String id) {
        return new ManagerId(id);
    }
}
