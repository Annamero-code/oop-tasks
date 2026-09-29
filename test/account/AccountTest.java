package account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account myAccount;


    @BeforeEach
    public void startWith() {
        myAccount = new Account(5555);
    }

    @Test
    public void testThatIHaveAnAccount_AndBalanceIsZero() {
        assertEquals(0, myAccount.checkBalance(5555));
    }

    @Test
    public void testThatIDeposit5k_BalanceIs5k() {
        myAccount.deposit(5000);
        assertEquals(5000, myAccount.checkBalance(5555));
    }

    @Test
    public void testThatIDepositNegativeAmount_BalanceIsZero() {
        myAccount.deposit(-5000);
        assertEquals(0, myAccount.checkBalance(5555));
    }

    @Test
    public void testThatIDeposit10k_BalanceIs3k() {
        myAccount.deposit(7000);
        myAccount.withdraw(4000, 5555);
        assertEquals(3000, myAccount.checkBalance(5555));
    }

    @Test
    public void testThatIWithdraw5k_BalanceIsZero() {
        myAccount.withdraw(5000, 5555);
        assertEquals(0, myAccount.checkBalance(5555));
    }

    @Test
    public void testThatIWithdrwNegativeAmount_BalanceIsZero() {
        myAccount.withdraw(-5000,5555);
        assertEquals(0, myAccount.checkBalance(5555));
    }

    @Test
    public void testThatICanNotWithAWrongPin(){
        myAccount.deposit(6000);
        boolean result = myAccount.withdraw(4000,2222);

        assertFalse(result);
        assertEquals(6000, myAccount.checkBalance(5555));
    }
}