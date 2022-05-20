package co.com.sk.delivery.account.values;

import co.com.sofka.domain.generic.Identity;

/**
 * ReceiptId class - Identity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class ReceiptId extends Identity {
    public ReceiptId(String id) {
        super(id);
    }

    public ReceiptId() {
    }

    public static ReceiptId of(String id) {
        return new ReceiptId(id);
    }
}
