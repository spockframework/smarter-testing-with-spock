package datadriven

import spock.lang.Specification
import spock.lang.Unroll
import state.Account

class AccountSpecDataDriven extends Specification {
    @Unroll({"withdrawing $withdrawn from account with balance $balance"})
    def "withdraw an amount"() {
        given:
        def account = new Account(balance)

        when:
        account.withdraw(withdrawn)

        then:
        account.balance == remaining

        where:
        balance | withdrawn || remaining
        5.0     | 2.0       || 3.0
        4.0     | 0.0       || 4.0
        4.0     | 4.0       || 0.0
    }
}
