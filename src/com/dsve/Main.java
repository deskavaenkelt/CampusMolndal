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

public class Main {
    private static boolean quit = false;
    public static void main(String[] args) {
        runProgram();
    }

    // Anropar respektive metod vid val
    private static void runProgram() {
        while(!quit) {
            printMeny();
            int action = InputDialog.getNumber();

            if (action == 0 || action == 1 || action == 2 || action == 3 || action == 4 || action == 7 || action == 8 || action == 9) {
                switch (action) {
                    case 1:
                        add();
                        break;
                    case 2:
                        sort();
                        break;
                    case 3:
                        search();
                        break;
                    case 4:
                        searchForXprimes();
                        break;
                    case 7:
                        addMultipleNumbers();
                        break;
                    case 8:
                        printDatabase();
                        break;
                    case 9:
                        importDatabase();
                        break;
                    case 0:
                        quit();
                        break;
                }
            }
        }
    }

    private static void printMeny() {
        System.out.println("\nAvailable actions:");
        System.out.println(
                "+----------------------------+\n" +
                "| 1  - Add                   |\n" +
                "| 2  - Sort                  |\n" +
                "| 3  - Search                |\n" +
                "| 4  - Search for X primes   |\n" +
                "|                            |\n" +
                "| ========== EXTRA ========= |\n" +
                "| 7  - Add multiple numbers  |\n" +
                "| 8  - Print Database        |\n" +
                "| 9  - Import Database       |\n" +
                "| 0  - Shutdown              |\n" +
                "+----------------------------+\n");
        System.out.print("Enter action: ");
    }

    // Alla metoder sort,search m.fl. går via add-klassen
    private static void add() {
        System.out.println("\nInitialize Add...");
        Add.addNumber();
        Add.sumOfArray();   //Extra
    }
    private static void sort() {
        System.out.println("\nInitialize Sort...");
        Add.printDatabase();
        Add.sortArray();
    }
    private static void search() {
        System.out.println("\nInitialize Search...");
        System.out.print("Number to be searched for: ");
        Add.searchForNumber();
    }
    private static void searchForXprimes() {
        System.out.println("\nInitialize Search...");
        Add.searchForXprimes();
        Add.sumOfArray();
    }
    private static void addMultipleNumbers() {
        System.out.println("\nInitialize Add Multiple numbers...");
        Add.multipleNumbers();
        Add.sumOfArray();
    }
    private static void printDatabase() {
        System.out.println("\nInitialize Print database...");
        Add.printDatabase();
    }
    private static void importDatabase() {
        System.out.println("\nInitialize Import Database...");
        Add.importDatabase();
    }
    private static void quit() {
        System.out.println("\nShutting down...");
        InputDialog.closeScanner();     // Stänger scannern
        quit = true;
    }
}




