package co.com.sk.delivery.delivery;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.delivery.commands.UpdateTypeContractDeliverer;
import co.com.sk.delivery.delivery.events.DelivererAdded;
import co.com.sk.delivery.delivery.events.DeliveryCreated;
import co.com.sk.delivery.delivery.events.TypeContractDelivererUpdated;
import co.com.sk.delivery.delivery.values.DelivererId;
import co.com.sk.delivery.delivery.values.DeliveryId;
import co.com.sk.delivery.delivery.values.State;
import co.com.sk.delivery.delivery.values.TypeContract;
import co.com.sk.delivery.generic.values.Name;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * UpdateTypeContractDelivererUseCaseTest
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
class UpdateTypeContractDelivererUseCaseTest {

    @InjectMocks
    private UpdateTypeContractDelivererUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateTypeContractDelivererAllOk() {
        var deliveryId = DeliveryId.of("ddd");
        var delivererId = DelivererId.of("dede");
        var typeContract = new TypeContract("Full-time");
        var command = new UpdateTypeContractDeliverer(deliveryId, delivererId, typeContract);

        when(repository.getEventsBy(command.deliveryId().value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TypeContractDelivererUpdated) events.get(0);
        assertEquals(delivererId, event.delivererId());
        assertEquals(typeContract, event.typeContract());
    }

    private List<DomainEvent> history() {
        var salesId = SalesId.of("SSS");
        var accountId = AccountId.of("AAA");
        var state = new State(State.states.IN_PROGRESS);

        var event = new DeliveryCreated(salesId, accountId, state);
        event.setAggregateRootId("xxx");

        var delivererId = DelivererId.of("dede");
        var name = new Name("DeliveryMan");
        var typeContract = new TypeContract("Contractor");
        var event2 = new DelivererAdded(delivererId, name, typeContract);

        return List.of(event, event2);
    }
}