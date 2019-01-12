package pl.sdacademy.animals.bear;

import pl.sdacademy.animals.Animal;


public abstract class Bear implements Animal {

    private double weight;
    private boolean isAlive;
    private double currentWeight;

    public Bear(double weight) {
        this.weight = weight;
        this.isAlive = false;
        this.currentWeight  = this.weight;
    }

    @Override
    public boolean isAlive() {

        return isAlive = getCurrentWeight() >= getWeight();
        //return isAlive;

    }


    public void eat(double foodWeight) {
        this.currentWeight += foodWeight;

    }

    public void drink(double waterWeight) {
        this.currentWeight += waterWeight * 0.75;
    }

    public void poop(){
        this.currentWeight -= this.currentWeight*0.05;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }
}
