//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package edu.berkeley.aep;

public class ArithmeticQuantity extends ScaledQuantity {
    public ArithmeticQuantity(int size, Unit unit) {
        super(size, unit);
    }

    public ScaledQuantity add(ScaledQuantity other) {
        int otherSize = other.unit.convertTo(other.size, this.unit);
        return new ArithmeticQuantity(this.size + otherSize, this.unit);
    }
}
