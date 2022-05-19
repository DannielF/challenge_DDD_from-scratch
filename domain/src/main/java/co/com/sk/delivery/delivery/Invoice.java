package co.com.sk.delivery.delivery;

import co.com.sk.delivery.delivery.values.Constraints;
import co.com.sk.delivery.delivery.values.InvoiceId;
import co.com.sk.delivery.generic.values.Date;
import co.com.sofka.domain.generic.Entity;

/**
 * Invoice class - Entity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class Invoice extends Entity<InvoiceId> {
    protected Constraints constraints;
    protected Date date;

    public Invoice(InvoiceId entityId, Constraints constraints, Date date) {
        super(entityId);
        this.constraints = constraints;
        this.date = date;
    }

    /**
     * Updates the constraints
     *
     * @param constraints String
     */
    public void updateConstraints(Constraints constraints) {
        this.constraints = constraints;
    }

    /**
     * Changes the date
     *
     * @param date Instant
     */
    public void changeDate(Date date) {
        this.date = date;
    }
}
