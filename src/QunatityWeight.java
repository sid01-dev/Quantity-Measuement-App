package com.example;

public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.toBase(value);
    }

    // Equality
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }

    // Conversion
    public QuantityWeight convertTo(WeightUnit target) {
        double base = toBase();
        double result = target.fromBase(base);
        return new QuantityWeight(result, target);
    }

    // Addition (UC6 style)
    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    // Addition (UC7 style)
    public QuantityWeight add(QuantityWeight other, WeightUnit target) {

        if (other == null)
            throw new IllegalArgumentException("Other is null");

        if (target == null)
            throw new IllegalArgumentException("Target unit null");

        double sumBase = this.toBase() + other.toBase();

        double result = target.fromBase(sumBase);

        return new QuantityWeight(result, target);
    }

    @Override
    public String toString() {
        return "QuantityWeight(" + value + ", " + unit + ")";
    }
}