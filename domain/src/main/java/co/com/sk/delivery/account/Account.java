package co.com.sk.delivery.account;

import co.com.sk.delivery.account.events.AccountCreated;
import co.com.sk.delivery.account.events.ClientAdded;
import co.com.sk.delivery.account.events.ClientNameUpdated;
import co.com.sk.delivery.account.events.ClientPhoneUpdated;
import co.com.sk.delivery.account.events.OrderAdded;
import co.com.sk.delivery.account.events.OrderAddressUpdated;
import co.com.sk.delivery.account.events.OrderDescriptionUpdated;
import co.com.sk.delivery.account.events.ReceiptAdded;
import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.Address;
import co.com.sk.delivery.account.values.ClientId;
import co.com.sk.delivery.account.values.Cost;
import co.com.sk.delivery.account.values.Description;
import co.com.sk.delivery.account.values.OrderId;
import co.com.sk.delivery.account.values.Phone;
import co.com.sk.delivery.account.values.ReceiptId;
import co.com.sk.delivery.account.values.Type;
import co.com.sk.delivery.generic.values.Date;
import co.com.sk.delivery.generic.values.Name;
import co.com.sk.delivery.generic.values.Product;
import co.com.sk.delivery.generic.values.Quantity;
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
        appendChange(new AccountCreated(type)).apply();
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

    /**
     * Add a client
     *
     * @param name  String
     * @param phone String
     */
    public void addClient(Name name, Phone phone) {
        var clientId = new ClientId();
        appendChange(new ClientAdded(clientId, name, phone)).apply();
    }

    /**
     * Add an order
     *
     * @param description String
     * @param address     String
     */
    public void addOrder(Description description, Address address) {
        var orderId = new OrderId();
        appendChange(new OrderAdded(orderId, description, address)).apply();
    }

    /**
     * Add a receipt
     *
     * @param cost     Integer
     * @param product  String
     * @param date     Instant
     * @param quantity Integer
     */
    public void addReceipt(Cost cost, Product product, Date date, Quantity quantity) {
        var receiptId = new ReceiptId();
        appendChange(new ReceiptAdded(receiptId, cost, product, date, quantity)).apply();
    }

    /**
     * Update client's name
     *
     * @param clientId Identity
     * @param name     String
     */
    public void updateClientName(ClientId clientId, Name name) {
        appendChange(new ClientNameUpdated(clientId, name)).apply();
    }

    /**
     * Update client's phone
     *
     * @param clientId Identity
     * @param phone    String
     */
    public void updateClientPhone(ClientId clientId, Phone phone) {
        appendChange(new ClientPhoneUpdated(clientId, phone)).apply();
    }

    /**
     * Update order's description
     *
     * @param orderId     Identity
     * @param description String
     */
    public void updateOrderDescription(OrderId orderId, Description description) {
        appendChange(new OrderDescriptionUpdated(orderId, description)).apply();
    }

    /**
     * Update order's address
     *
     * @param orderId Identity
     * @param address String
     */
    public void updateOrderAddress(OrderId orderId, Address address) {
        appendChange(new OrderAddressUpdated(orderId, address)).apply();
    }

    //Getters
    public Order order() {
        return order;
    }

    public Receipt receipt() {
        return receipt;
    }

    public Client client() {
        return client;
    }

    public Type type() {
        return type;
    }
}
