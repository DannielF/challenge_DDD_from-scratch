package co.com.sk.delivery.delivery;

import co.com.sk.delivery.delivery.commands.AddTransport;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * AddTransportUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class AddTransportUseCase extends UseCase<RequestCommand<AddTransport>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddTransport> addTransportRequestCommand) {
        var command = addTransportRequestCommand.getCommand();

        var delivery = Delivery.from(
                command.deliveryId(), repository().getEventsBy(command.deliveryId().value())
        );
        delivery.addTransport(command.vehicle(), command.product(), command.quantity(), command.load());

        emit().onResponse(new ResponseEvents(delivery.getUncommittedChanges()));
    }
}
