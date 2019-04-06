/*
  __
 /\ \
 \_\ \    ____  __  __     __
 /'_` \  /',__\/\ \/\ \  /'__`\
/\ \L\ \/\__, `\ \ \_/ |/\  __/
\ \___,_\/\____/\ \___/ \ \____\
 \/__,_ /\/___/  \/__/   \/____/

*/
package com;
/**
 * java_inlamningsuppgift2_vg
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-04-03.
 * https://github.com/deskavaenkelt/
 */
public class Main {

    public static void main(String[] args) {

        // Start Program
        Menu.start();

        // Close scanner
        UserInput.closeScanner();
    }
}

class Menu{

    private static boolean quitStart = false;

    static void start() {
        runProgram();
    }
    private static void runProgram() {
        while (!quitStart) {
            printMenu();
            int action = UserInput.getNumber();

            if (action == 1 || action == 2 || action == 3 || action == 7) {
                switch (action) {
                    case 1:
                        customers();
                        break;
                    case 2:
                        newTransaction();
                        break;
                    case 3:
                        history();
                        break;
                    case 7:
                        quit();
                        break;
                }
            }
        }
    }
    private static void printMenu() {
        // TODO: Snygga till printMenu
        System.out.print(
                "+-------------------------+\n" +
                "|      dsve Banking       |\n" +
                "+-------------------------+\n" +
                "|  1   Customers          |\n" +
                "|  2   New Transaction    |\n" +
                "|  3   History            |\n" +
                "+-------------------------+\n" +
                "|  7   Quit               |\n" +
                "+-------------------------+\n\n" +
                "Choice: "
        );
    }
    private static void customers() {
        System.out.println("\nOpen Custumers...");
        System.out.print(
                "+-------------------------+\n" +
                "|      dsve Banking       |\n" +
                "+-------------------------+\n" +
                "|  1   Show All Customers |\n" +
                "|  2   New Customer       |\n" +
                "|  3   Update Customer    |\n" +
                "|  4   Delete Customer    |\n" +
                "+-------------------------+\n" +
                "|  7   Quit               |\n" +
                "+-------------------------+\n\n" +
                "Choice: "
        );
        int action = UserInput.getNumber();

        if (action == 1 || action == 2 || action == 3 || action == 4 || action == 7) {
            switch (action) {
                case 1:
                    Storage.printCustomers();
                    Storage.printVipCustomers();
                    break;
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    history();
                    break;
                case 4:
                    history();
                    break;
                case 7:
                    quit();
                    break;
            }
        }
    }

    private static void newTransaction() {
        System.out.println("\nOpen New Transactions");
        //NyaKunder.start();
    }

    private static void history() {
        System.out.println("\nOpen History...");
        // Administration.start();
    }

    private static void quit() {
        System.out.println("\nQuit program");
        quitStart = true;
    }
}