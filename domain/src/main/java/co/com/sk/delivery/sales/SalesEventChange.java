package co.com.sk.delivery.sales;

import co.com.sk.delivery.sales.events.ConsultantHired;
import co.com.sk.delivery.sales.events.ManagerHired;
import co.com.sk.delivery.sales.events.NumberOfSalesUpdated;
import co.com.sk.delivery.sales.events.SalesCreated;
import co.com.sk.delivery.sales.events.VendorHired;
import co.com.sk.delivery.sales.values.NumberOfSales;
import co.com.sofka.domain.generic.EventChange;

/**
 * SalesEventChange class - EventChange
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class SalesEventChange extends EventChange {
    public SalesEventChange(Sales sales) {
        apply((SalesCreated event) -> sales.numberOfSales = event.numberOfSales());

        apply((ManagerHired event) -> sales.manager = new Manager(event.managerId(), event.name(), event.salary()));

        apply((VendorHired event) -> sales.vendor = new Vendor(event.vendorId(), event.name(), event.salary()));

        apply((ConsultantHired event) ->
                sales.consultant = new Consultant(event.consultantId(), event.name(), event.salary())
        );

        apply((NumberOfSalesUpdated event) -> sales.numberOfSales = new NumberOfSales(event.numberOfSales().value()));
    }
}
