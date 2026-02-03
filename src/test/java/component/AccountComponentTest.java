package component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComponentTest {

    private AccountComponent accountComponent;

    @BeforeEach
    public void setUp() {
        accountComponent = new AccountComponent();
    }

    @Test
    public void withdrawBalanceTest() {
        accountComponent.withdraw(300);
        assertEquals(-300, accountComponent.getBalance());
    }

    @Test
    public void depositBalanceTest() {
        accountComponent.deposit(5000);
        assertEquals(5000, accountComponent.getBalance());
    }

    @Test
    public void getBalanceTest() {
        int balance = accountComponent.getBalance();
        assertEquals(0, balance);
    }

    @Test
    public void depositAndWithdrawTest() {
        accountComponent.deposit(250);
        accountComponent.withdraw(200);
        assertEquals(50, accountComponent.getBalance());
    }
}
