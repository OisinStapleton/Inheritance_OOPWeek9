package ie.atu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount();
    }

    @Test
    void contructorInitialisation() {
        account = new BankAccount("ACC123456", "Donald", 100);
        assertEquals("ACC123456", account.getAccNo());
        assertEquals("Donald", account.getName());
        assertEquals(100, account.getBalance());
    }

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
}
