//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package edu.berkeley.aep;

public class BestQuantities {
    public BestQuantities() {
    }

    static Bestable best(Bestable... quantities) {
        Bestable bestQuantity = quantities[0];
        Bestable[] var2 = quantities;
        int var3 = quantities.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Bestable i = var2[var4];
            if (i.isBetterThan(bestQuantity)) {
                bestQuantity = i;
            }
        }

        return bestQuantity;
    }
}
