package pl.sdacademy.animals.time;

import java.time.LocalDate;

public class TestingClock implements Clock {

    LocalDate dateOfClock;

    @Override
    public LocalDate getCurrentDate() {
        return dateOfClock;
    }

    public void setDateOfClock(LocalDate date) {
        this.dateOfClock = date;
    }

}
