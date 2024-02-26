import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractSimpleBankAccountTest{

    @Override
    protected BankAccount createBankAccount(AccountHolder accountHolder) {
        return new SimpleBankAccount(accountHolder, INITIAL_AMOUNT);
    }

    @Test
    void testDeposit() {
        super.testDeposit();
        assertEquals(DEPOSIT_AMOUNT, super.getBankAccount().getBalance());
    }

    @Test
    void testWrongDeposit() {
        super.testWrongDeposit();
        assertEquals(DEPOSIT_AMOUNT, super.getBankAccount().getBalance());
    }

    @Test
    void testWithdraw() {
        super.testWithdraw();
        assertEquals(DEPOSIT_AMOUNT - WITHDRAW_AMOUNT, super.getBankAccount().getBalance());
    }

    @Test
    void testWrongWithdraw() {
        super.testWrongWithdraw();
        assertEquals(DEPOSIT_AMOUNT, super.getBankAccount().getBalance());
    }
    
}
