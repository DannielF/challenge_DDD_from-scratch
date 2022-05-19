package co.com.sk.delivery.sales.events;

import co.com.sk.delivery.generic.values.Name;
import co.com.sk.delivery.sales.values.ManagerId;
import co.com.sk.delivery.sales.values.Salary;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * ManagerHired class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class ManagerHired extends DomainEvent {
    private final ManagerId managerId;
    private final Name name;
    private final Salary salary;

    public ManagerHired(ManagerId managerId, Name name, Salary salary) {
        super("co.com.sk.delivery.ManagerHired");
        this.managerId = managerId;
        this.name = name;
        this.salary = salary;
    }

    public ManagerId managerId() {
        return managerId;
    }

    public Name name() {
        return name;
    }

    public Salary salary() {
        return salary;
    }
}
