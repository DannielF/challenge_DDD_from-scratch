package co.com.sk.delivery.account;

import co.com.sk.delivery.account.values.ClientId;
import co.com.sk.delivery.account.values.Phone;
import co.com.sk.delivery.generic.values.Name;
import co.com.sofka.domain.generic.Entity;
import org.apache.commons.lang3.Validate;

/**
 * Client class - Entity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class Client extends Entity<ClientId> {

    private static final String VALIDATION_MESSAGE = "There's must be a value";
    private static final String VALIDATION_MESSAGE_UPDATE = "Cannot be empty";

    protected Name name;
    protected Phone phone;

    public Client(ClientId entityId, Name name, Phone phone) {
        super(entityId);
        this.name = Validate.notNull(name, VALIDATION_MESSAGE);
        this.phone = Validate.notNull(phone, VALIDATION_MESSAGE);
    }

    /**
     * Update a client's name
     *
     * @param name String
     */
    public void updateName(Name name) {
        if (name.value().isBlank()) {
            throw new IllegalArgumentException(VALIDATION_MESSAGE_UPDATE);
        }
        this.name = name;
    }

    /**
     * Update a client's phone
     *
     * @param phone String
     */
    public void updatePhone(Phone phone) {
        if (phone.value().isBlank()) {
            throw new IllegalArgumentException(VALIDATION_MESSAGE_UPDATE);
        }
        this.phone = phone;
    }
}
