package se.dsve;

import java.util.Scanner;

public class UserInput {

    // Start the scanner
    private static Scanner scanner = new Scanner(System.in);

    // Call public function to get user input string
    static String getString() {
        return scanner.nextLine();
    }

    // Call public function to get user input number
    static int readNumber() {
        // Read input as a string
        String input = scanner.nextLine();

        return readNumberTestAble(input);
    }

    static int readNumberTestAble(String input) {
        // return -1 if not an integer
        int number = -1;

        // Call isInteger to check if input is a number, catch exeption
        if (isInteger(input)) {
            // If true parseInt
            number = Integer.parseInt(input);
        }
        return number;
    }

    // Check if input is an integer
    public static boolean isIntegerTest(String passedString) {   // Needed for tests
        return isInteger(passedString);
    }
    private static boolean isInteger(String passedString) {
        // Validate so that input is an int
        boolean isValidInteger = false;
        try {
            Integer.parseInt(passedString);        // passedString is a valid integer
            isValidInteger = true;
        }
        catch (NumberFormatException ex) {
            // passedString is not an integer
            System.out.println(ex);
        }
        return isValidInteger;
    }

    // Check if input is an double
    // Call public function to get user input number
    static double readDouble() {
        // Read input as a string
        String input = scanner.nextLine();

        // return -1 if not an double
        double number = -1;

        // Call isInteger to check if input is a number, catch exeption
        if (isDouble(input)) {
            // If true parseInt
            number = Double.parseDouble(input);
        }

        return number;
    }

    public static boolean isDoubleTest(String passedString) {   // Needed for tests
        return isDouble(passedString);
    }
    private static boolean isDouble(String passedString) {
        // Validate so that input is an int
        boolean isValidDouble = false;
        try {
            Double.parseDouble(passedString);       // passedString is a valid double
            isValidDouble = true;
        }
        catch (NumberFormatException ex) {
            // passedString is not an integer
            System.out.println(ex);
        }
        return isValidDouble;
    }

    // Close scanner
    static void closeScanner() {
        scanner.close();
    }
}
