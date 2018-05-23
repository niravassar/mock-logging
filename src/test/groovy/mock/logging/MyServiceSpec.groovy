package mock.logging

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class MyServiceSpec extends Specification implements ServiceUnitTest<MyService>, DataTest{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        when:
        service.serviceMethod()

        then:
        1 == 1
    }
}
