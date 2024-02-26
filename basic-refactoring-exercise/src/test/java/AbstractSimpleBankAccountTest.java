import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;

public abstract class AbstractSimpleBankAccountTest {

    protected static final int DEPOSIT_AMOUNT = 100;
    protected static final int WITHDRAW_AMOUNT = 70;
    protected static final int INITIAL_AMOUNT = 0;
    private static final int WRONG_USER_ID = 0;
    private static final int USER_ID = 1;

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", USER_ID);
        bankAccount = createBankAccount(accountHolder);
    }

    protected abstract BankAccount createBankAccount(AccountHolder accountHolder);

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
    }

    protected BankAccount getBankAccount() {
        return this.bankAccount;
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(WRONG_USER_ID, DEPOSIT_AMOUNT);
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_AMOUNT);
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(2, WITHDRAW_AMOUNT);
    }
}
