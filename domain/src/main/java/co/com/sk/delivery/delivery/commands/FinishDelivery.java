package co.com.sk.delivery.delivery.commands;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.delivery.values.DeliveryId;
import co.com.sk.delivery.delivery.values.State;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.domain.generic.Command;

/**
 * FinishDelivery class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class FinishDelivery extends Command {
    private final DeliveryId deliveryId;
    private final AccountId accountId;
    private final SalesId salesId;
    private final State state;

    public FinishDelivery(DeliveryId deliveryId, AccountId accountId, SalesId salesId, State state) {
        this.deliveryId = deliveryId;
        this.accountId = accountId;
        this.salesId = salesId;
        this.state = state;
    }

    public DeliveryId deliveryId() {
        return deliveryId;
    }

    public AccountId accountId() {
        return accountId;
    }

    public SalesId salesId() {
        return salesId;
    }

    public State state() {
        return state;
    }
}
