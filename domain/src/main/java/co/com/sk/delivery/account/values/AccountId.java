package co.com.sk.delivery.account.values;

import co.com.sofka.domain.generic.Identity;
/**
 * AccountId class - Value object
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class AccountId extends Identity {
    public AccountId(String id) {
        super(id);
    }

    public static AccountId of(String id) {
        return new AccountId(id);
    }
}
