package co.com.sk.delivery.sales.values;

import co.com.sofka.domain.generic.Identity;

/**
 * VendorId class - Identity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class VendorId extends Identity {
    public VendorId(String id) {
        super(id);
    }

    public static VendorId of(String id) {
        return new VendorId(id);
    }
}
