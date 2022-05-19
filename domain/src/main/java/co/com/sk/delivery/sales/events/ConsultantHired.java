package co.com.sk.delivery.sales.events;

import co.com.sk.delivery.generic.values.Name;
import co.com.sk.delivery.sales.values.ConsultantId;
import co.com.sk.delivery.sales.values.Salary;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * ConsultantHired class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class ConsultantHired extends DomainEvent {
    private final ConsultantId consultantId;
    private final Name name;
    private final Salary salary;

    public ConsultantHired(ConsultantId consultantId, Name name, Salary salary) {
        super("co.com.sk.delivery.ConsultantHired");
        this.consultantId = consultantId;
        this.name = name;
        this.salary = salary;
    }

    public ConsultantId consultantId() {
        return consultantId;
    }

    public Name name() {
        return name;
    }

    public Salary salary() {
        return salary;
    }
}
