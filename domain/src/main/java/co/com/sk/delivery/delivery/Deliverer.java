package co.com.sk.delivery.delivery;

import co.com.sk.delivery.delivery.values.DelivererId;
import co.com.sk.delivery.delivery.values.TypeContract;
import co.com.sk.delivery.generic.values.Name;
import co.com.sofka.domain.generic.Entity;

/**
 * Deliverer class - Entity
 *
 * @author dannielf
 * @version 0.0.1 2022-18-05
 * @since 0.0.1
 */
public class Deliverer extends Entity<DelivererId> {
    protected Name name;
    protected TypeContract typeContract;

    public Deliverer(DelivererId entityId, Name name, TypeContract typeContract) {
        super(entityId);
        this.name = name;
        this.typeContract = typeContract;
    }

    /**
     * Updates the deliverer's name
     *
     * @param name String
     */
    public void updateName(Name name) {
        this.name = name;
    }

    /**
     * Changes the deliverer's type of contract
     *
     * @param typeContract String
     */
    public void changeTypeContract(TypeContract typeContract) {
        this.typeContract = typeContract;
    }
}
