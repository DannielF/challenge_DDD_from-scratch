package co.com.sk.delivery.account;

import co.com.sk.delivery.account.commands.UpdateClientName;
import co.com.sk.delivery.account.events.AccountCreated;
import co.com.sk.delivery.account.events.ClientAdded;
import co.com.sk.delivery.account.events.ClientNameUpdated;
import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.ClientId;
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
 * UpdateClientNameUseCaseTest
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
class UpdateClientNameUseCaseTest {

    @InjectMocks
    private UpdateClientNameUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateClientNameAllOk() {
        var accountId = AccountId.of("aaa");
        var clientId = ClientId.of("ccc");
        var name = new Name("Mark");
        var command = new UpdateClientName(accountId, clientId, name);

        when(repository.getEventsBy("aaa")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.accountId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ClientNameUpdated) events.get(0);
        assertEquals(clientId, event.clientId());
        assertEquals(name, event.name());
    }

    private List<DomainEvent> history() {
        var type = new Type("VIP");
        var event = new AccountCreated(type);
        event.setAggregateRootId("AAA");

        var clientId = ClientId.of("ccc");
        var name = new Name("Jon");
        var phone = new Phone("111");
        var event2 = new ClientAdded(clientId, name, phone);

        return List.of(event, event2);
    }
}