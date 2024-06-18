package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTest {
   @Test
    public void squareofSide5hasArea25(){
        Rectangle newRectangle =  new Rectangle(5, 5);
        assertEquals(25, newRectangle.getArea());
    }

//    @Test
//    public void squareofSide5hasArea25(){
//        Square newSquare =  new Square(5);
//        assertEquals(25, newSquare.getArea());
//    }

}