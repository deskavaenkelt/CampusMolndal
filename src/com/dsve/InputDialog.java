package com.dsve;
/*
  __
 /\ \
 \_\ \    ____  __  __     __
 /'_` \  /',__\/\ \/\ \  /'__`\
/\ \L\ \/\__, `\ \ \_/ |/\  __/
\ \___,_\/\____/\ \___/ \ \____\
 \/__,_ /\/___/  \/__/   \/____/

*/

/**
 * datalogiUppgift2Primtal
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-02-13
 * https://github.com/deskavaenkelt/
 */

// Använder en separat klass för all hantering av inläsning

import java.util.Scanner;

class InputDialog {
    private static Scanner scanner = new Scanner(System.in);

    static int getNumber() {
        return readNumber();
    }

    private static int readNumber() {
        // Läs in nummret
        String input = userInput();
        // returnera -1 vid felaktig inmatning
        int number = -1;
        if (isInteger(input)) {
            number = Integer.parseInt(input);
        }
        return number;
    }

    private static String userInput() {
        return scanner.nextLine();
    }

    private static boolean isInteger(String passedString) {
        // Validera att input är en int
        boolean isValidInteger = false;
        try
        {
            Integer.parseInt(passedString);        // passedString is a valid integer
            isValidInteger = true;
        }
        catch (NumberFormatException ex)
        {
            // passedString is not an integer
        }

        return isValidInteger;
    }

    // Close scanner
    static void closeScanner() {
        scanner.close();
    }
}
