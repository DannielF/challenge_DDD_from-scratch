package co.com.sk.delivery.sales.commands;

import co.com.sk.delivery.generic.values.Name;
import co.com.sk.delivery.sales.values.Salary;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.domain.generic.Command;

/**
 * HireVendor class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class HireVendor extends Command {
    private final SalesId salesId;
    private final Name name;
    private final Salary salary;

    public HireVendor(SalesId salesId, Name name, Salary salary) {
        this.salesId = salesId;
        this.name = name;
        this.salary = salary;
    }

    public SalesId salesId() {
        return salesId;
    }

    public Name name() {
        return name;
    }

    public Salary salary() {
        return salary;
    }
}
