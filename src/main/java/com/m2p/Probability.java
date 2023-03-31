package com.m2p;

public class Probability {
    private final double probabilityOfEvent;
    public Probability(double probabilityOfTheEvent) {
        this.probabilityOfEvent = probabilityOfTheEvent;
    }

    @Override
    public boolean equals(Object probabilityObject){
        if(this == probabilityObject){
            return true;
        }
        if(this.getClass() != probabilityObject.getClass()){
            return false;
        }

        Probability that = (Probability) probabilityObject;
        return this.probabilityOfEvent == that.probabilityOfEvent;
    }

    public Probability probabilityOfTwoEventsTogether(Probability onesProbability) {
        return new Probability(this.probabilityOfEvent * onesProbability.probabilityOfEvent);
    }
}
