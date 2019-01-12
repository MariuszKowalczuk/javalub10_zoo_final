package pl.sdacademy.animals.bear

import spock.lang.Specification

class BearSpec extends Specification {

    def "Bear should be alive immediately after creation"() {
        given:
        double weight = 3
        Bear bear = new BlackBear(weight)

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

    def "Bear should be alive if it has eaten within 10 days"() {
        given:
        double weight = 3
        double foodWeight = 2
        Bear bear = new BlackBear(weight)
        bear.eat(foodWeight)

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

//    def "Bear should not be alive if it has eaten within more than 10 days"() {
//        given:
//        int BirthWeight = 3
//        Bear bear = new BlackBear(BirthWeight)
//
//        when:
//        boolean result = bear.isAlive()
//
//        then:
//        result
//
//
//    }
    def "Bear should put on weight of amont od eaten food"() {
        given:
        double weight = 3
        double foodWeight = 2
        Bear bear = new BlackBear(weight)


        when:
        bear.eat(foodWeight)

        then:
        weight + foodWeight == bear.getCurrentWeight()

    }

    def "Bear's weight should increase of amount od 75% of water weight "(){
        given:
        double bearWeight = 3
        double waterWeight = 4
        Bear bear = new BlackBear(bearWeight)

        when:
        bear.drink(waterWeight)

        then:
        bearWeight+waterWeight*0.75==bear.getCurrentWeight()
    }

    def " Bear's weight should decrease of amount od 5 percent of his weight"(){
        given:
        double bearWeight = 3
        Bear bear = new BlackBear(bearWeight)

        when:
        bear.poop()

        then:
        bearWeight*0.95==bear.getCurrentWeight()
    }

    def "Bear should be alive if his current is greater or equal than his birth weight"(){
        given:

        double  bearWeight = 3
        Bear bear = new BlackBear(bearWeight)
        double currentWeight = 6

        when:
        boolean result = bear.isAlive()

        then:
        result==currentWeight>=bearWeight

    }

    def "Bear should be alive if his current is greater or equal than his birth weight after creation"(){
        given:

        double  bearWeight = 3
        Bear bear = new BlackBear(bearWeight)


        when:
        boolean result = bear.isAlive()

        then:
        result==bear.getCurrentWeight()>=bear.getBirthWeight()

    }

    def "Bear should be dead if he has pooped after creation without eating"(){
        given:
        double bearWeight = 3
        Bear bear = new BlackBear(bearWeight)

        when:
        bear.poop()

        then:
        !bear.isAlive()
    }



}
