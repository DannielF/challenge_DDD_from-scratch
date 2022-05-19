package co.com.sk.delivery.account.events;

import co.com.sk.delivery.account.values.Cost;
import co.com.sk.delivery.account.values.ReceiptId;
import co.com.sk.delivery.generic.values.Date;
import co.com.sk.delivery.generic.values.Product;
import co.com.sk.delivery.generic.values.Quantity;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * ReceiptAdded class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class ReceiptAdded extends DomainEvent {
    private final ReceiptId receiptId;
    private final Cost cost;
    private final Product product;
    private final Quantity quantity;
    private final Date date;

    public ReceiptAdded(ReceiptId receiptId, Cost cost, Product product, Quantity quantity, Date date) {
        super("co.com.sk.delivery.ReceiptAdded");
        this.receiptId = receiptId;
        this.cost = cost;
        this.product = product;
        this.quantity = quantity;
        this.date = date;
    }

    public ReceiptId receiptId() {
        return receiptId;
    }

    public Cost cost() {
        return cost;
    }

    public Product product() {
        return product;
    }

    public Quantity quantity() {
        return quantity;
    }

    public Date date() {
        return date;
    }
}
