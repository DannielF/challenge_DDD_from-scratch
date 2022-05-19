package co.com.sk.delivery.sales.values;

import co.com.sofka.domain.generic.Identity;

/**
 * SalesId class - Identity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class SalesId extends Identity {
    public SalesId(String id) {
        super(id);
    }

    public static SalesId of(String id) {
        return new SalesId(id);
    }
}
