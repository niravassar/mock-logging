package mock.logging

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.LoggingEvent
import ch.qos.logback.core.Appender
import grails.testing.services.ServiceUnitTest
import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import org.slf4j.LoggerFactory
import spock.lang.Specification

class AgeServiceSpec extends Specification implements ServiceUnitTest<AgeService> {

    def setup() {
    }

    def cleanup() {
    }

    void "test service prints to console"() {
        when:
        service.offerAgeAdvice(15)

        then:
        1 == 1
    }

    void "verify logging with mockito appender"() {
        when: "we attach a mocked appender to the logger"
        Appender mockedAppender = Mockito.mock(Appender)
        Logger logger = LoggerFactory.getLogger("mock.logging.AgeService")
        logger.addAppender(mockedAppender)

        service.offerAgeAdvice(22)

        ArgumentCaptor<Appender> argumentCaptor = ArgumentCaptor.forClass(Appender)
        Mockito.verify(mockedAppender,
                Mockito.times(2)).doAppend(argumentCaptor.capture())
        logger.detachAppender(mockedAppender)

        then: "we capture the arguments and verify log statements occurred"
        argumentCaptor.getAllValues().size() == 2
        List<LoggingEvent> loggingEvents = argumentCaptor.getAllValues()
        loggingEvents[0].getMessage() == "You are a young and vibrant :) Age 22"
        loggingEvents[0].getLevel() == Level.INFO
        loggingEvents[1].getMessage() == "Live life to the fullest"
        loggingEvents[1].getLevel() == Level.INFO
    }
}
