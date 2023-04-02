package com.m2p;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class ProbabilityTest {
    public static Probability probabilityOfHeadInACoinToss;
    public static Probability probabilityOfTailInACoinToss;
    public static Probability probabilityOfCertainEvent;
    public static Probability probabilityOfImpossibleEvent;
    public static Probability quarterProbability;
    public static Probability threeQuarterProbability;

    @BeforeAll
    static void setUp(){
        probabilityOfHeadInACoinToss = new Probability(0.5);
        probabilityOfTailInACoinToss = new Probability(0.5);
        probabilityOfCertainEvent = new Probability(1);
        probabilityOfImpossibleEvent = new Probability(0);
        quarterProbability = new Probability(0.25);
        threeQuarterProbability = new Probability(0.75);
    }

    @Nested
    class ProbabilityEquality{
        @Test
        void toReturnZeroPointFiveWhenHeadIsInput(){
            assertThat(probabilityOfHeadInACoinToss, is(equalTo(probabilityOfTailInACoinToss)));
        }

        @Test
        void toCheckTheEqualityWhenProbabilityOfHeadInACoinTossIsComparedToGettingOneInADieRoll(){
            Probability probabilityOfOneInADieRoll = new Probability(0.16);

            assertThat(probabilityOfHeadInACoinToss, is(not(equalTo(probabilityOfOneInADieRoll))));
        }

        @Test
        void toCheckEqualityWhenTheProbabilityOfHeadInACoinTossIsComparedToANullValue(){
            assertThat(probabilityOfHeadInACoinToss, is(not(equalTo(null))));
        }

        @Test
        void toCheckTheEqualityWhenTheProbabilityOfHeadInACoinTossIsComparedToAPrimitiveValue(){
            double probabilityOfATailInACoinToss = 0.5;

            assertThat(probabilityOfHeadInACoinToss, is(not(equalTo(probabilityOfATailInACoinToss))));
        }
    }

    @Nested
    class And{
        @Test
        void toGetACertainEventWhenTwoCertainEventsAreHappeningTogether(){
            assertThat(probabilityOfCertainEvent.and(probabilityOfCertainEvent), is(equalTo(probabilityOfCertainEvent)));
        }

        @Test
        void toGetAQuarterProbabilityWhenTwoHeadsAreToHappenInTwoCoinTosses(){
            assertThat(probabilityOfHeadInACoinToss.and(probabilityOfHeadInACoinToss), is(equalTo(quarterProbability)));
        }

        @Test
        void toReturnZeroWhenNeitherOfTheTwoEventsOccurring(){
            assertThat(probabilityOfImpossibleEvent.and(probabilityOfImpossibleEvent), is(equalTo(probabilityOfImpossibleEvent)));
        }
    }

    @Nested
    class Not{
        @Test
        void toReturnAnImpossibleEventWhenACertainEventIsNotHappening(){
            assertThat(probabilityOfCertainEvent.not(), is(equalTo(probabilityOfImpossibleEvent)));
        }

        @Test
        void toReturnAQuarterProbabilityWhenAThreeQuarterProbabilityIsNotHappening(){
            assertThat(quarterProbability.not(), is(equalTo(threeQuarterProbability)));
        }
    }

    @Nested
    class Or{
        @Test
        void toGetACertainEventWhenEitherCertainOrImpossibleEventsHappen(){
            assertThat(probabilityOfCertainEvent.or(probabilityOfImpossibleEvent), is(equalTo(probabilityOfCertainEvent)));
        }

    }

}
