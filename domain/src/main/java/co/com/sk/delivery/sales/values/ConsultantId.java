package co.com.sk.delivery.sales.values;

import co.com.sofka.domain.generic.Identity;

/**
 * ConsultantId class - Identity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class ConsultantId extends Identity {
    public ConsultantId(String id) {
        super(id);
    }

    public static ConsultantId of(String id) {
        return new ConsultantId(id);
    }
}
