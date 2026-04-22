package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    double EPS = 1e-6;

    @Test
    void testAddition_SameUnit() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.Quantity(2.0,
                QuantityMeasurementApp.LengthUnit.FEET);

        var result = q1.add(q2);

        assertEquals(3.0, result.convertTo(
                QuantityMeasurementApp.LengthUnit.FEET).convertTo(
                QuantityMeasurementApp.LengthUnit.FEET).convertTo(
                QuantityMeasurementApp.LengthUnit.FEET).convertTo(
                QuantityMeasurementApp.LengthUnit.FEET).convertTo(
                QuantityMeasurementApp.LengthUnit.FEET).value, EPS);
    }

    @Test
    void testAddition_FeetPlusInch() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.Quantity(12.0,
                QuantityMeasurementApp.LengthUnit.INCH);

        var result = q1.add(q2);

        assertEquals(2.0, result.convertTo(
                QuantityMeasurementApp.LengthUnit.FEET).value, EPS);
    }

    @Test
    void testAddition_InchPlusFeet() {
        var q1 = new QuantityMeasurementApp.Quantity(12.0,
                QuantityMeasurementApp.LengthUnit.INCH);
        var q2 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.FEET);

        var result = q1.add(q2);

        assertEquals(24.0, result.convertTo(
                QuantityMeasurementApp.LengthUnit.INCH).value, EPS);
    }

    @Test
    void testAddition_YardPlusFeet() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.YARD);
        var q2 = new QuantityMeasurementApp.Quantity(3.0,
                QuantityMeasurementApp.LengthUnit.FEET);

        var result = q1.add(q2);

        assertEquals(2.0, result.convertTo(
                QuantityMeasurementApp.LengthUnit.YARD).value, EPS);
    }

    @Test
    void testAddition_WithZero() {
        var q1 = new QuantityMeasurementApp.Quantity(5.0,
                QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.Quantity(0.0,
                QuantityMeasurementApp.LengthUnit.INCH);

        var result = q1.add(q2);

        assertEquals(5.0, result.convertTo(
                QuantityMeasurementApp.LengthUnit.FEET).value, EPS);
    }

    @Test
    void testAddition_Negative() {
        var q1 = new QuantityMeasurementApp.Quantity(5.0,
                QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.Quantity(-2.0,
                QuantityMeasurementApp.LengthUnit.FEET);

        var result = q1.add(q2);

        assertEquals(3.0, result.convertTo(
                QuantityMeasurementApp.LengthUnit.FEET).value, EPS);
    }

    @Test
    void testAddition_Null() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0,
                QuantityMeasurementApp.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }
}