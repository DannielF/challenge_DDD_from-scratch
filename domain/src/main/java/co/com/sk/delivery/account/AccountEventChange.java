package co.com.sk.delivery.account;

import co.com.sk.delivery.account.events.AccountCreated;
import co.com.sk.delivery.account.events.ClientNameUpdated;
import co.com.sk.delivery.account.events.ClientPhoneUpdated;
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
        apply((AccountCreated event) -> {
            account.client = event.client();
            account.order = event.order();
            account.receipt = event.receipt();
            account.type = event.typeAccount();
        });

        apply((ClientNameUpdated event) -> account.client.updateName(event.name()));

        apply((ClientPhoneUpdated event) -> account.client.updatePhone(event.phone()));
    }
}
