public class ExceptionHandlingAndAssertionDemo {
    public static void main(String[] args) {
        // Exception handling example
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes.");
        }

        // Assertion example
        int value = -5;
        assert value >= 0 : "Value must be non-negative"; // Assertion
        System.out.println("Value is: " + value);
    }

    // Method to demonstrate throwing an exception
    private static int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return numerator / denominator;
    }
}
