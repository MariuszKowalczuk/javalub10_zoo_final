package pl.sdacademy.animals.bear;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pl.sdacademy.animals.time.TestingClock;

import java.time.LocalDate;

public class BearTest {

    @Test
    public void bearShouldNotBeAliveImmediatelyAfterCreation() {
        int weight = 3;
        Bear bear = new BlackBear(weight);

        boolean result = bear.isAlive();

        Assertions.assertFalse(result);
    }

    @Test
    public void bearShouldBeAliveIfItHasEatenWithin10DaysWhenItsNotHibernating()  {
        double weight = 3;
        int mealWeight = 4;
        TestingClock testingClock = new TestingClock();
        testingClock.setDateOfClock(LocalDate.now().withMonth(8).withDayOfMonth(20));
        Bear bear = new BlackBear(weight, testingClock);
        bear.eat(mealWeight);

        boolean result = bear.isAlive();

        Assertions.assertTrue(result);
    }

    @Test
    public void bearsWeightShouldIncreaseByMealsWeight() {
        int bearWeight = 3;
        int mealWeight = 4;
        TestingClock testingClock = new TestingClock();
        testingClock.setDateOfClock(LocalDate.now().withMonth(8).withDayOfMonth(20));
        Bear bear = new BlackBear(bearWeight, testingClock);


        bear.eat(mealWeight);

        Assertions.assertEquals(
                bearWeight + mealWeight,
                bear.getWeight()
        );
    }

    @Test
    public void bearsWeightShouldIncreaseBy75PercentOfWaterHeDrinksWhenItsNotHibernating() {
        int bearWeight = 3;
        int waterWeight = 3;
        TestingClock testingClock = new TestingClock();
        testingClock.setDateOfClock(LocalDate.now().withMonth(8).withDayOfMonth(20));
        Bear bear = new BlackBear(bearWeight, testingClock);

        bear.drink(waterWeight);

        Assertions.assertEquals(
                bearWeight + 0.75 * waterWeight,
                bear.getWeight()
        );
    }

    @Test
    public void bearsWeightShouldDecreaseBy5PercentWhenHePoops() {
        int bearWeight = 3;
       Bear bear = new BlackBear(bearWeight);

        bear.poop();

        Assertions.assertEquals(
                bearWeight * 0.95,
                bear.getWeight(),
                0.00001
        );
    }

    @Test
    public void blackBearShouldBeHibernatingBetween20thNovemberAnd15thMarch() {
        int bearWeight = 3;
        TestingClock clock = new TestingClock();
        clock.setDateOfClock(LocalDate.now().withMonth(11).withDayOfMonth(20));
        Bear bear = new BlackBear(bearWeight,clock);

        Assertions.assertTrue(bear.isHibernating());
    }
    @Test
    public void brownBearShuldBeHibernatingBetween1stDecemberAnd20thApril(){
        double bearWeight = 3;
        TestingClock clock = new TestingClock();
        Bear bear = new BrownBear(bearWeight, clock);
        clock.setDateOfClock(LocalDate.now().withMonth(12).withDayOfMonth(1));

        Assertions.assertTrue(bear.isHibernating());
    }
    @Test
    public void polarBearShuldBeHibernatingBetween5thMayAnd10thOctober(){
        double bearWeight = 3;
        TestingClock clock = new TestingClock();
        clock.setDateOfClock(LocalDate.now().withMonth(6).withDayOfMonth(20));
        Bear bear = new PolarBear(bearWeight, clock);

        Assertions.assertTrue(bear.isHibernating());
    }

    @Test
    public void whenBearIsHibernatingEatingShouldThrowBearHibernatingException(){
        int bearWeight = 3;
        TestingClock clock = new TestingClock();
        clock.setDateOfClock(LocalDate.now().withMonth(11).withDayOfMonth(20));
        Bear bear = new BlackBear(bearWeight,clock);
        assert bear.isHibernating();

        Assertions.assertThrows(BearHibernatingException.class, ()->bear.eat(7));

    }
}
