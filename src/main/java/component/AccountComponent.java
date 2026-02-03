package component;

import org.springframework.stereotype.Component;

@Component
public class AccountComponent {

    private int balance = 0;

    public void withdraw(int sum) {
        balance = balance - sum;
    }

    public void deposit(int sum) {
        balance = balance + sum;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Balance: " + balance + "kr";
    }
}
