package co.com.sk.delivery.sales;

import co.com.sk.delivery.generic.values.Name;
import co.com.sk.delivery.sales.commands.HireVendor;
import co.com.sk.delivery.sales.events.SalesCreated;
import co.com.sk.delivery.sales.events.VendorHired;
import co.com.sk.delivery.sales.values.NumberOfSales;
import co.com.sk.delivery.sales.values.Salary;
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
 * HireVendorUseCaseTest
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
class HireVendorUseCaseTest {

    @InjectMocks
    private HireVendorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void hireVendorAllOk() {
        var salesId = SalesId.of("sss");
        var name = new Name("Mel");
        var salary = new Salary(1000);
        var command = new HireVendor(salesId, name, salary);

        when(repository.getEventsBy("sss")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.salesId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (VendorHired) events.get(0);
        assertEquals(name, event.name());
        assertEquals(salary, event.salary());
    }

    private List<DomainEvent> history() {
        var numberOfSales = new NumberOfSales(0D);
        var firstEvent = new SalesCreated(numberOfSales);
        firstEvent.setAggregateRootId("SSS");

        return List.of(firstEvent);
    }
}