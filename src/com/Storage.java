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
 * @since 2019-04-06.
 * https://github.com/deskavaenkelt/
 */
import java.util.ArrayList;
import java.util.List;
public class Storage {

    private static List<Account> customers = new ArrayList<>();
    private static List<AccountVip> vipCustomers = new ArrayList<>();
    private static List<Transactions> customerTransactions = new ArrayList<>();


    public static void addCustomer() {
        // Add a customer to Arraylist
        System.out.println("Regular");
        System.out.println("Enter customer name: ");
        String customerName = UserInput.getString();

        customers.add(new Account(customerName));
    }
    public static void addVipCustomer() {
        // Add a VIP customer to Arraylist
        System.out.println("VIP");
        System.out.println("Enter customer name: ");
        String vipCustomerName = UserInput.getString();
        System.out.println("Enter credit limit: ");
        int vipCreditLimit = UserInput.getNumber();

        vipCustomers.add(new AccountVip(vipCustomerName, vipCreditLimit));
    }

    /** Print methods
     *
     */
    private static void printCustomers() {
        // Display content of customers
        customers.forEach(customer ->{
            System.out.println("Customer " + customer.getName() + ", have a balance of: " + customer.getBalance() +
                    "SEK. VIP Customer = " + customer.getVipStatus());
        });
    }
    private static void printVipCustomers() {
        // Display content of vipCustomers
        vipCustomers.forEach(customer ->{
            System.out.println("Customer " + customer.getName() +
                    ", have a balance of: " + customer.getBalance() +
                    "SEK. VIP Customer = " + customer.getVipStatus() +
                    ", credit limit: " + customer.getCreditLimit());
        });
    }
    private static void printTransactions() {
        // Display all customer transactions
        customerTransactions.forEach(transaction ->{
            System.out.println("Customer " + transaction.getCustomerName() + " amount: " + transaction.getAmount());
        });
    }
}
