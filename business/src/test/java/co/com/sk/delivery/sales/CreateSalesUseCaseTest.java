package co.com.sk.delivery.sales;

import co.com.sk.delivery.sales.commands.CreateSales;
import co.com.sk.delivery.sales.events.SalesCreated;
import co.com.sk.delivery.sales.values.NumberOfSales;
import co.com.sk.delivery.sales.values.SalesId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CreCreateSalesUseCaseTest
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
class CreateSalesUseCaseTest {

    private CreateSalesUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CreateSalesUseCase();
    }

    @Test
    void createSalesAllOk() {
        var salesId = SalesId.of("sss");
        var numberOfSales = new NumberOfSales(10D);
        var command = new CreateSales(salesId, numberOfSales);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var salesCreated = (SalesCreated) events.get(0);
        assertEquals("sss", salesCreated.aggregateRootId());
        assertEquals(numberOfSales, salesCreated.numberOfSales());
    }
}