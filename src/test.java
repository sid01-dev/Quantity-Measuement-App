@Test
void testKgToGramEquality() {
    var w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
    var w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

    assertTrue(w1.equals(w2));
}

@Test
void testPoundConversion() {
    var w = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

    assertEquals(2.20462,
            w.convertTo(WeightUnit.POUND).toString().contains("2.204"),
            true);
}

@Test
void testAddition() {
    var w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
    var w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

    var result = w1.add(w2);

    assertTrue(result.equals(new QuantityWeight(2.0, WeightUnit.KILOGRAM)));
}