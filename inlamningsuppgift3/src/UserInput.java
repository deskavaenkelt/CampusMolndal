/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/datalogiUppgift3slutuppgift
 */

import java.util.Scanner;

class UserInput {
    private static Scanner scanner = new Scanner(System.in);
    static String getString() {
        return userInput();
    }
    private static String userInput() {
        return scanner.nextLine();
    }
    static int getNumber() {
        return readNumber();
    }

    private static int readNumber() {
        // Read the number
        String input = userInput();
        // return -1 if not an integer
        int number = -1;
        if (isInteger(input)) {
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
        }
        return isValidInteger;
    }

    // Close scanner
    static void closeScanner() {
        scanner.close();
    }
}