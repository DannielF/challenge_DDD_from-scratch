package co.com.sk.delivery.delivery;

import co.com.sk.delivery.delivery.commands.AddDeliverer;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * AddDelivererUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class AddDelivererUseCase extends UseCase<RequestCommand<AddDeliverer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDeliverer> addDelivererRequestCommand) {
        var command = addDelivererRequestCommand.getCommand();

        var delivery = Delivery.from(
                command.deliveryId(), repository().getEventsBy(command.deliveryId().value())
        );
        delivery.addDeliverer(command.name(), command.typeContract());

        emit().onResponse(new ResponseEvents(delivery.getUncommittedChanges()));
    }
}
