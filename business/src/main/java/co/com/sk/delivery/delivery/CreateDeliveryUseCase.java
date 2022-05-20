package co.com.sk.delivery.delivery;

import co.com.sk.delivery.delivery.commands.CreateDelivery;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * CreateDeliveryUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class CreateDeliveryUseCase extends UseCase<RequestCommand<CreateDelivery>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateDelivery> createDeliveryRequestCommand) {
        var command = createDeliveryRequestCommand.getCommand();

        var delivery = new Delivery(command.deliveryId(), command.salesId(),command.accountId(), command.state());

        emit().onResponse(new ResponseEvents(delivery.getUncommittedChanges()));
    }
}
