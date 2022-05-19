package co.com.sk.delivery.delivery;

import co.com.sk.delivery.delivery.events.DelivererAdded;
import co.com.sk.delivery.delivery.events.DeliveryCreated;
import co.com.sk.delivery.delivery.events.InvoiceAdded;
import co.com.sk.delivery.delivery.events.StateUpdated;
import co.com.sk.delivery.delivery.events.TransportAdded;
import co.com.sk.delivery.delivery.values.State;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashMap;

/**
 * DeliveryEventChange class - EventChange
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class DeliveryEventChange extends EventChange {
    public DeliveryEventChange(Delivery delivery) {
        apply((DeliveryCreated event) -> {
            delivery.accountId = event.accountId();
            delivery.salesId = event.salesId();
            delivery.state = new State(State.states.IN_PROGRESS);
            delivery.transports = new HashMap<>();
            delivery.deliverers = new HashMap<>();
            delivery.invoices = new HashMap<>();
        });

        apply((StateUpdated event) -> delivery.state = new State(event.state().value()));

        apply((TransportAdded event) -> {
            var transportId = event.transportId();
            var transport = new Transport(transportId, event.vehicle(), event.product(), event.quantity(), event.load());
            delivery.transports.put(transportId, transport);
        });

        apply((DelivererAdded event) -> {
            var delivererId = event.delivererId();
            var deliverer = new Deliverer(delivererId, event.name(), event.typeContract());
            delivery.deliverers.put(delivererId, deliverer);
        });

        apply((InvoiceAdded event) -> {
            var invoiceId = event.invoiceId();
            var invoice = new Invoice(invoiceId, event.constraints(), event.date());
            delivery.invoices.put(invoiceId, invoice);
        });
    }
}
