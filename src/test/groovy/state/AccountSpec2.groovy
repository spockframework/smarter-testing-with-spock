package state

import spock.lang.Specification

class AccountSpec2 extends Specification {
    def "withdraw some amount"() {
        given:
        def account = new Account(5.0)

        when:
        account.withdraw(2.0)

        then:
        account.balance == 3.0
    }
}
