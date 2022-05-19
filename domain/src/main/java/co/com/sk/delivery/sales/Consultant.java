package co.com.sk.delivery.sales;

import co.com.sk.delivery.generic.values.Name;
import co.com.sk.delivery.sales.values.ConsultantId;
import co.com.sk.delivery.sales.values.Salary;
import co.com.sofka.domain.generic.Entity;

/**
 * Consultant class - Entity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class Consultant extends Entity<ConsultantId> {
    protected Name name;
    protected Salary salary;

    public Consultant(ConsultantId entityId, Name name, Salary salary) {
        super(entityId);
        this.name = name;
        this.salary = salary;
    }

    /**
     * Update consultant's name
     *
     * @param name String
     */
    public void updateName(Name name) {
        this.name = name;
    }

    /**
     * Update consultant's salary
     *
     * @param salary Integer
     */
    public void updateSalary(Salary salary) {
        this.salary = salary;
    }
}
