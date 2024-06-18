//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package edu.berkeley.aep;

import org.junit.Assert;
import org.junit.Test;

public class BestQuantitiesTest {
    public BestQuantitiesTest() {
    }

    @Test
    public void thousandCelsiusIsBestAmong1Celsius1Fahrenheit() {
        ScaledQuantity thousandCelsius = new ScaledQuantity(1000, Unit.CELSIUS);
        ScaledQuantity oneCelsius = new ScaledQuantity(1, Unit.CELSIUS);
        ScaledQuantity oneFahrenheit = new ScaledQuantity(1, Unit.FAHRENHEIT);
        ScaledQuantity[] quantities = new ScaledQuantity[]{thousandCelsius, oneCelsius, oneFahrenheit};
        Assert.assertEquals(thousandCelsius, BestQuantities.best(quantities));
    }

    @Test
    public void oneCelsiusIsNotBestAmongThousandFahrenheit() {
        ScaledQuantity oneCelsius = new ScaledQuantity(1, Unit.CELSIUS);
        ScaledQuantity thousandFahrenheit = new ScaledQuantity(1000, Unit.FAHRENHEIT);
        ScaledQuantity[] quantities = new ScaledQuantity[]{oneCelsius, thousandFahrenheit};
        Assert.assertNotEquals(oneCelsius, BestQuantities.best(quantities));
    }

    @Test
    public void oneCelsiusIsNotBestAmongThousandCelsius() {
        ScaledQuantity oneCelsius = new ScaledQuantity(1, Unit.CELSIUS);
        ScaledQuantity thousandCelsius = new ScaledQuantity(1000, Unit.CELSIUS);
        ScaledQuantity[] quantities = new ScaledQuantity[]{oneCelsius, thousandCelsius};
        Assert.assertEquals(thousandCelsius, BestQuantities.best(quantities));
    }
}
