package co.com.sk.delivery.sales.events;

import co.com.sk.delivery.sales.values.NumberOfSales;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * NumberOfSalesUpdated class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class NumberOfSalesUpdated extends DomainEvent {
    private final SalesId salesId;
    private final NumberOfSales numberOfSales;

    public NumberOfSalesUpdated(SalesId salesId, NumberOfSales numberOfSales) {
        super("co.com.sk.delivery.NumberOfSalesUpdated");
        this.salesId = salesId;
        this.numberOfSales = numberOfSales;
    }

    public SalesId salesId() {
        return salesId;
    }

    public NumberOfSales numberOfSales() {
        return numberOfSales;
    }
}
