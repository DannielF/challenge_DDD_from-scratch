package co.com.sk.delivery.account;

import co.com.sk.delivery.account.events.AccountCreated;
import co.com.sk.delivery.account.events.ClientAdded;
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

        apply((ClientAdded event) -> {
            var clientId = event.clientId();
            account.client = new Client(clientId, event.name(), event.phone());
        });
    }
}
