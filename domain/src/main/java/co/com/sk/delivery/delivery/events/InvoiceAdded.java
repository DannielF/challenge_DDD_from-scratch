package co.com.sk.delivery.delivery.events;

import co.com.sk.delivery.delivery.values.Constraints;
import co.com.sk.delivery.delivery.values.InvoiceId;
import co.com.sk.delivery.generic.values.Date;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * InvoiceAdded class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class InvoiceAdded extends DomainEvent {
    private final InvoiceId invoiceId;
    private final Constraints constraints;
    private final Date date;

    public InvoiceAdded(InvoiceId invoiceId, Constraints constraints, Date date) {
        super("co.com.sk.delivery.InvoiceAdded");
        this.invoiceId = invoiceId;
        this.constraints = constraints;
        this.date = date;
    }

    public InvoiceId invoiceId() {
        return invoiceId;
    }

    public Constraints constraints() {
        return constraints;
    }

    public Date date() {
        return date;
    }
}
