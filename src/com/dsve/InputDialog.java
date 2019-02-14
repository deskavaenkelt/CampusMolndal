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
import java.util.Scanner;

public class InputDialog {
    private static Scanner scanner = new Scanner(System.in);

    public static int getNumber() {
        return readNumber();
    }

    private static int readNumber() {
        String input = getStringInput();
        int number = -1;
        if (isInteger(input)) {
            number = Integer.parseInt(input);
        }
        return number;
    }

    private static boolean isInteger(String passedString) {
        boolean isValidInteger = false;
        try
        {
            Integer.parseInt(passedString);        // s is a valid integer
            isValidInteger = true;
        }
        catch (NumberFormatException ex)
        {
            // s is not an integer
        }

        return isValidInteger;
    }

    private static String getStringInput() {
        return scanner.nextLine();
    }

}
