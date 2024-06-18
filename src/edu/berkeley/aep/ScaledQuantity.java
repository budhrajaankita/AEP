//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package edu.berkeley.aep;

public class ScaledQuantity implements Bestable<ScaledQuantity> {
    protected final int size;
    protected final Unit unit;

    public ScaledQuantity(int size, Unit unit) {
        this.size = size;
        this.unit = unit;
    }

    public String toString() {
        int var10000 = this.size;
        return "" + var10000 + " " + String.valueOf(this.unit);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other instanceof ScaledQuantity) {
            ScaledQuantity otherQuantity = (ScaledQuantity)other;
            if (!this.isComparableTo(otherQuantity)) {
                return false;
            } else {
                return otherQuantity.unit.convertTo(otherQuantity.size, this.unit) == this.size;
            }
        } else {
            return false;
        }
    }

    private boolean isComparableTo(ScaledQuantity other) {
        return this.unit.isComparableTo(other.unit);
    }

    public boolean isBetterThan(ScaledQuantity other) {
        double otherSize = (double)other.unit.convertTo(other.size, this.unit);
        return (double)this.size > otherSize;
    }
}
