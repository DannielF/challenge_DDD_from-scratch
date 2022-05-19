package co.com.sk.delivery.account.events;

import co.com.sk.delivery.account.Client;
import co.com.sk.delivery.account.Order;
import co.com.sk.delivery.account.Receipt;
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
    private final Client client;
    private final Order order;
    private final Receipt receipt;
    private final Type typeAccount;

    public AccountCreated(AccountId accountId, Client client, Order order, Receipt receipt, Type typeAccount) {
        super("co.com.sk.delivery.AccountCreated");
        this.accountId = accountId;
        this.client = client;
        this.order = order;
        this.receipt = receipt;
        this.typeAccount = typeAccount;
    }

    public Client client() {
        return client;
    }

    public Order order() {
        return order;
    }

    public Receipt receipt() {
        return receipt;
    }

    public AccountId accountId() {
        return accountId;
    }

    public Type typeAccount() {
        return typeAccount;
    }
}
