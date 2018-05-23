package mock.logging

class MyController {

    AgeService ageService

    def index() {

    }

    def printLog() {
        ageService.printLog()
        render "done"
    }
}
