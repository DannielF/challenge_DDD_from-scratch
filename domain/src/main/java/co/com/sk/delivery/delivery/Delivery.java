package co.com.sk.delivery.delivery;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.delivery.events.DelivererAdded;
import co.com.sk.delivery.delivery.events.DeliveryCreated;
import co.com.sk.delivery.delivery.events.DeliveryDone;
import co.com.sk.delivery.delivery.events.InvoiceAdded;
import co.com.sk.delivery.delivery.events.StateUpdated;
import co.com.sk.delivery.delivery.events.TransportAdded;
import co.com.sk.delivery.delivery.events.TypeContractDelivererUpdated;
import co.com.sk.delivery.delivery.values.Constraints;
import co.com.sk.delivery.delivery.values.DelivererId;
import co.com.sk.delivery.delivery.values.DeliveryId;
import co.com.sk.delivery.delivery.values.InvoiceId;
import co.com.sk.delivery.delivery.values.Load;
import co.com.sk.delivery.delivery.values.State;
import co.com.sk.delivery.delivery.values.TransportId;
import co.com.sk.delivery.delivery.values.TypeContract;
import co.com.sk.delivery.delivery.values.Vehicle;
import co.com.sk.delivery.generic.values.Date;
import co.com.sk.delivery.generic.values.Name;
import co.com.sk.delivery.generic.values.Product;
import co.com.sk.delivery.generic.values.Quantity;
import co.com.sk.delivery.sales.values.NumberOfSales;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

/**
 * Delivery class - Aggregate
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class Delivery extends AggregateEvent<DeliveryId> {
    protected SalesId salesId;
    protected AccountId accountId;
    protected State state;
    protected Map<TransportId, Transport> transports;
    protected Map<DelivererId, Deliverer> deliverers;
    protected Map<InvoiceId, Invoice> invoices;

    public Delivery(DeliveryId deliveryId, SalesId salesId, AccountId accountId, State state) {
        super(deliveryId);
        appendChange(new DeliveryCreated(salesId, accountId, state)).apply();
        subscribe(new DeliveryEventChange(this));
    }

    private Delivery(DeliveryId deliveryId) {
        super(deliveryId);
        subscribe(new DeliveryEventChange(this));
    }

    public static Delivery from(DeliveryId deliveryId, List<DomainEvent> events) {
        var delivery = new Delivery(deliveryId);
        events.forEach(delivery::applyEvent);
        return delivery;
    }

    /**
     * Update the state
     *
     * @param state Enum
     */
    public void updateState(State state) {
        appendChange(new StateUpdated(state)).apply();
    }

    /**
     * Add a transport
     *
     * @param vehicle  String
     * @param product  String
     * @param quantity Integer
     * @param load     Double
     */
    public void addTransport(Vehicle vehicle, Product product, Quantity quantity, Load load) {
        var transportId = new TransportId();
        appendChange(new TransportAdded(transportId, vehicle, product, quantity, load)).apply();
    }

    /**
     * Add a deliverer
     *
     * @param name         String
     * @param typeContract String
     */
    public void addDeliverer(Name name, TypeContract typeContract) {
        var delivererId = new DelivererId();
        appendChange(new DelivererAdded(delivererId, name, typeContract)).apply();
    }

    /**
     * Add an invoices
     *
     * @param constraints String
     * @param date        Instant
     */
    public void addInvoice(Constraints constraints, Date date) {
        var invoiceId = new InvoiceId();
        appendChange(new InvoiceAdded(invoiceId, constraints, date)).apply();
    }

    public void updateTypeContractDeliverer(DelivererId delivererId, TypeContract typeContract) {
        appendChange(new TypeContractDelivererUpdated(delivererId, typeContract)).apply();
    }

    public void finishDelivery(State state, NumberOfSales numberOfSales) {
        appendChange(new DeliveryDone(state, numberOfSales, salesId)).apply();
    }
}
