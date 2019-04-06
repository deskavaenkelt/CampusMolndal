package com;
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
import java.util.List;

/**
 * java_inlamningsuppgift2_vg
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-04-03.
 * https://github.com/deskavaenkelt/
 */
public class Main {

    private static List<Account> customers = new ArrayList<>();
    private static List<AccountVip> vipCustomers = new ArrayList<>();


    public static void main(String[] args) {

        // Start Program
        run();

        // Display content of customers
        customers.forEach(customer ->{
            System.out.println("Customer " + customer.getName() + ", have a balance of: " + customer.getBalance() +
                    "SEK. VIP Customer = " + customer.getVipStatus());
        });

        // Display content of vipCustomers
        vipCustomers.forEach(customer ->{
            System.out.println("Customer " + customer.getName() +
                    ", have a balance of: " + customer.getBalance() +
                    "SEK. VIP Customer = " + customer.getVipStatus() +
                    ", credit limit: " + customer.getCreditLimit());
        });
        UserInput.closeScanner();
    }

    private static void run() {
        // Add a customer to Arraylist
        System.out.println("Regular");
        System.out.println("Enter customer name: ");
        String customerName = UserInput.getString();
        System.out.println("Enter initial balance: ");
        int initialBalance = UserInput.getNumber();

        customers.add(new Account(customerName, initialBalance));

        // Add a VIP customer to Arraylist
        System.out.println("VIP");
        System.out.println("Enter customer name: ");
        String vipCustomerName = UserInput.getString();
        System.out.println("Enter initial balance: ");
        int vipInitialBalance = UserInput.getNumber();
        System.out.println("Enter credit limit: ");
        int vipCreditLimit = UserInput.getNumber();

        vipCustomers.add(new AccountVip(vipCustomerName, vipInitialBalance, vipCreditLimit));
    }
}

/*
customers.add(id);
        id++;
 */