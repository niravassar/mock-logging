package mock.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Non grails groovy class with a declared Sl4j logging object
 */
class DeclaredSl4jService {

    private static Logger log = LoggerFactory.getLogger(DeclaredSl4jService.class)

    void logSomething() {
        println "*********** log in the class ******" + log.dump()
        log.info("Live life to the fullest")
    }
}
