package edu.berkeley.aep;

// Understands how to convert between different measurement scales
public enum Unit {
    INCHES(1, UnitType.LENGTH, 0),
    FEET(12, UnitType.LENGTH, 0),
    YARDS(36, UnitType.LENGTH, 0),
    MILES(36 * 1760, UnitType.LENGTH, 0),
    CUP(48, UnitType.VOLUME, 0),
    OZ(6, UnitType.VOLUME, 0),
    TBSP(3, UnitType.VOLUME, 0),
    TSP(1, UnitType.VOLUME, 0),
    FAHRENHEIT(5, UnitType.TEMPERATURE, 32),
    CELSIUS(9, UnitType.TEMPERATURE, 0);
    private final int inBaseUnits;
    private final UnitType type;
    private final int offset;

    public boolean isComparableTo(Unit other) {
        return type == other.type;
    }

    private enum UnitType {LENGTH, VOLUME, TEMPERATURE}

    Unit(int inBaseUnits, UnitType type, int offset) {
        this.inBaseUnits = inBaseUnits;
        this.type = type;
        this.offset = offset;
    }

    public int convertTo(int size, Unit unit) {
        if (type != unit.type) {
            throw new RuntimeException("Tried to convert between units of different types");
        }
        return (size - offset) * inBaseUnits / unit.inBaseUnits + unit.offset;
    }
}