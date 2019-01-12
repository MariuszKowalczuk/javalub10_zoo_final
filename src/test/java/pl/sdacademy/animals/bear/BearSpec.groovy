package pl.sdacademy.animals.bear

import spock.lang.Specification

class BearSpec extends Specification {

    def "Bear should be alive immediately after creation"() {
        given:
        int weight = 3
        Bear bear = new BlackBear(weight)

        when:
        boolean  result = bear.isAlive()

        then:
        !result
    }

    def "Bear should be alive if it has eaten within 10 days"() {
        given:
        int weight = 3
        Bear bear = new BlackBear(weight)
        bear.eat()

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

//    def "Bear should not be alive if it has eaten within more than 10 days"() {
//        given:
//        int weight = 3
//        Bear bear = new BlackBear(weight)
//
//        when:
//        boolean result = bear.isAlive()
//
//        then:
//        result
//
//
//    }
    def "Bear should put on weight if it has eaten food"(){
        given:
        int weight = 3
        int foodWeight = 2
        Bear bear = new BlackBear(weight)
        bear.eat(foodWeight)

        when:
        int result = weight + foodWeight

        then:
        result==bear.getWeight()


    }

}
