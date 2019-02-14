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

import java.util.ArrayList;

/**
 * datalogiUppgift2Primtal
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-02-13
 * https://github.com/deskavaenkelt/
 */

public class Main {
    public static void main(String[] args) {
        runProgram();
    }

    private static void runProgram() {
        boolean quit = false;

        while(!quit) {
            printActions();
            int action = InputDialog.getNumber();

            if (action == 0 || action == 1 || action == 2 || action == 3 || action == 4 || action == 8 || action == 9) {
                switch (action) {
                    case 0:
                        System.out.println("\nShutting down...");
                        quit = true;
                        break;
                    case 1:
                        Add.start();
                        Add.sumOfArray();   //Extra
                        break;
                    case 2:
                        Sort.start();
                        break;
                    case 3:
                        Search.start();
                        break;
                    case 4:
                        Add.multipleNumbers();
                        Add.sumOfArray();
                        break;
                    case 8:
                        Add.printDatabase();
                        break;
                    case 9:
                        Add.importDatabase();
                        break;
                }
            }
        }
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:");
        System.out.println(
                "+----------------------------+\n" +
                "| 1  - Add                   |\n" +
                "| 2  - Sort                  |\n" +
                "| 3  - Search                |\n" +
                "| 4  - Add multiple numbers  |\n" +
                "|                            |\n" +
                "| ========== EXTRA ========= |\n" +
                "| 8  - Print Database        |\n" +
                "| 9  - Import Database       |\n" +
                "| 0  - Shutdown              |\n" +
                "+----------------------------+\n");
        System.out.print("Enter action: ");
    }
}

class Sort {
    public static void start() {
        System.out.println("\nInitialize Sort...");
        Add.printDatabase();
        Add.sortArray();
    }
}

class Search {
    public static void start() {
        System.out.print("Number to be searched for: ");
        Add.searchForNumber();
    }
}



