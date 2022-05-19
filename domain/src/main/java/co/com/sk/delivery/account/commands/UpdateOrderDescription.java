package co.com.sk.delivery.account.commands;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.Description;
import co.com.sk.delivery.account.values.OrderId;
import co.com.sofka.domain.generic.Command;

/**
 * UpdateOrderDescription class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class UpdateOrderDescription extends Command {
    private final AccountId accountId;
    private final OrderId orderId;
    private final Description description;

    public UpdateOrderDescription(AccountId accountId, OrderId orderId, Description description) {
        this.accountId = accountId;
        this.orderId = orderId;
        this.description = description;
    }

    public AccountId accountId() {
        return accountId;
    }

    public OrderId orderId() {
        return orderId;
    }

    public Description description() {
        return description;
    }
}
