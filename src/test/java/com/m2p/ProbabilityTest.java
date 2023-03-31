package com.m2p;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProbabilityTest {
    @Test
    void toReturnZeroPointFiveWhenHeadIsInput(){
        Probability headProbability = new Probability(0.5);

        Probability tailProbability = new Probability(0.5);

        assertThat(headProbability, is(equalTo(tailProbability)));
    }

    @Test
    void toReturnZeroPointZeroEightWhenProbabilityOfHeadIsZeroPointFiveAndProbabilityOfOneInDieIsZeroPointOneSix(){
        Probability headProbability = new Probability(0.5);
        Probability onesProbability = new Probability(0.16);
        Probability probabilityOfHeadAndOneTogether = new Probability(0.08);

        assertThat(headProbability.probabilityOfTwoEventsTogether(onesProbability), is(equalTo(probabilityOfHeadAndOneTogether)));
    }
    @Test
    void toReturnOneWhenProbabilityOfEventOneIsOneAndProbabilityOfEventTwoIsOne(){
        Probability eventOne = new Probability(1);
        Probability eventTwo = new Probability(1);
        Probability probabilityOfHeadAndOneTogether = new Probability(0.08);

        assertThat(eventOne.probabilityOfTwoEventsTogether(eventTwo), is(equalTo(probabilityOfHeadAndOneTogether)));
    }
}
