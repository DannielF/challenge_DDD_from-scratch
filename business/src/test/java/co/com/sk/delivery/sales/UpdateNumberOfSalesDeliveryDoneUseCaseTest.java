package co.com.sk.delivery.sales;

import co.com.sk.delivery.delivery.events.DeliveryDone;
import co.com.sk.delivery.delivery.values.State;
import co.com.sk.delivery.sales.events.NumberOfSalesUpdated;
import co.com.sk.delivery.sales.events.SalesCreated;
import co.com.sk.delivery.sales.values.NumberOfSales;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
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
 * UpdateNumberOfSalesDeliveryDoneUseCaseTest
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
class UpdateNumberOfSalesDeliveryDoneUseCaseTest {

    @InjectMocks
    private UpdateNumberOfSalesDeliveryDoneUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateNumberOfSalesDeliveryDoneAllOk() {
        var salesId = SalesId.of("sss");
        var numberOfSales = new NumberOfSales(1D);
        var event = new DeliveryDone(new State(State.states.DONE), numberOfSales, salesId);

        when(repository.getEventsBy("sss")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var numberOfSalesUpdated = (NumberOfSalesUpdated) events.get(0);
        assertEquals(numberOfSales, numberOfSalesUpdated.numberOfSales());
        assertEquals(salesId, numberOfSalesUpdated.salesId());
    }

    private List<DomainEvent> history() {
        var numberOfSales = new NumberOfSales(0D);
        var firstEvent = new SalesCreated(numberOfSales);
        firstEvent.setAggregateRootId("SSS");

        return List.of(firstEvent);
    }
}