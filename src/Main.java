package com.example;

public class QuantityMeasurementApp {

    // ENUM with extended units
    enum LengthUnit {
        FEET(1.0),

        INCH(1.0 / 12.0),        // 1 inch = 1/12 feet

        YARD(3.0),              // 1 yard = 3 feet

        CM(0.393701 / 12.0);    // 1 cm = 0.393701 inch → convert to feet

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double toFeet(double value) {
            return value * conversionFactor;
        }
    }

    // SAME Quantity class (NO CHANGE)
    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }
    }

    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.YARD);
        Quantity q2 = new Quantity(3.0, LengthUnit.FEET);

        System.out.println("1 yard == 3 feet → " + q1.equals(q2));

        Quantity q3 = new Quantity(1.0, LengthUnit.CM);
        Quantity q4 = new Quantity(0.393701, LengthUnit.INCH);

        System.out.println("1 cm == 0.393701 inch → " + q3.equals(q4));
    }
}