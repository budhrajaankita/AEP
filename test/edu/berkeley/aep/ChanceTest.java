//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package edu.berkeley.aep;

import org.junit.Assert;
import org.junit.Test;

public class ChanceTest {
    public ChanceTest() {
    }

    @Test
    public void twoCoinTossChancesShouldBeEqualToEachOther() {
        Chance coinToss = new Chance(0.5);
        Chance anotherCoinToss = new Chance(0.5);
        Assert.assertEquals(coinToss, anotherCoinToss);
    }

    @Test
    public void complementOfDieThrowShouldBeOneMinusProbability() {
        Chance dieThrow = new Chance(0.25);
        Assert.assertEquals(new Chance(0.75), dieThrow.not());
    }

    @Test
    public void probabilityOfTwoCoinTossesBothBeingHeadsShouldBeOneQuarter() {
        Chance coinToss = new Chance(0.5);
        Chance probabilityOfTwoHeads = new Chance(0.25);
        Assert.assertEquals(probabilityOfTwoHeads, coinToss.and(coinToss));
    }

    @Test
    public void probabilityOfTwoCoinTossesYieldingAtLeastOneHeadShouldBeThreeQuarters() {
        Chance coinToss = new Chance(0.5);
        Chance probabilityOfAtLeastOneHead = new Chance(0.75);
        Assert.assertEquals(probabilityOfAtLeastOneHead, coinToss.or(coinToss));
    }
}
