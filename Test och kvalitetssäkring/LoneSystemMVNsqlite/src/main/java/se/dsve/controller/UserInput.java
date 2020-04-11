package se.dsve.controller;

import java.util.Scanner;

public class UserInput {

    /////////////////////
    //  return String  //
    /////////////////////

    // Start the scanner
    private static Scanner scanner = new Scanner(System.in);

    // Call public function to get user input string
    static String getString() {                         // Ej testbar
        return scanner.nextLine();
    }

    //////////////////
    //  return int  //
    //////////////////
    static int readNumber() {                           // Ej testbar
        // Call public function to get user input number
        return readNumberTestAble(getString());
    }

    public static int readNumberTestAble(String input) {
        // return -1 if not an integer
        int number = -1;

        // Call isInteger to check if input is a number, catch exeption
        if (isInteger(input)) {
            // If true parseInt
            number = Integer.parseInt(input);
        }
        return number;
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

    // Check if input is an integer
    public static boolean isIntegerTest(String passedString) {   // Needed for tests
        return isInteger(passedString);
    }

    /////////////////////
    //  return double  //
    /////////////////////
    static double readDouble() {                        // Ej testbar
        // Call public function to get user input number
        return readDoubleTestAble(getString());
    }

    public static double readDoubleTestAble(String input) {
        // return -1 if not an double
        double number = -1;

        // Call isInteger to check if input is a number, catch exeption
        if (isDouble(input)) {
            // If true parseInt
            number = Double.parseDouble(input);
        }
        return number;
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

    public static boolean isDoubleTest(String passedString) {   // Needed for tests
        return isDouble(passedString);
    }

    // Close scanner
//    static void closeScanner() {
//        scanner.close();
//    }
}






























