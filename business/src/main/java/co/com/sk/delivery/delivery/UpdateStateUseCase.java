package co.com.sk.delivery.delivery;

import co.com.sk.delivery.delivery.commands.UpdateState;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * UpdateStateUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class UpdateStateUseCase extends UseCase<RequestCommand<UpdateState>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateState> updateStateRequestCommand) {
        var command = updateStateRequestCommand.getCommand();

        var delivery = Delivery.from(
                command.deliveryId(), repository().getEventsBy(command.deliveryId().value())
        );
        delivery.updateState(command.state());

        emit().onResponse(new ResponseEvents(delivery.getUncommittedChanges()));
    }
}
