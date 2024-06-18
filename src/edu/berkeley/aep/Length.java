package edu.berkeley.aep;

public class Length {
        private final double inches;

        private Length(double inches) {
            this.inches = inches;
        }

    public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Length unit = (Length) obj;
            return Double.compare(unit.inches, inches) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(inches);
        }
        public static Length fromInches(double inches) {
            return new Length(inches);
        }


        public static Length fromFeet(double feet) {
            return new Length(feet * 12);
        }

        public static Length fromYards(double yards) {
            return new Length(yards * 36);
        }

        public static Length fromMiles(double miles) {
            return new Length(miles * 63360);
        }



    }








//        public double toInches() {
//            return inches;
//        }
//
//        public double toFeet() {
//            return inches / 12;
//        }
//
//        public double toYards() {
//            return inches / 36;
//        }
//
//        public double toMiles() {
//            return inches / 63360;
//        }
