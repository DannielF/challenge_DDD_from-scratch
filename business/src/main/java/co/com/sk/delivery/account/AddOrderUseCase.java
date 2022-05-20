package co.com.sk.delivery.account;

import co.com.sk.delivery.account.commands.AddOrder;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * AddOrderUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class AddOrderUseCase extends UseCase<RequestCommand<AddOrder>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddOrder> addOrderRequestCommand) {
        var command = addOrderRequestCommand.getCommand();

        var account = Account.from(
                command.accountId(), repository().getEventsBy(command.accountId().value())
        );
        account.addOrder(command.description(), command.address());

        emit().onResponse(new ResponseEvents(account.getUncommittedChanges()));
    }
}
