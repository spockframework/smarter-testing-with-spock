package state

import spock.lang.Specification

class AccountSpec extends Specification {
    void withdrawSomeAmount() {
        given:
        Account account = new Account(BigDecimal.valueOf(5));

        when:
        account.withdraw(BigDecimal.valueOf(2));

        then:
        account.getBalance() == BigDecimal.valueOf(3);
    }
}
