package edu.berkeley.aep;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AirportTest {

    static Airport f = new Airport("F");
    static Airport a = new Airport("A");
    static Airport b = new Airport("B");

    static {
        a.addDestination(f);
        b.addDestination(a);
    }

    @Test
    public void AirportCanReachItself() {
        Airport a = new Airport("A");
        assertTrue(a.canReach(a));
    }

    @Test
    public void airportWithSingleDestinationCanReachIt() {
        Airport f = new Airport("F");
        ArrayList<Airport> destinationsForA = new ArrayList<Airport>();
        destinationsForA.add(f);
        Airport a = new Airport("A", destinationsForA);
        assertEquals(true, a.canReach(f));

    }

    @Test
    public void airportWithMultipleDestinationsCanReachToEachOfThose() {
        Airport a = new Airport("A");
        Airport c = new Airport("C");
        ArrayList<Airport> destinationsForB = new ArrayList<Airport>();
        destinationsForB.add(a);
        destinationsForB.add(c);
        Airport b = new Airport("B", destinationsForB);
        assertEquals(true, b.canReach(a));
        assertEquals(true, b.canReach(c));
    }


    @Test
    public void anAirportShouldBeAbleToReachOtherAirportsThroughIntermediariesIfThereIsRoute(){
        Airport d = new Airport("D");
        ArrayList<Airport> destinationsForA = new ArrayList<Airport>();
        destinationsForA.add(d);
        Airport a = new Airport("A", destinationsForA);
        Airport c = new Airport("C");
        ArrayList<Airport> destinationsForB = new ArrayList<Airport>();
        destinationsForB.add(a);
        destinationsForB.add(c);
        Airport b = new Airport("B", destinationsForB);
        assertEquals(true, b.canReach(d));

    }

    @Test
    public void anAirportShouldNotBeAbleToReachOtherAirportsThroughIntermediariesIfThereIsNoRoute(){
        Airport d = new Airport("D");
        Airport e = new Airport("E");
        ArrayList<Airport> destinationsForA = new ArrayList<Airport>();
        destinationsForA.add(d);
        Airport a = new Airport("A", destinationsForA);
        Airport c = new Airport("C");
        ArrayList<Airport> destinationsForB = new ArrayList<Airport>();
        destinationsForB.add(a);
        destinationsForB.add(c);
        Airport b = new Airport("B", destinationsForB);
        assertEquals(false, b.canReach(e));

    }

    @Test
    public void numberOfHopsToItselfShouldBeZero(){
        Airport a = new Airport("A");
        assertEquals(0, a.countHops(a));
    }

    @Test
    public void numberOfHopsToImmediateNeighbourShouldBeOne(){
        Airport a = new Airport("A");
        Airport c = new Airport("C");
        ArrayList<Airport> destinationsForB = new ArrayList<Airport>();
        destinationsForB.add(a);
        destinationsForB.add(c);
        Airport b = new Airport("B", destinationsForB);
        assertEquals(1, b.countHops(a));
        assertEquals(1, b.countHops(a));
        System.out.println(b.countHops(a));

    }

    @Test
    public void numberofHopsForUnreachableAirportShouldbeMinusOne(){
        Airport b = new Airport("B");
        ArrayList<Airport> destinationsForH = new ArrayList<Airport>();
        destinationsForH.add(b);
        Airport h = new Airport("H", destinationsForH);
        assertEquals(Airport.UNREACHABLE, b.countHops(h));
    }

    @Test
    public void numberofHopsFromAirportCToAirportEWithMultiplePathsShouldBeOne() {
        Airport c = new Airport("C");
        Airport d = new Airport("D");
        Airport e = new Airport("E");

        c.addDestination(e);
        c.addDestination(d);
        d.addDestination(e);
        System.out.println(b.countHops(a));

        assertEquals(1, c.countHops(e));
    }

    @Test
    public void AirportCostToItselfShouldBeZero() {
        Airport a = new Airport("A");
        assertEquals(0, a.getLeastCostToDestination(a));
    }

    @Test
    public void leastAirportCostToUnreachableAirportShouldBeMinusOne() {
        Airport a = new Airport("A");
        Airport g = new Airport("G");
        assertEquals(-1, a.getLeastCostToDestination(g));
    }

    @Test
    public void lowestCostFromAirportAtoFis72() {
        Airport f = new Airport("F");
        Airport a = new Airport("A");
        a.addDestination(f, 72);
        assertEquals(72, a.getLeastCostToDestination(f));
    }


    @Test
    public void lowestCostFromAirportCtoEis205() {
        Airport c = new Airport("C");
        Airport e = new Airport("E");
        Airport d = new Airport("D");

        c.addDestination(e, 749);
        c.addDestination(d, 126);
        d.addDestination(e, 79);
        assertEquals(205, c.getLeastCostToDestination(e));
    }
//
//    Queue: [C]
//    HashMap: { C: 0 }
//
//    Queue: [E, D]
//    HashMap: { C: 0, E: 1, D: 1 }
//
//    Queue: [D]
//    HashMap: { C: 0, E: 1, D: 1 } found


//    @Test
//    public void numberofHopsFromAirportBtoAirportFisTwo(){
//        Airport f = new Airport("F");
//        Airport a = new Airport("A");
//        ArrayList<Airport> destinationsForB = new ArrayList<Airport>();
//        destinationsForB.add(a);
//        destinationsForB.add(f);
//        Airport b = new Airport("B", destinationsForB);
//        assertEquals(2, b.countHops(f));
//    }

    @Test
    public void numberofHopsFromAirportBToAirportEWithMultiplePathsShouldBeTwo() {
        Airport b = new Airport("B");
        Airport c = new Airport("C");
        Airport d = new Airport("D");
        Airport e = new Airport("E");

        b.addDestination(c);
        c.addDestination(d);
        c.addDestination(e);
        d.addDestination(e);

//        System.out.println(b.countHops(e));

        assertEquals(2, b.countHops(e));
    }

    @Test
    public void numberofHopsFromAirportBtoAirportFisTwo(){
        Airport f = new Airport("F");
        Airport a = new Airport("A");
        a.addDestination(f);
        Airport b = new Airport("B");
        b.addDestination(a);
        assertEquals(2, b.countHops(f));
    }


    @Test
    public void numberofHopsFromAirportCtoAirportEisEitherOneorTwo(){
        Airport e = new Airport("E");
        ArrayList<Airport> destinationsForC = new ArrayList<Airport>();
        ArrayList<Airport> destinationsForD = new ArrayList<Airport>();
        destinationsForC.add(e);
        destinationsForD.add(e);
        Airport c = new Airport("C", destinationsForC);
        Airport d = new Airport("D", destinationsForD);
        destinationsForC.add(d);

        int hops = c.countHops(e);
//        assertTrue(hops == 1 || hops == 2 );
        assertTrue(hops == 1 );
    }

}