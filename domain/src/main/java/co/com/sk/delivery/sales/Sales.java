package co.com.sk.delivery.sales;

import co.com.sk.delivery.sales.events.SalesCreated;
import co.com.sk.delivery.sales.values.NumberOfSales;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Sales extends AggregateEvent<SalesId> {
    protected NumberOfSales numberOfSales;

    public Sales(SalesId salesId, NumberOfSales numberOfSales) {
        super(salesId);
        appendChange(new SalesCreated(numberOfSales)).apply();
        subscribe(new SalesEventChange(this));
    }
}
