package pl.sdacademy.animals.bear;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BearTest {

    @Test
    public void bearShouldNotBeAliveImmediatelyAfterCreation() {
        int weight = 3;
        Bear bear = new BlackBear(weight);

        boolean result = bear.isAlive();

        Assertions.assertFalse(result);
    }

    @Test
    public void bearShouldBeAliveIfItHasEatenWithin10Days() {
        int weight = 3;
        Bear bear = new BlackBear(weight);
        bear.eat();

        boolean result = bear.isAlive();

        Assertions.assertTrue(result);
    }
}
