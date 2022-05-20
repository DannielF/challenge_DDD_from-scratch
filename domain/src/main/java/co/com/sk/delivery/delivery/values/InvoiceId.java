package co.com.sk.delivery.delivery.values;

import co.com.sofka.domain.generic.Identity;

/**
 * InvoiceId class - Identity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class InvoiceId extends Identity {
    public InvoiceId(String id) {
        super(id);
    }

    public InvoiceId() {
    }

    public static InvoiceId of(String id) {
        return new InvoiceId(id);
    }
}
