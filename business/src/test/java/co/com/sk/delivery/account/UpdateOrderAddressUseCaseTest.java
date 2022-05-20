package co.com.sk.delivery.account;

import co.com.sk.delivery.account.commands.UpdateOrderAddress;
import co.com.sk.delivery.account.events.AccountCreated;
import co.com.sk.delivery.account.events.OrderAdded;
import co.com.sk.delivery.account.events.OrderAddressUpdated;
import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.Address;
import co.com.sk.delivery.account.values.Description;
import co.com.sk.delivery.account.values.OrderId;
import co.com.sk.delivery.account.values.Type;
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
 * UpdateOrderAddressUseCaseTest
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
class UpdateOrderAddressUseCaseTest {

    @InjectMocks
    private UpdateOrderAddressUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateOrderAddressAllOk() {
        var accountId = AccountId.of("aaa");
        var orderId = OrderId.of("ooo");
        var address = new Address("Avenue 1");
        var command = new UpdateOrderAddress(accountId, orderId, address);

        when(repository.getEventsBy("aaa")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.accountId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (OrderAddressUpdated) events.get(0);
        assertEquals(orderId, event.orderId());
        assertEquals(address, event.address());
    }

    private List<DomainEvent> history() {
        var type = new Type("VIP");
        var event = new AccountCreated(type);
        event.setAggregateRootId("AAA");

        var orderId = OrderId.of("ooo");
        var description = new Description("Roscon");
        var address = new Address("Avenue 2");
        var event2 = new OrderAdded(orderId, description, address);

        return List.of(event, event2);
    }
}