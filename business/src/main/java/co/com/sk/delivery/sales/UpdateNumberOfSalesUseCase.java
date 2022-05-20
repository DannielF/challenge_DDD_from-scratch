package co.com.sk.delivery.sales;

import co.com.sk.delivery.sales.commands.UpdateNumberOfSales;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * UpdateNumberOfSalesUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class UpdateNumberOfSalesUseCase extends UseCase<RequestCommand<UpdateNumberOfSales>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateNumberOfSales> updateNumberOfSalesRequestCommand) {
        var command = updateNumberOfSalesRequestCommand.getCommand();

        var sales = Sales.from(command.salesId(), repository().getEventsBy(command.salesId().value()));
        sales.updateNumberOfSales(command.salesId(), command.numberOfSales());

        emit().onResponse(new ResponseEvents(sales.getUncommittedChanges()));
    }
}
