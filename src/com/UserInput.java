package com;

/*
  __
 /\ \
 \_\ \    ____  __  __     __
 /'_` \  /',__\/\ \/\ \  /'__`\
/\ \L\ \/\__, `\ \ \_/ |/\  __/
\ \___,_\/\____/\ \___/ \ \____\
 \/__,_ /\/___/  \/__/   \/____/

*/

import java.util.Scanner;

/**
 * java_inlamningsuppgift2_vg
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-02-02.
 * https://github.com/deskavaenkelt/
 */

class UserInput {
    // Start the scanner
    private static Scanner scanner = new Scanner(System.in);

    // Call public function to get user input string
    static String getString() {
        return userInput();
    }
    // Private function
    private static String userInput() {
        return scanner.nextLine();
    }

    // Call public function to get user input number
    static int getNumber() {
        return readNumber();
    }
    // Private function
    private static int readNumber() {
        // Read input as a string
        String input = userInput();

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
    private static boolean isInteger(String passedString) {
        // Validate so that input is an int
        boolean isValidInteger = false;
        try {
            Integer.parseInt(passedString);        // passedString is a valid integer
            isValidInteger = true;
        }
        catch (NumberFormatException ex) {
            // passedString is not an integer
        }
        return isValidInteger;
    }

    // Close scanner
    static void closeScanner() {
        scanner.close();
    }
}


