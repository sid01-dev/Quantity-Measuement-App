package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    double EPS = 1e-3;

    @Test
    void testTargetFeet() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.Quantity(12.0,
                QuantityMeasurementApp.LengthUnit.INCH);

        var result = q1.add(q2,
                QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(2.0, result.convertTo(
                QuantityMeasurementApp.LengthUnit.FEET).value, EPS);
    }

    @Test
    void testTargetInch() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.Quantity(12.0,
                QuantityMeasurementApp.LengthUnit.INCH);

        var result = q1.add(q2,
                QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(24.0, result.convertTo(
                QuantityMeasurementApp.LengthUnit.INCH).value, EPS);
    }

    @Test
    void testTargetYard() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.Quantity(12.0,
                QuantityMeasurementApp.LengthUnit.INCH);

        var result = q1.add(q2,
                QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(0.667, result.convertTo(
                QuantityMeasurementApp.LengthUnit.YARD).value, EPS);
    }

    @Test
    void testCommutative() {
        var a = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.FEET);
        var b = new QuantityMeasurementApp.Quantity(12.0,
                QuantityMeasurementApp.LengthUnit.INCH);

        var r1 = a.add(b,
                QuantityMeasurementApp.LengthUnit.YARD);
        var r2 = b.add(a,
                QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(r1.convertTo(
                        QuantityMeasurementApp.LengthUnit.YARD).value,
                r2.convertTo(
                        QuantityMeasurementApp.LengthUnit.YARD).value,
                EPS);
    }

    @Test
    void testNullTarget() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> q1.add(q1, null));
    }
}

@Test
void testConvertToBase() {
    assertEquals(1.0,
            LengthUnit.INCH.toBase(12.0), 1e-6);
}

@Test
void testConvertFromBase() {
    assertEquals(12.0,
            LengthUnit.INCH.fromBase(1.0), 1e-6);
}