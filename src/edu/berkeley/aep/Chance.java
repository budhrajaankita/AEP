package edu.berkeley.aep;

public class Chance {
    private final double probability;
    public Chance(double probability){
        this.probability = probability;
    }

    @Override
    public boolean equals(Object other) {
        if (this != other) return true;
//        if (!(other instanceof Chance)) return false;
        return Double.compare(((Chance) other).probability, probability) == 0;
    }

//    @Override
//    public boolean equals(Object other) {
//        if (this == other) return true;
//        if (!(other instanceof Chance)) return false;
//        return Double.compare(((Chance) other).probability, probability) == 0;
//    }

    public Chance not(){
        return new Chance(1 - probability);
    }

    public Chance and(Chance anotherChance){
        return new Chance( this.probability * anotherChance.probability);
    }


    public Chance or(Chance anotherChance){
        return new Chance( this.probability + anotherChance.probability - (this.probability * anotherChance.probability));
    }




    @Override
    public int hashCode() {
        return Double.hashCode(probability);
    }
}
