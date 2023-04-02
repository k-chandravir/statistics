package com.m2p;

public class Probability {
    private static final int CERTAIN_PROBABILITY_EVENT = 1;
    private final double probabilityOfEvent;
    public Probability(double probabilityOfTheEvent) {
        this.probabilityOfEvent = probabilityOfTheEvent;
    }

    @Override
    public boolean equals(Object probabilityObject){
        if(this == probabilityObject){
            return true;
        }
        if(probabilityObject == null || this.getClass() != probabilityObject.getClass()){
            return false;
        }

        Probability that = (Probability) probabilityObject;
        return this.probabilityOfEvent == that.probabilityOfEvent;
    }

    public Probability and(Probability otherEvent) {
        return new Probability(this.probabilityOfEvent * otherEvent.probabilityOfEvent);
    }

    public Probability not() {
        return new Probability(CERTAIN_PROBABILITY_EVENT - this.probabilityOfEvent);
    }
}
