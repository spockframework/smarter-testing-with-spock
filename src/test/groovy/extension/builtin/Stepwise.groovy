package extension.builtin

import spock.lang.Specification
import spock.lang.Stepwise

@spock.lang.Stepwise
class Stepwise extends Specification {
    def "step 1"() {
        expect: true
    }

    def "step 2"() {
        expect: true
    }

    def "step 3"() {
        expect: true
    }
}
