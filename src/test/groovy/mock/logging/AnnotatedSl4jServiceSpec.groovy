package mock.logging

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.LoggingEvent
import ch.qos.logback.core.Appender
import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import org.slf4j.LoggerFactory
import spock.lang.Specification

class AnnotatedSl4jServiceSpec extends Specification {

    AnnotatedSl4jService annotatedSl4jService = new AnnotatedSl4jService()

    def setup() {
    }

    def cleanup() {
    }

    void "test mock with mockito on @Sl4j logger"() {
        when:
        Appender mockedAppender = Mockito.mock(Appender.class)
        Logger logger = LoggerFactory.getLogger("mock.logging.AnnotatedSl4jService")
        logger.addAppender(mockedAppender)

        annotatedSl4jService.logSomething()

        ArgumentCaptor<Appender> argumentCaptor = ArgumentCaptor.forClass(Appender.class)
        Mockito.verify(mockedAppender, Mockito.times(1)).doAppend(argumentCaptor.capture())
        logger.detachAppender(mockedAppender)

        then:
        argumentCaptor.getAllValues().size() == 1
        List<LoggingEvent> loggingEvents = argumentCaptor.getAllValues()
        loggingEvents[0].getMessage() == "Carpe Diem"
        loggingEvents[0].getLevel() == Level.INFO
    }
}
