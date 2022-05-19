package co.com.sk.delivery.account;

import co.com.sk.delivery.account.values.Cost;
import co.com.sk.delivery.account.values.ReceiptId;
import co.com.sk.delivery.generic.values.Date;
import co.com.sk.delivery.generic.values.Product;
import co.com.sk.delivery.generic.values.Quantity;
import co.com.sofka.domain.generic.Entity;
import org.apache.commons.lang3.Validate;

import java.time.DateTimeException;
import java.time.Instant;

/**
 * Receipt class - Entity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class Receipt extends Entity<ReceiptId> {

    private static final String VALIDATION_MESSAGE = "There's must be a value";
    private static final String VALIDATION_MESSAGE_UPDATE = "Cannot be empty";
    protected Cost cost;
    protected Product product;
    protected Quantity quantity;
    protected Date date;

    public Receipt(ReceiptId entityId, Cost cost, Product product, Quantity quantity, Date date) {
        super(entityId);
        this.cost = Validate.notNull(cost, VALIDATION_MESSAGE);
        this.product = Validate.notNull(product, VALIDATION_MESSAGE);
        this.quantity = Validate.notNull(quantity, VALIDATION_MESSAGE);
        this.date = Validate.notNull(date, VALIDATION_MESSAGE);
    }

    /**
     * update a cost in the receipt
     *
     * @param cost Integer
     */
    public void updateCost(Cost cost) {
        if (cost.value() == null) {
            throw new IllegalArgumentException(VALIDATION_MESSAGE_UPDATE);
        }
        this.cost = cost;
    }

    /**
     * update a product in the receipt
     *
     * @param product String
     */
    public void updateProduct(Product product) {
        if (product.value().isBlank()) {
            throw new IllegalArgumentException(VALIDATION_MESSAGE_UPDATE);
        }
        this.product = product;
    }

    /**
     * update a quantity in the receipt
     *
     * @param quantity Integer
     */
    public void updateQuantity(Quantity quantity) {
        if (quantity.value() == null) {
            throw new IllegalArgumentException(VALIDATION_MESSAGE_UPDATE);
        }
        this.quantity = quantity;
    }

    /**
     * update a date in the receipt
     *
     * @param date Instant
     */
    public void updateDate(Date date) {
        if (date.value().isAfter(Instant.now())) {
            throw new DateTimeException("Wrong date, is after current day");
        }
        this.date = date;
    }
}
