package co.com.sk.delivery.account.commands;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.Cost;
import co.com.sk.delivery.delivery.values.Load;
import co.com.sk.delivery.generic.values.Product;
import co.com.sk.delivery.generic.values.Quantity;
import co.com.sofka.domain.generic.Command;

/**
 * AddReceipt class - Command
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class AddReceipt extends Command {
    private final AccountId accountId;
    private final Cost cost;
    private final Product product;
    private final Quantity quantity;
    private final Load load;

    public AddReceipt
            (AccountId accountId, Cost cost, Product product, Quantity quantity, Load load) {
        this.accountId = accountId;
        this.cost = cost;
        this.product = product;
        this.quantity = quantity;
        this.load = load;
    }

    public AccountId accountId() {
        return accountId;
    }

    public Cost cost() {
        return cost;
    }

    public Product product() {
        return product;
    }

    public Quantity quantity() {
        return quantity;
    }

    public Load load() {
        return load;
    }
}
