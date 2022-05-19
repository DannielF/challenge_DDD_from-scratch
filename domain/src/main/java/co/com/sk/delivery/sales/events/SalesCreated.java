package co.com.sk.delivery.sales.events;

import co.com.sk.delivery.sales.values.NumberOfSales;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * SalesCreated class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class SalesCreated extends DomainEvent {
    private final NumberOfSales numberOfSales;

    public SalesCreated(NumberOfSales numberOfSales) {
        super("co.com.sk.delivery.SalesCreated");
        this.numberOfSales = numberOfSales;
    }

    public NumberOfSales numberOfSales() {
        return numberOfSales;
    }
}
