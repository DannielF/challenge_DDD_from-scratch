package co.com.sk.delivery.account;

import co.com.sk.delivery.account.commands.AddClient;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * AddClientUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class AddClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();

        var account = Account.from(
                command.accountId(), repository().getEventsBy(command.accountId().value())
        );
        account.addClient(command.name(), command.phone());

        emit().onResponse(new ResponseEvents(account.getUncommittedChanges()));
    }
}
