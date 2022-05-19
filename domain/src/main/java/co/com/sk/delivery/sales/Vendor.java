package co.com.sk.delivery.sales;

import co.com.sk.delivery.generic.values.Name;
import co.com.sk.delivery.sales.values.Salary;
import co.com.sk.delivery.sales.values.VendorId;
import co.com.sofka.domain.generic.Entity;

/**
 * Vendor class - Entity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class Vendor extends Entity<VendorId> {
    protected Name name;
    protected Salary salary;

    public Vendor(VendorId entityId, Name name, Salary salary) {
        super(entityId);
        this.name = name;
        this.salary = salary;
    }

    /**
     * Update vendor's name
     *
     * @param name String
     */
    public void updateName(Name name) {
        this.name = name;
    }

    /**
     * Update vendor's salary
     *
     * @param salary Integer
     */
    public void updateSalary(Salary salary) {
        this.salary = salary;
    }
}
