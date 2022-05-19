package co.com.sk.delivery.account.commands;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.Address;
import co.com.sk.delivery.account.values.OrderId;
import co.com.sofka.domain.generic.Command;

/**
 * UpdateOrderAddress class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class UpdateOrderAddress extends Command {
    private final AccountId accountId;
    private final OrderId orderId;
    private final Address address;

    public UpdateOrderAddress(AccountId accountId, OrderId orderId, Address address) {
        this.accountId = accountId;
        this.orderId = orderId;
        this.address = address;
    }

    public AccountId accountId() {
        return accountId;
    }

    public OrderId orderId() {
        return orderId;
    }

    public Address address() {
        return address;
    }
}
