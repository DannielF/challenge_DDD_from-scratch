package co.com.sk.delivery.account;

import co.com.sk.delivery.account.events.AccountCreated;
import co.com.sk.delivery.account.events.ClientAdded;
import co.com.sk.delivery.account.events.ClientNameUpdated;
import co.com.sk.delivery.account.events.ClientPhoneUpdated;
import co.com.sk.delivery.account.events.OrderAdded;
import co.com.sk.delivery.account.events.OrderAddressUpdated;
import co.com.sk.delivery.account.events.OrderDescriptionUpdated;
import co.com.sk.delivery.account.events.ReceiptAdded;
import co.com.sofka.domain.generic.EventChange;

/**
 * AccountEventChange class - EventChange
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class AccountEventChange extends EventChange {
    public AccountEventChange(Account account) {
        apply((AccountCreated event) -> account.type = event.typeAccount());

        apply((ClientAdded event) -> account.client = new Client(event.clientId(), event.name(), event.phone()));

        apply((OrderAdded event) -> account.order = new Order(event.orderId(), event.description(), event.address()));

        apply((ReceiptAdded event) ->
                account.receipt = new Receipt(event.receiptId(),
                        event.cost(), event.product(),
                        event.quantity(), event.date())
        );

        apply((ClientNameUpdated event) -> account.client.updateName(event.name()));

        apply((ClientPhoneUpdated event) -> account.client.updatePhone(event.phone()));

        apply((OrderDescriptionUpdated event) -> account.order.updateDescription(event.description()));

        apply((OrderAddressUpdated event) -> account.order.updateAddress(event.address()));
    }
}
