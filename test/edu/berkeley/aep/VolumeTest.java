package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VolumeTest {

    @Test
    public void oneTBSPIsThreeTSP() {
        assertEquals(Volume.fromTBSP(1), Volume.fromTSP(3));
    }

    @Test
    public void oneOunceIsTwoTBSP() {
        assertEquals(Volume.fromOunce(1), Volume.fromTBSP(2));
    }

    @Test
    public void eightOunceIsOneCup() {
        assertEquals(Volume.fromOunce(8), Volume.fromCup(1));
    }
}
