package co.com.sk.delivery.sales;

import co.com.sk.delivery.sales.commands.HireVendor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * HireVendorUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class HireVendorUseCase extends UseCase<RequestCommand<HireVendor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<HireVendor> hireVendorRequestCommand) {
        var command = hireVendorRequestCommand.getCommand();

        var sales = Sales.from(command.salesId(), repository().getEventsBy(command.salesId().value()));
        sales.hireVendor(command.name(), command.salary());

        emit().onResponse(new ResponseEvents(sales.getUncommittedChanges()));
    }
}
