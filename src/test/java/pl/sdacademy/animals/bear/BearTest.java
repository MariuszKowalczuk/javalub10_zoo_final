package pl.sdacademy.animals.bear;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pl.sdacademy.animals.time.TestingClock;

import java.time.LocalDate;

public class BearTest {

    @Test
    public void bearShouldBeAliveImmediatelyAfterCreation() {
        double weight = 3;
        Bear bear = new BlackBear(weight);

        boolean result = bear.isAlive();

        Assertions.assertTrue(result);
    }

    @Test

    public void bearShouldBeAliveIfItHasEatenWithin10DaysWhenItsNotHibernating() {
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

    public void bearShouldPutOnWeightOfAmountOfEeatenFood() {
        double weight = 3;
        TestingClock testingClock = new TestingClock();
        testingClock.setDateOfClock(LocalDate.now().withMonth(8).withDayOfMonth(20));
        Bear bear = new BlackBear(weight, testingClock);
        int foodWeight = 2;

        bear.eat(foodWeight);

        Assertions.assertEquals(weight + foodWeight, bear.getCurrentWeight());
    }

    @Test
    public void bearsWeightShouldIncreaseOfAmountOfThreeFourthOfWaterWeight() {
        double bearWeight = 76;
        double waterWeight = 31;
        TestingClock testingClock = new TestingClock();
        testingClock.setDateOfClock(LocalDate.now().withMonth(8).withDayOfMonth(20));
        Bear bear = new BlackBear(bearWeight, testingClock);

        bear.drink(waterWeight);

        Assertions.assertEquals(bearWeight + 0.75 * waterWeight, bear.getCurrentWeight());
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
                bear.getCurrentWeight()
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
                bear.getCurrentWeight()
        );
    }

    @Test
    public void bearsWeightShouldDecreaseBy5PercentWhenHePoops() {
        double bearWeight = 10;

        Bear bear = new BlackBear(bearWeight);

        bear.poop();


        Assertions.assertEquals(bearWeight - bearWeight * 0.05, bear.getCurrentWeight());
    }

    @Test
    public void bearShouldBeAliveIfHisCurrentWeightIsGraterOrEqualHisBirthWEight() {
        double bearWeight = 23;
        Bear bear = new BlackBear(bearWeight);
        double currentWeight = 25;

        Assertions.assertEquals(currentWeight >= bearWeight, bear.isAlive());

    }

    @Test
    public void bearShouldBeAliveIfHisCurrentWeightIsGraterOrEqualHisBirthWEightAFterCreation() {
        double bearWeight = 23;
        Bear bear = new BlackBear(bearWeight);

        Assertions.assertEquals(bear.getCurrentWeight() >= bear.getBirthWeight(), bear.isAlive());

    }

    @Test
    public void bearShouldBeDeadIfHisCurrentWeightIsLessHisBirthWEightAfterPooping() {
        double bearWeight = 23;
        Bear bear = new BlackBear(bearWeight);


        bear.poop();

        Assertions.assertFalse(bear.isAlive());


    }

    @Test

    public void bearShouldBeResurrectedIfIthasEatenAfterDeath() {
        double bearWeight = 6;
        TestingClock testingClock = new TestingClock();
        testingClock.setDateOfClock(LocalDate.now().withMonth(8).withDayOfMonth(20));
        Bear bear = new BlackBear(bearWeight, testingClock);
        bear.poop();
        Assertions.assertFalse(bear.isAlive());

        bear.eat(7);

        Assertions.assertTrue(bear.isAlive());

    }

    @Test
    public void bearShouldBeResurrectedIfIthasDrinkedAfterDeath() {
        double birthWeight = 6;
        TestingClock testingClock = new TestingClock();
        testingClock.setDateOfClock(LocalDate.now().withMonth(8).withDayOfMonth(20));
        Bear bear = new BlackBear(birthWeight, testingClock);
        bear.poop();
        Assertions.assertFalse(bear.isAlive());

        bear.drink(7);

        Assertions.assertTrue(bear.isAlive());

    }

    @Test
    public void bearShuldNotBeResurrectedIfThhasntEatenEnough() {
        double birthWeight = 6;
        TestingClock testingClock = new TestingClock();
        testingClock.setDateOfClock(LocalDate.now().withMonth(8).withDayOfMonth(20));
        Bear bear = new BlackBear(birthWeight, testingClock);
        bear.poop();
        bear.poop();
        bear.poop();
        Assertions.assertFalse(bear.isAlive());

        bear.drink(1);

        Assertions.assertFalse(bear.isAlive());
    }



    @Test
    public void blackBearShouldBeHibernatingBetween20thNovemberAnd15thMarch() {
        int bearWeight = 3;
        TestingClock clock = new TestingClock();
        clock.setDateOfClock(LocalDate.now().withMonth(11).withDayOfMonth(20));
        Bear bear = new BlackBear(bearWeight, clock);

        Assertions.assertTrue(bear.isHibernating());
    }

    @Test
    public void brownBearShuldBeHibernatingBetween1stDecemberAnd20thApril() {
        double bearWeight = 3;
        TestingClock clock = new TestingClock();
        Bear bear = new BrownBear(bearWeight, clock);
        clock.setDateOfClock(LocalDate.now().withMonth(12).withDayOfMonth(1));

        Assertions.assertTrue(bear.isHibernating());
    }

    @Test
    public void polarBearShuldBeHibernatingBetween5thMayAnd10thOctober() {
        double bearWeight = 3;
        TestingClock clock = new TestingClock();
        clock.setDateOfClock(LocalDate.now().withMonth(6).withDayOfMonth(20));
        Bear bear = new PolarBear(bearWeight, clock);

        Assertions.assertTrue(bear.isHibernating());
    }

    @Test
    public void whenBearIsHibernatingEatingShouldThrowBearHibernatingException() {
        int bearWeight = 3;
        TestingClock clock = new TestingClock();
        clock.setDateOfClock(LocalDate.now().withMonth(11).withDayOfMonth(20));
        Bear bear = new BlackBear(bearWeight, clock);
        assert bear.isHibernating();

        Assertions.assertThrows(BearHibernatingException.class, () -> bear.eat(7));

    }
    @Test
    public void whenBearIsDeadEatingShouldntMakeHimAlive(){
        int bearWeight = 3;
        TestingClock clock = new TestingClock();
        clock.setDateOfClock(LocalDate.now().withMonth(5).withDayOfMonth(5));
        Bear bear = new BlackBear(bearWeight, clock);
        bear.poop();

        bear.eat(5);

        Assertions.assertFalse(bear.isAlive());




    }


}
