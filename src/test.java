package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testEquality_YardToFeet() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.YARD);
        var q2 = new QuantityMeasurementApp.Quantity(3.0,
                QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_YardToInch() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.YARD);
        var q2 = new QuantityMeasurementApp.Quantity(36.0,
                QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_CMToInch() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.CM);
        var q2 = new QuantityMeasurementApp.Quantity(0.393701,
                QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_DifferentUnits_NotEqual() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.CM);
        var q2 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_Transitive() {
        var yard = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.YARD);
        var feet = new QuantityMeasurementApp.Quantity(3.0,
                QuantityMeasurementApp.LengthUnit.FEET);
        var inch = new QuantityMeasurementApp.Quantity(36.0,
                QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inch));
        assertTrue(yard.equals(inch));
    }

    @Test
    void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.Quantity(1.0, null);
        });
    }
}