package co.com.sk.delivery.sales;

import co.com.sk.delivery.sales.commands.HireConsultant;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * HireConsultantUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class HireConsultantUseCase extends UseCase<RequestCommand<HireConsultant>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<HireConsultant> hireConsultantRequestCommand) {
        var command = hireConsultantRequestCommand.getCommand();

        var sales = Sales.from(command.salesId(), repository().getEventsBy(command.salesId().value()));
        sales.hireConsultant(command.name(), command.salary());

        emit().onResponse(new ResponseEvents(sales.getUncommittedChanges()));
    }
}
