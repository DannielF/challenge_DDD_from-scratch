package co.com.sk.delivery.delivery;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.delivery.commands.AddTransport;
import co.com.sk.delivery.delivery.events.DeliveryCreated;
import co.com.sk.delivery.delivery.events.TransportAdded;
import co.com.sk.delivery.delivery.values.DeliveryId;
import co.com.sk.delivery.delivery.values.Load;
import co.com.sk.delivery.delivery.values.State;
import co.com.sk.delivery.delivery.values.Vehicle;
import co.com.sk.delivery.generic.values.Product;
import co.com.sk.delivery.generic.values.Quantity;
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
 * AddTransportUseCaseTest
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
class AddTransportUseCaseTest {

    @InjectMocks
    private AddTransportUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addTransportAllOk() {
        var deliveryId = DeliveryId.of("ddd");
        var vehicle = new Vehicle("Bike");
        var product = new Product("Roscon");
        var quantity = new Quantity(10);
        var load = new Load(25D);
        var command = new AddTransport(deliveryId, vehicle, product, quantity, load);

        when(repository.getEventsBy(command.deliveryId().value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TransportAdded) events.get(0);
        assertEquals(vehicle, event.vehicle());
        assertEquals(product, event.product());
        assertEquals(quantity, event.quantity());
        assertEquals(load, event.load());
    }

    private List<DomainEvent> history() {
        var salesId = SalesId.of("SSS");
        var accountId = AccountId.of("AAA");
        var state = new State(State.states.IN_PROGRESS);

        var event = new DeliveryCreated(salesId, accountId, state);
        event.setAggregateRootId("xxx");

        return List.of(event);
    }
}