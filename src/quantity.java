package com.example;

public class QuantityMeasurementApp {

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

        // Delegate conversion to unit
        private double toBase() {
            return unit.toBase(value);
        }

        // Convert to another unit
        public Quantity convertTo(LengthUnit target) {
            double base = toBase();
            double converted = target.fromBase(base);
            return new Quantity(converted, target);
        }

        // Equality
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            return Double.compare(this.toBase(), other.toBase()) == 0;
        }

        // UC6 + UC7 combined
        public Quantity add(Quantity other, LengthUnit targetUnit) {

            if (other == null)
                throw new IllegalArgumentException("Second operand null");

            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit null");

            double sumBase = this.toBase() + other.toBase();

            double result = targetUnit.fromBase(sumBase);

            return new Quantity(result, targetUnit);
        }

        // UC6 (reuse UC7)
        public Quantity add(Quantity other) {
            return add(other, this.unit);
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        System.out.println(q1.convertTo(LengthUnit.INCH));
        System.out.println(q1.add(q2, LengthUnit.FEET));
        System.out.println(q1.equals(q2));
    }
}