package co.com.sk.delivery.account;

import co.com.sk.delivery.account.events.AccountCreated;
import co.com.sk.delivery.account.events.ClientAdded;
import co.com.sk.delivery.account.events.OrderAdded;
import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.Address;
import co.com.sk.delivery.account.values.ClientId;
import co.com.sk.delivery.account.values.Description;
import co.com.sk.delivery.account.values.OrderId;
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

    public Account(AccountId accountId, Type type) {
        super(accountId);
        appendChange(new AccountCreated(accountId, type)).apply();
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

    public void addClient(Name name, Phone phone) {
        var clientId = new ClientId("client");
        appendChange(new ClientAdded(clientId, name, phone)).apply();
    }

    public void addOrder(Description description, Address address) {
        var orderId = new OrderId("order");
        appendChange(new OrderAdded(orderId, description, address)).apply();
    }
}
