package pl.sdacademy.animals.bear;

import pl.sdacademy.animals.time.Clock;

import java.time.LocalDate;

public class BlackBear extends Bear {
    public BlackBear(double weight) {
        super(weight);
    }

    public BlackBear(double weight, Clock clock) {
        super(weight, clock);
    }

    @Override
    boolean isHibernating() {
        LocalDate today = LocalDate.from(clock.getCurrentDate());
        LocalDate nineteenthNovember = today.withMonth(11).withDayOfMonth(19);
        LocalDate sixteenthMarch = today.withMonth(03).withDayOfMonth(16);
        return today.isAfter(nineteenthNovember) || today.isBefore(sixteenthMarch);
    }
}