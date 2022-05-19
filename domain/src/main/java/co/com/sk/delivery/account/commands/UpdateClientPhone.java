package co.com.sk.delivery.account.commands;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.ClientId;
import co.com.sk.delivery.account.values.Phone;
import co.com.sofka.domain.generic.Command;

/**
 * UpdateClientPhone class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class UpdateClientPhone extends Command {
    private final AccountId accountId;
    private final ClientId clientId;
    private final Phone phone;

    public UpdateClientPhone(AccountId accountId, ClientId clientId, Phone phone) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.phone = phone;
    }

    public AccountId accountId() {
        return accountId;
    }

    public ClientId clientId() {
        return clientId;
    }

    public Phone phone() {
        return phone;
    }
}
