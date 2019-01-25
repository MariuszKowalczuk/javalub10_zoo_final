package pl.sdacademy.animals.bear;

import pl.sdacademy.animals.Animal;
import pl.sdacademy.animals.time.Clock;
import pl.sdacademy.animals.time.DateTimeClock;


public abstract class Bear implements Animal {


    private double birthWeight;
    private double currentWeight;
    private boolean vitality;
    protected Clock clock;

    public Bear(double birthWeight) {
        this.birthWeight = birthWeight;
        this.vitality = true;
        this.currentWeight = this.birthWeight;
        this.clock = new DateTimeClock();
    }
//konstruktor z dependency injection, do testów
    public Bear(double BirthWeight, Clock clock) {
        this.birthWeight = BirthWeight;
        this.vitality = true;
        this.currentWeight = this.birthWeight;
        this.clock = clock;
    }
    @Override
    public boolean isAlive() {
        return vitality = getCurrentWeight() >= getBirthWeight();
    }

    public void eat(int weight) {
        if (isHibernating()) {
            throw new BearHibernatingException();
        }
        this.currentWeight += weight;
        vitality = true;
    }



    public void drink(double waterWeight) {
        if (isHibernating()) {
            throw new BearHibernatingException();
        }
        this.currentWeight += 0.75 * waterWeight;
    }

    public void poop() {
        this.currentWeight *= 0.95;
    }
    @Override
    public double getBirthWeight() {
        return birthWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    abstract boolean isHibernating();
}
