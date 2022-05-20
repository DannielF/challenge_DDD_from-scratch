package co.com.sk.delivery.account;

import co.com.sk.delivery.account.commands.CreateAccount;
import co.com.sk.delivery.account.events.AccountCreated;
import co.com.sk.delivery.account.values.AccountId;
import co.com.sk.delivery.account.values.Type;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CreateAccountUseCaseTest
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
class CreateAccountUseCaseTest {

    private CreateAccountUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CreateAccountUseCase();
    }

    @Test
    void createAccountAllOk() {
        var accountId = AccountId.of("aaa");
        var type = new Type("VIP");
        var command = new CreateAccount(accountId, type);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var accountCreated = (AccountCreated) events.get(0);
        assertEquals("aaa", accountCreated.aggregateRootId());
        assertEquals("VIP", accountCreated.typeAccount().value());
    }
}