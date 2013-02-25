package state;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    @Test
    public void withdrawSomeAmount() {
        // given
        Account account = new Account(BigDecimal.valueOf(5));

        // when
        account.withdraw(BigDecimal.valueOf(2));

        // then
        assertEquals(BigDecimal.valueOf(3), account.getBalance());
    }
}
