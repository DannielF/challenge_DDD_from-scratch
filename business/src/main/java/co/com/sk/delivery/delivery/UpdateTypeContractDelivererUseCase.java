package co.com.sk.delivery.delivery;

import co.com.sk.delivery.delivery.commands.UpdateTypeContractDeliverer;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

/**
 * UpdateTypeContractDelivererUseCase class - UseCase
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class UpdateTypeContractDelivererUseCase extends UseCase<RequestCommand<UpdateTypeContractDeliverer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateTypeContractDeliverer> updateTypeContractDelivererRequestCommand) {
        var command = updateTypeContractDelivererRequestCommand.getCommand();

        var delivery = Delivery.from(
                command.deliveryId(), repository().getEventsBy(command.deliveryId().value())
        );
        delivery.updateTypeContractDeliverer(command.delivererId(), command.typeContract());

        emit().onResponse(new ResponseEvents(delivery.getUncommittedChanges()));
    }
}
