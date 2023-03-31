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
}
