package co.com.sk.delivery.sales.commands;

import co.com.sk.delivery.sales.values.NumberOfSales;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.domain.generic.Command;

/**
 * UpdateNumberOfSales class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class UpdateNumberOfSales extends Command {
    private final SalesId salesId;
    private final NumberOfSales numberOfSales;

    public UpdateNumberOfSales(SalesId salesId, NumberOfSales numberOfSales) {
        this.salesId = salesId;
        this.numberOfSales = numberOfSales;
    }

    public SalesId salesId() {
        return salesId;
    }

    public NumberOfSales numberOfSales() {
        return numberOfSales;
    }
}
