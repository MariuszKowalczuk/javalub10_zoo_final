package pl.sdacademy.animals.time;

import java.time.LocalDate;

public class DateTimeClock implements Clock {

    @Override
    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
