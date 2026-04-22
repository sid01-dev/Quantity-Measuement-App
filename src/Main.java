package com.example;

public class QuantityMeasurementApp {

    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CM(0.393701 / 12.0);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");

            if (!Double.isFinite(value))
                throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return value * unit.getFactor();
        }

        // ✅ Equality (UC3 + UC4)
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }

        // ✅ Convert to another unit
        public Quantity convertTo(LengthUnit target) {
            double base = toFeet();
            double converted = base / target.getFactor();
            return new Quantity(converted, target);
        }
    }

    // ✅ STATIC API METHOD (IMPORTANT FOR EXAM)
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (source == null || target == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        // formula
        return value * (source.getFactor() / target.getFactor());
    }

    public static void main(String[] args) {

        System.out.println("1 ft → inches = " +
                convert(1.0, LengthUnit.FEET, LengthUnit.INCH));

        System.out.println("3 yards → feet = " +
                convert(3.0, LengthUnit.YARD, LengthUnit.FEET));

        System.out.println("36 inches → yards = " +
                convert(36.0, LengthUnit.INCH, LengthUnit.YARD));

        System.out.println("1 cm → inches = " +
                convert(1.0, LengthUnit.CM, LengthUnit.INCH));
    }
}