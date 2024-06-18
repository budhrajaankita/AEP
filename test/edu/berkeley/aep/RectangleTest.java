package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.*;
// understands a four-sided figure with sides at right angele
public class RectangleTest {
    @Test
    public void rectangleWithLength6AndWidth4ShouldHaveArea24(){
        Rectangle newRectangle =  new Rectangle(6, 4);
        assertEquals(24, newRectangle.getArea());
    }
}