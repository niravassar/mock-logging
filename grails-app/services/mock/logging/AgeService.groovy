package mock.logging

class AgeService {

    def offerAgeAdvice(int age) {
        if (age < 0) {
            log.error ("You cannot be $age years old!")
        } else if (0 < age && age < 30 ) {
            println "****** log in the service *******" + log.dump()
            log.info ("You are a young and vibrant :) Age $age")
            log.info ("Live life to the fullest")
        } else if (30 <= age) {
            log.warn ("It's all downhill from here, sorry. Age $age")
        }

    }
}
