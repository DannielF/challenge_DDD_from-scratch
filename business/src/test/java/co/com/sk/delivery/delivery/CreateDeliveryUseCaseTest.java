package co.com.sk.delivery.delivery;

import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.delivery.commands.CreateDelivery;
import co.com.sk.delivery.delivery.events.DeliveryCreated;
import co.com.sk.delivery.delivery.values.DeliveryId;
import co.com.sk.delivery.delivery.values.State;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * CreateDeliveryUseCaseTest
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
class CreateDeliveryUseCaseTest {

    private CreateDeliveryUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CreateDeliveryUseCase();
    }

    @Test
    void createDeliveryAllOk() {
        var deliveryId = DeliveryId.of("ddd");
        var salesId = SalesId.of("sss");
        var accountId = AccountId.of("aaa");
        var state = new State(State.states.IN_PROGRESS);
        var command = new CreateDelivery(deliveryId, salesId, accountId, state);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var deliveryCreated = (DeliveryCreated) events.get(0);
        assertEquals("ddd", deliveryCreated.aggregateRootId());
        assertEquals("sss", deliveryCreated.salesId().value());
        assertEquals("aaa", deliveryCreated.accountId().value());
        assertEquals(state, deliveryCreated.state());
    }
}