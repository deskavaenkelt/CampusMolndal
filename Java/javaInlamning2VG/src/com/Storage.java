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

import java.util.ArrayList;
import java.util.List;
/**
 * java_inlamningsuppgift2_vg
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-04-06.
 * https://github.com/deskavaenkelt/
 */
class Storage {

    /**
     * Store info in respectively ArrayList
     */
    private static List<Account> customers = new ArrayList<>();
    private static List<AccountVip> customersVip = new ArrayList<>();
    private static List<Transactions> customerTransactions = new ArrayList<>();

    // 1. Show All Customers

    /**
     * Display content of customers
     */
    static void printCustomers() {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("Nr: " + i +
                    " Customer: " + customers.get(i).getName() +
                    ", have a balance of: " + customers.get(i).getBalance() +
                    " SEK. VIP Customer = " + customers.get(i).getVipStatus());
        }
    }

    /**
     * Display content of customersVip
     */
    static void printVipCustomers() {
        for (int i = 0; i < customersVip.size(); i++) {
            System.out.println("Nr: " + i +
                    " Customer: " + customersVip.get(i).getName() +
                    ", have a balance of: " + customersVip.get(i).getBalance() +
                    " SEK. VIP Customer = " + customersVip.get(i).getVipStatus() +
                    ", credit limit: " + customersVip.get(i).getCreditLimit() +
                    " SEK");
        }
    }



    // 2. New Customer
    /**
     * Menu for new customer tab and related functions
     */
    static void insertCustomer() {

        boolean quit = false;
        while (!quit) {
            System.out.print(
                    "+-------------------------+\n" +
                    "|      dsve Banking       |\n" +
                    "+-------------------------+\n" +
                    "|      New Customer       |\n" +
                    "+-------------------------+\n" +
                    "|  1.  Regular            |\n" +
                    "|  2.  VIP                |\n" +
                    "|  3.  Import 3 of each   |\n" +
                    "+-------------------------+\n" +
                    "|  0.  Back               |\n" +
                    "+-------------------------+\n\n" +
                    "Choice: "
            );

            int action = UserInput.getNumber();

            if (action == 1 || action == 2 || action == 3 || action == 0) {
                switch (action) {
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        addVipCustomer();
                        break;
                    case 3:
                        importCustomer();
                        break;
                    case 0:
                        quit = true;
                        break;
                }
            }
        }

    }
    private static void addCustomer() {
        // Add a customer to Arraylist
        System.out.println("Regular");
        System.out.println("Enter customer name: ");
        String customerName = UserInput.getString();

        customers.add(new Account(customerName));
    }
    private static void addVipCustomer() {
        // Add a VIP customer to Arraylist
        System.out.println("VIP");
        System.out.println("Enter customer name: ");
        String vipCustomerName = UserInput.getString();
        System.out.println("Enter credit limit: ");
        int vipCreditLimit = UserInput.getNumber();

        customersVip.add(new AccountVip(vipCustomerName, vipCreditLimit));
    }
    private static void importCustomer() {
        // Import 3 Regular Customers
        customers.add(new Account("Adam"));
        customers.add(new Account("Bert"));
        customers.add(new Account("Carl"));

        // Import 3 VIP Customers
        customersVip.add(new AccountVip("Dana", 1000));
        customersVip.add(new AccountVip("Erik", 2000));
        customersVip.add(new AccountVip("Fape", 3000));
    }



    // 3.  Delete Customer
    /**
     * Menu for delete customer tab and related functions
     */
    static void deleteCustomer() {
        boolean quit = false;
        while (!quit) {
            System.out.print(
                    "+-------------------------+\n" +
                    "|----- dsve Banking ------|\n" +
                    "+-------------------------+\n" +
                    "|     Delete Customer     |\n" +
                    "+-------------------------+\n" +
                    "|  1.  Print All          |\n" +
                    "|  2.  Regular            |\n" +
                    "|  3.  VIP                |\n" +
                    "+-------------------------+\n" +
                    "|  0.  Back               |\n" +
                    "+-------------------------+\n\n" +
                    "Choice: "
            );

            int action = UserInput.getNumber();

            if (action == 1 || action == 2 || action == 3 || action == 0) {
                switch (action) {
                    case 1:
                        printCustomers();
                        printVipCustomers();
                        break;
                    case 2:
                        deleteRegular();
                        break;
                    case 3:
                        deleteVip();
                        break;
                    case 0:
                        quit = true;
                        break;
                }
            }
        }
    }
    private static void deleteRegular() {
        System.out.print("Enter Regular ID: 0-" + (customers.size()-1) + " to delete:");
        int id = UserInput.getNumber();
        customers.remove(id);
    }
    private static void deleteVip() {
        System.out.print("Enter VIP ID: 0-" + (customersVip.size()-1) + " to delete:");
        int id = UserInput.getNumber();
        customersVip.remove(id);
    }


    // Transactions
    /**
     * Function for deposit funds
     * Print id range according to how many customers there is in related ArrayLists
     * Use the right loop according to regular or VIP customer
     */
    static void deposit() {
        boolean vipStatus = isVip();

        if (!vipStatus) {
            System.out.print("Input customer id 0-" + (customers.size()-1) + ": ");
        } else {
            System.out.print("Input customer id 0-" + (customersVip.size()-1) + ": ");
        }

        int id = UserInput.getNumber();

        // Kontrollera så att talet inte är för stort
        if (!vipStatus && id <= customers.size()) {
            System.out.print("Amount to deposit: ");
            int amount = UserInput.getNumber();

            customers.get(id).deposit(amount);
        } else if (vipStatus && id <= customersVip.size()) {
            System.out.print("Amount to deposit: ");
            int amount = UserInput.getNumber();

            customersVip.get(id).deposit(amount);
        } else {
            System.out.println("Invalid Customer id!");
        }
    }
    static void addRegularTransaction(int id, int amount) {
        customerTransactions.add(new Transactions(customers.get(id).getName(), amount));
    }
    static void addVipTransaction(int id, int amount) {
        customerTransactions.add(new Transactions(customersVip.get(id).getName(), amount));
    }

    /**
     * Function for withdraw funds
     * Print id range according to how many customers there is in related ArrayLists
     * Use the right loop according to regular or VIP customer
     */
    static void withdraw() {
        boolean vipStatus = isVip();

        if (!vipStatus) {
            System.out.print("Input customer id 0-" + (customers.size()-1) + ": ");
        } else {
            System.out.print("Input customer id 0-" + (customersVip.size()-1) + ": ");
        }

        int id = UserInput.getNumber();

        // Kontrollera så att talet inte är för stort
        if (!vipStatus && id <= customers.size()) {
            System.out.print("Amount to withdraw: ");
            int amount = UserInput.getNumber();
            int negativeAmount = -amount;

            customers.get(id).withdrawal(amount, id);
            //customerTransactions.add(new Transactions(customers.get(id).getName(), negativeAmount));
        } else if (vipStatus && id <= customersVip.size()) {
            System.out.print("Amount to withdraw: ");
            int amount = UserInput.getNumber();
            int negativeAmount = -amount;

            customersVip.get(id).withdrawal(amount, id);
            //customerTransactions.add(new Transactions(customersVip.get(id).getName(), negativeAmount));
        } else {
            System.out.println("Invalid Customer id!");
        }
    }

    /**
     * Simple Import function
     * Makes som transactions for some customers and same transactions
     */
    static void importTransactionsList() {
        // Transactions for regular
        customerTransactions.add(new Transactions(customers.get(0).getName(), 1000));
        customers.get(0).deposit(1000);
        customerTransactions.add(new Transactions(customers.get(1).getName(), 100));
        customers.get(1).deposit(100);
        customerTransactions.add(new Transactions(customers.get(2).getName(), 10));
        customers.get(2).deposit(10);
        customerTransactions.add(new Transactions(customers.get(0).getName(), 20));
        customers.get(0).deposit(20);
        customerTransactions.add(new Transactions(customers.get(1).getName(), 200));
        customers.get(1).deposit(200);
        customerTransactions.add(new Transactions(customers.get(2).getName(), 2000));
        customers.get(2).deposit(2000);

        // Transactions for VIP
        customerTransactions.add(new Transactions(customersVip.get(0).getName(), 3000));
        customersVip.get(0).deposit(3000);
        customerTransactions.add(new Transactions(customersVip.get(1).getName(), 300));
        customersVip.get(1).deposit(300);
        customerTransactions.add(new Transactions(customersVip.get(2).getName(), 30));
        customersVip.get(2).deposit(30);
        customerTransactions.add(new Transactions(customersVip.get(0).getName(), 40));
        customersVip.get(0).deposit(40);
        customerTransactions.add(new Transactions(customersVip.get(1).getName(), 400));
        customersVip.get(1).deposit(400);
        customerTransactions.add(new Transactions(customersVip.get(2).getName(), 4000));
        customersVip.get(2).deposit(4000);
    }

    /**
     * Check if a customer is VIP or not
     * @return true if VIP
     */
    private static boolean isVip() {
        // Do yo want to work on a vip customer or regular? return false for regular, true for vip
        boolean vipIs = false;
        System.out.println("Chose Regular or VIP customer\nRegular = 0\nVIP = 1");
        int choise = UserInput.getNumber();
        if (choise == 1) {
            vipIs = true;
        }
        return vipIs;
    }

    /**
     * Print all transactions made to console
     */
    static void printTransactionsAcceding() {

        for (int i = 0; i < customerTransactions.size(); i++) {
            System.out.println("Nr: " + i + " Customer: " + customerTransactions.get(i).getCustomerName() +
                    " Transferred: " + customerTransactions.get(i).getAmount() + " SEK");
        }

        int bankFoundsIs = 0;
        for (int i = 0; i < customerTransactions.size(); i++) {
            bankFoundsIs += customerTransactions.get(i).getAmount();
        }

        System.out.println("\nThe banking founds is: " + bankFoundsIs + " SEK\n");
    }
}
