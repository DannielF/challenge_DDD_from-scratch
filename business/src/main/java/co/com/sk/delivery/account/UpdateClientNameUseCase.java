package co.com.sk.delivery.account;

import co.com.sk.delivery.account.commands.UpdateClientName;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * UpdateClientNameUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class UpdateClientNameUseCase extends UseCase<RequestCommand<UpdateClientName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClientName> updateClientNameRequestCommand) {
        var command = updateClientNameRequestCommand.getCommand();

        var account = Account.from(
                command.accountId(), repository().getEventsBy(command.accountId().value())
        );
        account.updateClientName(command.clientId(), command.name());

        emit().onResponse(new ResponseEvents(account.getUncommittedChanges()));
    }
}
