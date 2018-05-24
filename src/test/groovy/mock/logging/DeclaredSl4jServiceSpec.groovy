package mock.logging

import org.slf4j.Logger
import spock.lang.Specification

class DeclaredSl4jServiceSpec extends Specification {

    DeclaredSl4jService declaredSl4jService = new DeclaredSl4jService()
    def mockLogger = Mock(Logger)

    def setup() {
        declaredSl4jService.log = mockLogger
    }

    def cleanup() {
    }

    void "test mock with spock on declared logger"() {
        when:
        declaredSl4jService.logSomething()

        then:
        1 * mockLogger.info("Live life to the fullest")
    }
}
