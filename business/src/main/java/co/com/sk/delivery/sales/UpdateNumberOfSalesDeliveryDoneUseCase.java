package co.com.sk.delivery.sales;

import co.com.sk.delivery.delivery.events.DeliveryDone;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

/**
 * UpdateNumberOfSalesDeliveryDone class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class UpdateNumberOfSalesDeliveryDoneUseCase extends UseCase<TriggeredEvent<DeliveryDone>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<DeliveryDone> deliveryDoneTriggeredEvent) {
        var event = deliveryDoneTriggeredEvent.getDomainEvent();

        var sales = Sales.from(event.salesId(), repository().getEventsBy(event.salesId().value()));
        sales.updateNumberOfSales(event.salesId(), event.numberOfSales());

        emit().onResponse(new ResponseEvents(sales.getUncommittedChanges()));
    }
}
