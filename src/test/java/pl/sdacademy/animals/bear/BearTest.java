package pl.sdacademy.animals.bear;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BearTest {

    @Test
    public void bearShouldBeAliveImmediatelyAfterCreation() {
        double weight = 3;
        Bear bear = new BlackBear(weight);

        boolean result = bear.isAlive();

        Assertions.assertTrue(result);
    }

    @Test
    public void bearShouldBeAliveIfItHasEatenWithin10Days() {
        double weight = 3;
        double foodWeight = 2;
        Bear bear = new BlackBear(weight);
        bear.eat(foodWeight);

        boolean result = bear.isAlive();

        Assertions.assertTrue(result);
    }

    @Test
    public void bearShouldPutOnWeightOfAmountOfEeatenFood() {
        double weight = 3;
        Bear bear = new BlackBear(weight);
        double foodWeight = 2;

        bear.eat(foodWeight);

        Assertions.assertEquals(weight + foodWeight, bear.getCurrentWeight());
    }

    @Test
    public void bearsWeightShouldIncreaseOfAmountOfThreeFourthOfWaterWeight() {
        double bearWeight = 76;
        double waterWeight = 31;
        Bear bear = new BlackBear(bearWeight);

        bear.drink(waterWeight);

        Assertions.assertEquals(bearWeight + 0.75 * waterWeight, bear.getCurrentWeight());
    }

    @Test
    public void bearsWeightShuldDecreaseOfAmountOf5PercentOfBear() {
        double bearWeight = 34;
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

        Assertions.assertEquals(bear.getCurrentWeight() >= bear.getWeight(), bear.isAlive());

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
        Bear bear = new BlackBear(bearWeight);

        bear.poop();
        Assertions.assertFalse(bear.isAlive());

        bear.eat(7);

        Assertions.assertTrue(bear.isAlive());

    }
    @Test
    public void bearShouldBeResurrectedIfIthasDrinkedAfterDeath() {
        double birthWeight = 6;
        Bear bear = new BlackBear(birthWeight);
        bear.poop();
        Assertions.assertFalse(bear.isAlive()); //tutaj upewiamy się, że miś nie żyje

        bear.drink(7);

        Assertions.assertTrue(bear.isAlive());

    }


}
