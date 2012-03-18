package extension.builtin

import spock.lang.Specification
import org.junit.rules.TestName
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Shared

class JUnitRules extends Specification {
    @Rule TemporaryFolder tempFolder
    @Shared File file

    def "a file based test"() {
        when:
        file = tempFolder.newFile("foo.txt")

        then:
        file.exists()
    }

    def "by now the file has been deleted"() {
        expect:
        !file.exists()
    }
}
