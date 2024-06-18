package edu.berkeley.aep;

public class Volume {

    private final double tsp;
//    private ConversiontTable conversionTable = new ConversionTable();

    private Volume(double tsp) {
        this.tsp = tsp;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Volume unit = (Volume) obj;
        return Double.compare(unit.tsp, tsp) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(tsp);
    }

    public static Volume fromTSP(double tsp) {
        return new Volume(tsp);
    }


    public static Volume fromTBSP(double tbsp) {
//        var tsp = conversionTable.convert(tbsp, 'tbsp');
        return new Volume(tbsp * 3);
    }

    public static Volume fromOunce(double ounce) {
        return new Volume(ounce * 6);
    }

    public static Volume fromCup(double cup) {
        return new Volume(cup * 48);
    }

}
