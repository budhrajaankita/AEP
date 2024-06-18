package edu.berkeley.aep;

import org.junit.Test;
import static org.junit.Assert.*;

// 12 inches = 1 feet
// 3 feet = 1 yard
// 1760 yds = 1 mile

// understands a unit of measurement and converts it to another unit of length (US standard unit)
public class LengthTest {

        @Test
        public void twelveInchesIsOneFoot() {
            assertEquals(Length.fromInches(12), Length.fromFeet(1));
        }

        @Test
        public void threeFootIsOneYard() {
            assertEquals(Length.fromFeet(3), Length.fromYards(1));
        }

        @Test
        public void oneMileIsOneSevenSixZeroYards() {
            assertEquals(Length.fromYards(1760), Length.fromMiles(1));
        }


    }





//        @Test
//        public void testConversion() {
//            Measure oneFoot = Measure.fromFeet(1);
//            assertEquals(12, oneFoot.toInches());
//
//            Measure oneYard = Measure.fromYards(1);
//            assertEquals(3, oneYard.toFeet());
//
//            Measure oneMile = Measure.fromMiles(1);
//            assertEquals(1760, oneMile.toYards());
//        }
