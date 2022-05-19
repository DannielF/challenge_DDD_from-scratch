package co.com.sk.delivery.delivery.events;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.delivery.values.State;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.domain.generic.DomainEvent;

/**
 * DeliveryCreated class - DomainEvent
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class DeliveryCreated extends DomainEvent {
    private final SalesId salesId;
    private final AccountId accountId;
    private final State state;

    public DeliveryCreated(SalesId salesId, AccountId accountId, State state) {
        super("co.com.sk.delivery.DeliveryCreated");
        this.salesId = salesId;
        this.accountId = accountId;
        this.state = state;
    }

    public SalesId salesId() {
        return salesId;
    }

    public AccountId accountId() {
        return accountId;
    }

    public State state() {
        return state;
    }
}
