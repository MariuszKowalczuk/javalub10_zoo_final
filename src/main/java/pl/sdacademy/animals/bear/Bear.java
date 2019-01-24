package pl.sdacademy.animals.bear;

import pl.sdacademy.animals.Animal;
import pl.sdacademy.animals.time.Clock;
import pl.sdacademy.animals.time.DateTimeClock;


public abstract class Bear implements Animal {

    private double weight;
    private boolean isAlive;
    protected Clock clock;

    public Bear(double weight) {
        this.weight = weight;
        this.isAlive = false;
        this.clock = new DateTimeClock();
    }

    public Bear(double weight, Clock clock) {
        this.weight = weight;
        this.isAlive = false;
        this.clock = clock;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    public void eat(int weight){

            if (isHibernating()){
                throw new BearHibernatingException();
            }



        this.weight += weight;
        isAlive = true;
    }

        @Override
        public double getWeight () {
            return weight;
        }

        public void drink ( double waterWeight){
            if (isHibernating()){
                throw new BearHibernatingException();
            }
            this.weight += 0.75 * waterWeight;
        }

        public void poop () {
            this.weight *= 0.95;
        }

        abstract boolean isHibernating();


}
