package pl.sdacademy.animals.bear;

import pl.sdacademy.animals.Animal;
import pl.sdacademy.animals.time.Clock;
import pl.sdacademy.animals.time.DateTimeClock;


public abstract class Bear implements Animal {


        

    private double BirthWeight;
    private double currentWeight;
    private boolean isAlive;
    protected Clock clock;

    public Bear(double ) {
        this.BirthWeight = BirthWeight;
        this.isAlive = false;
        this.currentWeight  = this.BirthWeight;
        this.isAlive = false;
        this.clock = new DateTimeClock();
    }

    public Bear(double BirthWeight, Clock clock) {
        this.BirthWeight = BirthWeight;
        this.isAlive = false;
        this.currentWeight  = this.BirthWeight;
        this.isAlive = false;        
        this.clock = clock;

    }

    @Override
    public boolean isAlive() {

        return isAlive = getCurrentWeight() >= getBirthWeight();
        //return isAlive;

    }



 

    

    public void eat(int weight){

            if (isHibernating()){
                throw new BearHibernatingException();
            }



        this.currentWeight += weight;
        isAlive = true;
    }

        @Override
    public double getBirthWeight() {
        return BirthWeight;
    }

        public void drink ( double waterWeight){
            if (isHibernating()){
                throw new BearHibernatingException();
            }
            this.currentWeight += 0.75 * waterWeight;
        }

        public void poop () {
            this.currentWeight *= 0.95;
        }

        abstract boolean isHibernating();


    public double getCurrentWeight() {
        return currentWeight;
    }
}
