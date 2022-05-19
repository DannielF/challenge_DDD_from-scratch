package co.com.sk.delivery.sales;

import co.com.sk.delivery.sales.events.SalesCreated;
import co.com.sofka.domain.generic.EventChange;
/**
 * SalesEventChange class - EventChange
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class SalesEventChange extends EventChange {
    public SalesEventChange(Sales sales) {
        apply((SalesCreated event) -> sales.numberOfSales = event.numberOfSales());
    }
}
