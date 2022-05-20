package co.com.sk.delivery.account;

import co.com.sk.delivery.account.commands.CreateAccount;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * CreateAccountUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class CreateAccountUseCase extends UseCase<RequestCommand<CreateAccount>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateAccount> createAccountRequestCommand) {
        var command = createAccountRequestCommand.getCommand();

        var account = new Account(command.accountId(), command.type());

        emit().onResponse(new ResponseEvents(account.getUncommittedChanges()));
    }
}
