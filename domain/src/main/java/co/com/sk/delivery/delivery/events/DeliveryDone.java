package co.com.sk.delivery.delivery.events;

import co.com.sk.delivery.delivery.values.State;
import co.com.sk.delivery.sales.values.NumberOfSales;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * DeliveryDone class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class DeliveryDone extends DomainEvent {
    private final State state;
    private final NumberOfSales numberOfSales;
    private final SalesId salesId;

    public DeliveryDone(State state, NumberOfSales numberOfSales, SalesId salesId) {
        super("co.com.sk.delivery.DeliveryDone");
        this.state = state;
        this.numberOfSales = numberOfSales;
        this.salesId = salesId;
    }

    public NumberOfSales numberOfSales() {
        return numberOfSales;
    }

    public SalesId salesId() {
        return salesId;
    }

    public State state() {
        return state;
    }
}
