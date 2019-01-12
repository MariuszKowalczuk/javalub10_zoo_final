package pl.sdacademy.animals.bear;

import pl.sdacademy.animals.Animal;


public abstract class Bear implements Animal {

    private double BirthWeight;
    private boolean isAlive;
    private double currentWeight;

    public Bear(double BirthWeight) {
        this.BirthWeight = BirthWeight;
        this.isAlive = false;
        this.currentWeight  = this.BirthWeight;
    }

    @Override
    public boolean isAlive() {

        return isAlive = getCurrentWeight() >= getBirthWeight();
        //return isAlive;

    }


    public void eat(double foodWeight) {
        this.currentWeight += foodWeight;

    }

    public void drink(double waterWeight) {
        this.currentWeight += waterWeight * 0.75;
    }

    public void poop(){
        this.currentWeight *= 0.95;
    }

    @Override
    public double getBirthWeight() {
        return BirthWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }
}
