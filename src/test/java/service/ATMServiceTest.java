package service;

import component.AccountComponent;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import exceptions.MaxWithdrawExceededException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {

    @Mock
    AccountComponent accountComponent;

    @InjectMocks
    ATMService atmService;

    @Test
    public void depositTest() {
        when(accountComponent.getBalance()).thenReturn(0, 500);
        atmService.deposit(500);

        assertEquals(500, atmService.getBalance());
    }

    @Test
    public void withdrawAmountTest() {
        when(accountComponent.getBalance()).thenReturn(1000);
        atmService.withdraw(500);

        verify(accountComponent).withdraw(500);
    }

    @Test
    public void getBalanceTest() {
        when(accountComponent.getBalance()).thenReturn(200);

        assertEquals(200, atmService.getBalance());
    }

    @Test
    public void invalidAmountExceptionTest() {
        int deposit = 0;

        assertThrows(InvalidAmountException.class, () -> {
            atmService.deposit(deposit);
        });
    }

    @Test
    public void maxWithdrawExceededExceptionTest() {
        int withdraw = 10000;

        assertThrows(MaxWithdrawExceededException.class, () -> {
            atmService.withdraw(withdraw);
        });
    }

    @Test
    public void insufficientFundsExceptionTest() {
        int balance = 0;

        assertThrows(InsufficientFundsException.class, () -> {
            atmService.withdraw(500);
        });
    }

    @Test
    public void withdrawInvalidAmountExceptionTest() {
        int withdraw = 0;

        assertThrows(InvalidAmountException.class, () -> {
            atmService.withdraw(withdraw);
        });
    }
}
