package co.com.sk.delivery.account.commands;

import co.com.sk.delivery.account.Client;
import co.com.sk.delivery.account.Order;
import co.com.sk.delivery.account.Receipt;
import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.Type;
import co.com.sofka.domain.generic.Command;

/**
 * CreateAccount class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class CreateAccount extends Command {

    private final AccountId accountId;
    private final Type type;

    public CreateAccount(AccountId accountId, Type type) {
        this.accountId = accountId;
        this.type = type;
    }

    public AccountId accountId() {
        return accountId;
    }

    public Type type() {
        return type;
    }
}
