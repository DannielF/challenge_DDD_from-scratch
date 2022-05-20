package co.com.sk.delivery.account;

import co.com.sk.delivery.account.commands.AddOrder;
import co.com.sk.delivery.account.events.AccountCreated;
import co.com.sk.delivery.account.events.OrderAdded;
import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.Address;
import co.com.sk.delivery.account.values.Description;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * AddOrderUseCaseTest
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
class AddOrderUseCaseTest {

    @InjectMocks
    private AddOrderUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addOrderAllOk() {
        var accountId = AccountId.of("aaa");
        var description = new Description("Croissant");
        var address = new Address("cl 1 # 1 - 1");
        var command = new AddOrder(accountId, description, address);

        when(repository.getEventsBy("aaa")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.accountId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (OrderAdded) events.get(0);
        assertEquals(description, event.description());
        assertEquals(address, event.address());
    }

    private List<DomainEvent> history() {
        var type = new Type("VIP");
        var event = new AccountCreated(type);
        event.setAggregateRootId("AAA");

        return List.of(event);
    }
}