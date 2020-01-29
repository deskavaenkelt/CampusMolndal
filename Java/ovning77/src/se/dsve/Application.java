package se.dsve;

import java.util.Scanner;

public class Application {
private static Scanner scanner = new Scanner(System.in);

    static String userInput() {
        return scanner.nextLine();
    }

    static String toLowerCase(String input) {
        return input.toLowerCase();
    }

    static boolean checkIfExit(String input) {

        return input.equals("exit");
    }

    static int calculateValueForLetters(char c) {
        // a = 97 -96
        // z = 122 -96
        // å = 134 return 26
        // ä = 132 return 27
        // ö = 147 return 28

        if (c >= 97 && c <= 122) {
            return c -96;
        } else if (c == 134) {
            return 26;
        } else if (c == 132) {
            return 27;
        } else if (c == 147) {
            return 28;
        } else {
            return 0;
        }
    }

    static long calculateScore(String input) {
        long sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += calculateValueForLetters(input.charAt(i));
        }
        return sum;
    }
}
