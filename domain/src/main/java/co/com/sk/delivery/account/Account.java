package co.com.sk.delivery.account;

import co.com.sk.delivery.account.events.AccountCreated;
import co.com.sk.delivery.account.events.ClientNameUpdated;
import co.com.sk.delivery.account.events.ClientPhoneUpdated;
import co.com.sk.delivery.account.events.OrderAddressUpdated;
import co.com.sk.delivery.account.events.OrderDescriptionUpdated;
import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.Address;
import co.com.sk.delivery.account.values.Description;
import co.com.sk.delivery.account.values.Phone;
import co.com.sk.delivery.account.values.Type;
import co.com.sk.delivery.generic.values.Name;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

/**
 * Account class - Aggregate
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class Account extends AggregateEvent<AccountId> {

    protected Order order;
    protected Receipt receipt;
    protected Client client;
    protected Type type;

    public Account(AccountId accountId, Client client, Order order, Receipt receipt ,Type type) {
        super(accountId);
        appendChange(new AccountCreated(accountId, client, order, receipt, type)).apply();
        subscribe(new AccountEventChange(this));
    }

    private Account(AccountId accountId) {
        super(accountId);
        subscribe(new AccountEventChange(this));
    }

    public static Account from(AccountId accountId, List<DomainEvent> events) {
        var account = new Account(accountId);
        events.forEach(account::applyEvent);
        return account;
    }

    public void updateClientName(Name name) {
        appendChange(new ClientNameUpdated(name)).apply();
    }
    public void updateClientPhone(Phone phone) {
        appendChange(new ClientPhoneUpdated(phone)).apply();
    }
    public void updateOrderDescription(Description description) {
        appendChange(new OrderDescriptionUpdated(description)).apply();
    }
    public void updateOrderAddress(Address address) {
        appendChange(new OrderAddressUpdated(address)).apply();
    }
}
