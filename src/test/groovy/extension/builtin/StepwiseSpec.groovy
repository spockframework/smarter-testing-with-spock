package extension.builtin

import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class StepwiseSpec extends Specification {
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
