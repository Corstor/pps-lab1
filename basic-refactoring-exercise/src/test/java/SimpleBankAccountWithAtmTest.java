import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest {

    private static final int FEE = 1;

    @Override
    protected BankAccount createBankAccount(AccountHolder accountHolder) {
        return new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testDeposit() {
        super.testDeposit();
        assertEquals(DEPOSIT_AMOUNT - FEE, super.getBankAccount().getBalance());
    }

    @Test
    void testWrongDeposit() {
        super.testWrongDeposit();
        assertEquals(DEPOSIT_AMOUNT - FEE, super.getBankAccount().getBalance());
    }

    @Test
    void testWithdraw() {
        super.testWithdraw();
        int afterDepositAmount = DEPOSIT_AMOUNT - FEE;
        assertEquals(afterDepositAmount - WITHDRAW_AMOUNT - FEE , super.getBankAccount().getBalance());
    }

    @Test
    void testWrongWithdraw() {
        super.testWrongWithdraw();
        assertEquals(DEPOSIT_AMOUNT - FEE, super.getBankAccount().getBalance());
    }
}
