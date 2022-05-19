package co.com.sk.delivery.delivery.commands;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.delivery.values.DeliveryId;
import co.com.sk.delivery.delivery.values.State;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.domain.generic.Command;

/**
 * CreateDelivery class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class CreateDelivery extends Command {
    private final DeliveryId deliveryId;
    private final SalesId salesId;
    private final AccountId accountId;
    private final State state;

    public CreateDelivery(DeliveryId deliveryId, SalesId salesId, AccountId accountId, State state) {
        this.deliveryId = deliveryId;
        this.salesId = salesId;
        this.accountId = accountId;
        this.state = state;
    }

    public DeliveryId deliveryId() {
        return deliveryId;
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
