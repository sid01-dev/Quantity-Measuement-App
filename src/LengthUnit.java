package com.example;

public enum LengthUnit {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CM(1.0 / 30.48);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    // Convert → base unit (feet)
    public double toBase(double value) {
        return value * factor;
    }

    // Convert ← base unit
    public double fromBase(double baseValue) {
        return baseValue / factor;
    }

    public double getFactor() {
        return factor;
    }
}