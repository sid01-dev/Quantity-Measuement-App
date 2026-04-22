package com.example;

public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }

    // → base unit (kg)
    public double toBase(double value) {
        return value * factor;
    }

    // ← from base
    public double fromBase(double baseValue) {
        return baseValue / factor;
    }

    public double getFactor() {
        return factor;
    }
}