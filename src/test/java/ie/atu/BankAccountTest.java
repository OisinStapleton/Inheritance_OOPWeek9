package ie.atu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount("ACC123456", "Donald", 100 );
    }

    @Test
    void constructorInitialisation() {
        account = new BankAccount("ACC123456", "Donald", 100);
        assertEquals("ACC123456", account.getAccNo());
        assertEquals("Donald", account.getName());
        assertEquals(100, account.getBalance());
    }
// comment added because commit is not working.
    @Test
    void constructorNegativeInitialisation() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new BankAccount("ACC12345", "Michael", -100));
        assertEquals("Balance must be greater than 0.", ex.getMessage());
    }

    @Test
    void depositPositiveAmount() {
        double currentFunds = account.getBalance();
        account.deposit(600);
        assertEquals(currentFunds + 600, account.getBalance());
    }


    @Test
    void depositNegativeAmount() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
        assertEquals("Amount must be greater than 0.", ex.getMessage());
    }

    @Test
    void withdrawPositiveAmount() {
        double currentFunds = account.getBalance();
        account.withdraw(100);
        assertEquals(currentFunds - 100, account.getBalance());
    }

    @Test
    void withdrawNegativeAmount() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-300));
        assertEquals("Withdraw amount must be greater than 0.", ex.getMessage());
    }
    @Test
    void withdrawTooMuch() {
        int currentFunds = account.getBalance();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.withdraw(currentFunds+1));
        assertEquals("Insufficient funds.", ex.getMessage());
    }
}
