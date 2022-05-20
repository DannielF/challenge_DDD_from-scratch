package co.com.sk.delivery.account;

import co.com.sk.delivery.account.commands.UpdateOrderAddress;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * UpdateOrderAddressUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class UpdateOrderAddressUseCase extends UseCase<RequestCommand<UpdateOrderAddress>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateOrderAddress> updateOrderAddressRequestCommand) {
        var command = updateOrderAddressRequestCommand.getCommand();

        var account = Account.from(
                command.accountId(), repository().getEventsBy(command.accountId().value())
        );
        account.updateOrderAddress(command.orderId(), command.address());

        emit().onResponse(new ResponseEvents(account.getUncommittedChanges()));
    }
}
