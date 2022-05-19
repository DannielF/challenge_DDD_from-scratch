package co.com.sk.delivery.account.commands;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.ClientId;
import co.com.sk.delivery.account.values.Phone;
import co.com.sk.delivery.generic.values.Name;
import co.com.sofka.domain.generic.Command;

/**
 * AddClient class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class AddClient extends Command {
    private final AccountId accountId;
    private final ClientId clientId;
    private final Name name;
    private final Phone phone;

    public AddClient(AccountId accountId, ClientId clientId, Name name, Phone phone) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.name = name;
        this.phone = phone;
    }

    public AccountId accountId() {
        return accountId;
    }

    public ClientId clientId() {
        return clientId;
    }

    public Name name() {
        return name;
    }

    public Phone phone() {
        return phone;
    }
}
