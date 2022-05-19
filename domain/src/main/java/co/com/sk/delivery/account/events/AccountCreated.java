package co.com.sk.delivery.account.events;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.Type;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * AccountCreated class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class AccountCreated extends DomainEvent {
    private final AccountId accountId;
    private final Type typeAccount;

    public AccountCreated(AccountId accountId, Type typeAccount) {
        super("co.com.sk.delivery.AccountCreated");
        this.accountId = accountId;
        this.typeAccount = typeAccount;
    }

    public AccountId accountId() {
        return accountId;
    }

    public Type typeAccount() {
        return typeAccount;
    }
}
