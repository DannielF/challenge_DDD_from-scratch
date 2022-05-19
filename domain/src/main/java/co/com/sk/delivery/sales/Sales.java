package co.com.sk.delivery.sales;

import co.com.sk.delivery.generic.values.Name;
import co.com.sk.delivery.sales.events.ConsultantHired;
import co.com.sk.delivery.sales.events.ManagerHired;
import co.com.sk.delivery.sales.events.NumberOfSalesUpdated;
import co.com.sk.delivery.sales.events.SalesCreated;
import co.com.sk.delivery.sales.events.VendorHired;
import co.com.sk.delivery.sales.values.ConsultantId;
import co.com.sk.delivery.sales.values.ManagerId;
import co.com.sk.delivery.sales.values.NumberOfSales;
import co.com.sk.delivery.sales.values.Salary;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sk.delivery.sales.values.VendorId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

/**
 * Sales class - Aggregate
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class Sales extends AggregateEvent<SalesId> {
    protected Manager manager;
    protected Vendor vendor;
    protected Consultant consultant;
    protected NumberOfSales numberOfSales;

    public Sales(SalesId salesId, NumberOfSales numberOfSales) {
        super(salesId);
        appendChange(new SalesCreated(numberOfSales)).apply();
        subscribe(new SalesEventChange(this));
    }

    private Sales(SalesId salesId) {
        super(salesId);
        subscribe(new SalesEventChange(this));
    }

    public static Sales from(SalesId salesId, List<DomainEvent> events) {
        var sales = new Sales(salesId);
        events.forEach(sales::applyEvent);
        return sales;
    }

    /**
     * Hire a manager
     *
     * @param name   String
     * @param salary Integer
     */
    public void hireManger(Name name, Salary salary) {
        var managerId = new ManagerId("manager");
        appendChange(new ManagerHired(managerId, name, salary)).apply();
    }

    /**
     * Hire a vendor
     *
     * @param name   String
     * @param salary Integer
     */
    public void hireVendor(Name name, Salary salary) {
        var vendorId = new VendorId("vendor");
        appendChange(new VendorHired(vendorId, name, salary)).apply();
    }

    /**
     * Hire a consultant
     *
     * @param name   String
     * @param salary Integer
     */
    public void hireConsultant(Name name, Salary salary) {
        var consultantId = new ConsultantId("consultant");
        appendChange(new ConsultantHired(consultantId, name, salary)).apply();
    }

    /**
     * Update the number of sales
     *
     * @param salesId       Identity
     * @param numberOfSales Double
     */
    public void updateNumberOfSales(SalesId salesId, NumberOfSales numberOfSales) {
        appendChange(new NumberOfSalesUpdated(salesId, numberOfSales)).apply();
    }

    //Getters
    public Manager manager() {
        return manager;
    }

    public Vendor vendor() {
        return vendor;
    }

    public Consultant consultant() {
        return consultant;
    }

    public NumberOfSales numberOfSales() {
        return numberOfSales;
    }
}
