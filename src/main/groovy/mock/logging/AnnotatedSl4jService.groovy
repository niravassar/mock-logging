package mock.logging

import groovy.util.logging.Slf4j

/**
 * Non grails groovy class with a annotation for Sl4j
 */
@Slf4j
class AnnotatedSl4jService {

    void logSomething() {
        println "*********** log in the class ******" + log.dump()
        log.info("Live life to the fullest")
    }
}
