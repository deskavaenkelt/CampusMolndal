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
 * This is a simple banking application where ju can:
 * - Add/remove customers
 * - Make transactions (Deposit/Withdraw)
 * - Show all transactions and show the banks assets
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
    }
}

/**
 * Menu sytem
 * This is the initial menu, sub-menu's in Storage
 */
class Menu{

    private static boolean quitStart = false;

    static void start() {
        runProgram();
    }

    /**
     * Main menu
     */
    private static void runProgram() {
        while (!quitStart) {
            System.out.print(
                    "+-------------------------+\n" +
                    "|----- dsve Banking ------|\n" +
                    "+-------------------------+\n" +
                    "|  1.  Customers          |\n" +
                    "|  2.  New Transaction    |\n" +
                    "|  3.  Show Transaction   |\n" +
                    "+-------------------------+\n" +
                    "|  7.  Quit               |\n" +
                    "+-------------------------+\n\n" +
                    "Choice: "
            );
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
                        showTransactions();
                        break;
                    case 7:
                        quit();
                        break;
                }
            }
        }
    }

    /**
     * Menu for customers
     */
    private static void customers() {

        boolean quit = false;
        while (!quit) {
            System.out.println("\nOpen Custumers...");
            System.out.print(
                    "+-------------------------+\n" +
                    "|----- dsve Banking ------|\n" +
                    "+-------------------------+\n" +
                    "|       Customers         |\n" +
                    "+-------------------------+\n" +
                    "|  1.  Show All           |\n" +
                    "|  2.  New                |\n" +
                    "|  3.  Delete             |\n" +
                    "+-------------------------+\n" +
                    "|  0.  Back               |\n" +
                    "+-------------------------+\n\n" +
                    "Choice: "
            );
            int action = UserInput.getNumber();

            if (action == 1 || action == 2 || action == 3 || action == 4 || action == 0) {
                switch (action) {
                    case 1:
                        Storage.printCustomers();
                        Storage.printVipCustomers();
                        break;
                    case 2:
                        Storage.insertCustomer();
                        break;
                    case 3:
                        Storage.deleteCustomer();
                        break;
                    case 0:
                        quit = true;
                        break;
                }
            }
        }

    }

    /**
     * Menu for making transactions
     */
    private static void newTransaction() {
        boolean quit = false;
        while (!quit) {
            System.out.println("\nOpen New Transactions");
            System.out.print(
                    "+-------------------------+\n" +
                    "|----- dsve Banking ------|\n" +
                    "+-------------------------+\n" +
                    "|      Transactions       |\n" +
                    "+-------------------------+\n" +
                    "|  1.  Show All Customers |\n" +
                    "|  2.  Deposit            |\n" +
                    "|  3.  Withdraw           |\n" +
                    "|  4.  Import Trans.List  |\n" +
                    "+-------------------------+\n" +
                    "|  0.  Back               |\n" +
                    "+-------------------------+\n\n" +
                    "Choice: "
            );
            int action = UserInput.getNumber();

            if (action == 1 || action == 2 || action == 3 || action == 4 || action == 0) {
                switch (action) {
                    case 1:
                        Storage.printCustomers();
                        Storage.printVipCustomers();
                        break;
                    case 2:
                        Storage.deposit();
                        break;
                    case 3:
                        Storage.withdraw();
                        break;
                    case 4:
                        Storage.importTransactionsList();
                        break;
                    case 0:
                        quit = true;
                        break;
                }
            }
        }

    }

    /**
     * This option will only show all transactions that are made
     */
    private static void showTransactions() {
        // Just print and return to menu
        System.out.println("\nOpen History...");
        System.out.print(
                "+-------------------------+\n" +
                "|----- dsve Banking ------|\n" +
                "+-------------------------+\n" +
                "|   Show Transactions     |\n" +
                "+-------------------------+\n\n"
        );
        Storage.printTransactionsAcceding();
    }

    /**
     * Set variabel to quit menu, and close Scanner
     */
    private static void quit() {
        System.out.println("\nQuit program");
        quitStart = true;
        // Close scanner
        UserInput.closeScanner();
    }
}

// TODO: show funkar ej vid Delete
