package pl.sdacademy.animals.bear;


import java.time.LocalDate;


import pl.sdacademy.animals.time.Clock;

public class PolarBear extends Bear {


    public PolarBear(double weight) {
        super(weight);
    }

    public PolarBear(double weight, Clock clock) {
        super(weight, clock);
    }

    @Override
    boolean isHibernating() {
        LocalDate today = LocalDate.from(clock.getCurrentDate());
        LocalDate fourthOfMay = today.withMonth(5).withDayOfMonth(4);
        LocalDate eleventhOCtober = today.withMonth(10).withDayOfMonth(11);
        return today.isBefore(eleventhOCtober) && today.isAfter(fourthOfMay);
    }
}
