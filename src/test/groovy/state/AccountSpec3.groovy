package state

import spock.lang.Specification

class AccountSpec3 extends Specification {
    def "withdraw some amount"() {
        given: "an account with a balance of five euros"
        def account = new Account(5.0)

        when: "two euros are withdrawn"
        account.withdraw(2.0)

        then: "three euros remain in the account"
        account.balance == 3.0
    }
}
