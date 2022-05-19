package co.com.sk.delivery.sales.events;

import co.com.sk.delivery.generic.values.Name;
import co.com.sk.delivery.sales.values.Salary;
import co.com.sk.delivery.sales.values.VendorId;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * VendorHired class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class VendorHired extends DomainEvent {
    private final VendorId vendorId;
    private final Name name;
    private final Salary salary;

    public VendorHired(VendorId vendorId, Name name, Salary salary) {
        super("co.com.sk.delivery.VendorHired");
        this.vendorId = vendorId;
        this.name = name;
        this.salary = salary;
    }

    public VendorId vendorId() {
        return vendorId;
    }

    public Name name() {
        return name;
    }

    public Salary salary() {
        return salary;
    }
}
