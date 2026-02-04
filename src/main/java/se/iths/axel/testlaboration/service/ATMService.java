package se.iths.axel.testlaboration.service;

import org.springframework.stereotype.Service;
import se.iths.axel.testlaboration.component.AccountComponent;
import se.iths.axel.testlaboration.exceptions.InsufficientFundsException;
import se.iths.axel.testlaboration.exceptions.InvalidAmountException;
import se.iths.axel.testlaboration.exceptions.MaxWithdrawExceededException;

@Service
public class ATMService {

    final int maxWithdraw = 5000;

    private final AccountComponent accountComponent;

    public ATMService(AccountComponent accountComponent) {
        this.accountComponent = accountComponent;
    }

    public void withdraw(int sum) {
        int balance = accountComponent.getBalance();

        if (sum <= 0) {
            throw new InvalidAmountException("Invalid amount");
        }
        if (sum > maxWithdraw) {
            throw new MaxWithdrawExceededException("Withdraw amount exceeded");
        }
        if (sum > balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        accountComponent.withdraw(sum);
    }

    public void deposit(int sum) {
        if (sum <= 0) {
            throw new InvalidAmountException("Invalid amount");
        }
        accountComponent.deposit(sum);
    }

    public int getBalance() {
        return accountComponent.getBalance();
    }
}
