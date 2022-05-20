package co.com.sk.delivery.account;

import co.com.sk.delivery.account.commands.AddClient;
import co.com.sk.delivery.account.events.AccountCreated;
import co.com.sk.delivery.account.events.ClientAdded;
import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.Phone;
import co.com.sk.delivery.account.values.Type;
import co.com.sk.delivery.generic.values.Name;
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
 * AddClientUseCaseTest
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
class AddClientUseCaseTest {

    @InjectMocks
    private AddClientUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addClientAllOk() {
        var accountId = AccountId.of("aaa");
        var name = new Name("mock");
        var phone = new Phone("123");
        var command = new AddClient(accountId, name, phone);

        when(repository.getEventsBy("aaa")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.accountId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ClientAdded) events.get(0);
        assertEquals("mock", event.name().value());
        assertEquals("123", event.phone().value());
    }

    private List<DomainEvent> history() {
        var type = new Type("VIP");
        var event = new AccountCreated(type);
        event.setAggregateRootId("AAA");

        return List.of(event);
    }
}