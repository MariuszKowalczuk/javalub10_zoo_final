package pl.sdacademy.animals.bear

import pl.sdacademy.animals.time.TestingClock
import spock.lang.Specification

import java.time.LocalDate

class BearSpec extends Specification {

    def "Bear should not be alive immediately after creation"() {
        given:
        double weight = 3
        Bear bear = new BlackBear(weight)

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

    def "Bear should be alive if it has eaten within 10 days when it's not hibernating"() {
        given:

        int weight = 3
        TestingClock testingClock = new TestingClock()
        testingClock.setDateOfClock(LocalDate.now().withMonth(8).withDayOfMonth(20))

        Bear bear = new BlackBear(weight, testingClock)
        bear.eat(2)


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

    def "Bear's weight should increase by 75% of weight of water he drinks if it's not hibernating"() {
        given:
        int weight = 3
        double waterWeight = 2
        TestingClock testingClock = new TestingClock()
        testingClock.setDateOfClock(LocalDate.now().withMonth(8).withDayOfMonth(20))
        Bear bear = new BlackBear(weight, testingClock)

        when:
        bear.drink(waterWeight)

        then:
        bear.getWeight() == weight + 0.75 * waterWeight
    }

    def "Black bear should be hibernating only between 20th November and 15th March"() {
        given:
        int weight = 3
        TestingClock myTestingClock = new TestingClock()
        myTestingClock.setDateOfClock(LocalDate.now()
                .withMonth(month)
                .withDayOfMonth(day))
        Bear bear = new BlackBear(weight, myTestingClock)

        when:
        boolean result = bear.isHibernating()

        then:
        expected == result

        where:
        month | day | expected
        11    | 20  | true
        11    | 21  | true
        11    | 19  | false
        3     | 15  | true
        3     | 16  | false
        3     | 14  | true
        2     | 3   | true
        6     | 8   | false
    }

    def "Brown bear should be hibernating only between 1st of december and 20th od April"() {
        given:
        int bearWeight = 5
        TestingClock testingClock = new TestingClock()
        testingClock.setDateOfClock(LocalDate.now().withMonth(month).withDayOfMonth(day))
        Bear bear = new BrownBear(bearWeight, testingClock)

        when:
        boolean result = bear.isHibernating()

        then:

        expected == result

        where:

        month | day | expected
        11    | 30  | false
        11    | 29  | false
        12    | 01  | true
        12    | 02  | true
        04    | 21  | false
        04    | 20  | true
        04    | 19  | true
        07    | 20  | false // nie działa ale dlaczego?
        02    | 12  | true

    }

    def "Polar bear should be hibernating between 5th of may to 10th of October"() {
        given:
        double bearWeight = 3
        TestingClock testingClock = new TestingClock()
        testingClock.setDateOfClock(LocalDate.now().withMonth(month).withDayOfMonth(day))
        Bear bear = new PolarBear(bearWeight, testingClock)

        when:
        boolean result = bear.isHibernating()

        then:
        expected == result

        where:
        day | month | expected
        02  | 03    | false
        04  | 05    | false
        05  | 05    | true
        06  | 05    | true
        07  | 10    | true
        10  | 10    | true
        11  | 10    | false
        12  | 12    | false



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
