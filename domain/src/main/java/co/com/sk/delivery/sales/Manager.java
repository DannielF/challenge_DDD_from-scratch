package co.com.sk.delivery.sales;

import co.com.sk.delivery.generic.values.Name;
import co.com.sk.delivery.sales.values.ManagerId;
import co.com.sk.delivery.sales.values.Salary;
import co.com.sofka.domain.generic.Entity;

/**
 * Manager class - Entity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class Manager extends Entity<ManagerId> {
    protected Name name;
    protected Salary salary;

    public Manager(ManagerId entityId, Name name, Salary salary) {
        super(entityId);
        this.name = name;
        this.salary = salary;
    }

    /**
     * Update manager's name
     *
     * @param name String
     */
    public void UpdatedName(Name name) {
        this.name = name;
    }

    /**
     * Update manager's salary
     *
     * @param salary Integer
     */
    public void UpdatedSalary(Salary salary) {
        this.salary = salary;
    }
}
