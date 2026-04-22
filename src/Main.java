public static void main(String[] args) {

    Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
    Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

    System.out.println("Feet result: " +
            q1.add(q2, LengthUnit.FEET));

    System.out.println("Inches result: " +
            q1.add(q2, LengthUnit.INCH));

    System.out.println("Yards result: " +
            q1.add(q2, LengthUnit.YARD));
}