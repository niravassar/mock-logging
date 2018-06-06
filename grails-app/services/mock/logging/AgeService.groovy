package mock.logging

class AgeService {

    void offerAgeAdvice(int age) {
        println "****** log in the service *******" + log.dump()

        if (age < 0) {
            log.error ("You cannot be $age years old!")
        } else if (0 < age && age < 30 ) {
            log.info ("You are a young and vibrant :) Age $age")
            log.info ("Live life to the fullest")
        } else if (30 <= age) {
            log.warn ("It's all downhill from here, sorry. Age $age")
        }

    }
}
