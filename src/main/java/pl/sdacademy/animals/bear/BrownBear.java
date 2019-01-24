package pl.sdacademy.animals.bear;


import pl.sdacademy.animals.time.Clock;

import java.time.LocalDate;

public class BrownBear extends Bear {
    public BrownBear(int weight) {
        super(weight);
    }

    public BrownBear(double weight, Clock clock) {
        super(weight, clock);
    }

    @Override
    boolean isHibernating() {
        LocalDate today = LocalDate.from(clock.getCurrentDate());
        LocalDate the30thNovember = today.withMonth(11).withDayOfMonth(30);
        LocalDate the21thApril = today.withMonth(4).withDayOfMonth(21);
        return today.isAfter(the30thNovember) || today.isBefore(the21thApril);

    }
}
