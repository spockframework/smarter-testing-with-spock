package coolstuff

import spock.lang.Specification

class OptimizeRunOrder extends Specification {
    def "a slow test"() {
        expect: Thread.sleep(3000)
    }

    def "a fast test"() {
        expect: true
    }

    def "a sometimes bad test"() {
        //expect: System.currentTimeMillis() % 3
    }

    def "a bad test"() {
        //expect: false
    }
}
