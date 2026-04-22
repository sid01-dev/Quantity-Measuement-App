// Inside Quantity class

public Quantity add(Quantity other) {

    if (other == null)
        throw new IllegalArgumentException("Second operand cannot be null");

    // Convert both to base (feet)
    double sumInFeet = this.toFeet() + other.toFeet();

    // Convert back to THIS unit
    double resultValue = sumInFeet / this.unit.getFactor();

    return new Quantity(resultValue, this.unit);
}