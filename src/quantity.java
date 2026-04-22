public Quantity add(Quantity other, LengthUnit targetUnit) {

    if (other == null)
        throw new IllegalArgumentException("Second operand cannot be null");

    if (targetUnit == null)
        throw new IllegalArgumentException("Target unit cannot be null");

    // Convert both → base unit (feet)
    double sumInFeet = this.toFeet() + other.toFeet();

    // Convert → target unit
    double resultValue = sumInFeet / targetUnit.getFactor();

    return new Quantity(resultValue, targetUnit);
}