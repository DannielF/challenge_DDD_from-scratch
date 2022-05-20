package co.com.sk.delivery.sales;

import co.com.sk.delivery.sales.commands.CreateSales;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * CreateSalesUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class CreateSalesUseCase extends UseCase<RequestCommand<CreateSales>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateSales> createSalesRequestCommand) {
        var command = createSalesRequestCommand.getCommand();

        var sales = new Sales(command.salesId(), command.numberOfSales());

        emit().onResponse(new ResponseEvents(sales.getUncommittedChanges()));

    }
}
