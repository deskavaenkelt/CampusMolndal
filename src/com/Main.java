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

/**
 * java_inlamningsuppgift2_vg
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-04-03.
 * https://github.com/deskavaenkelt/
 */
public class Main {

    private static int id = 0;
    private static ArrayList<AccountVip> customers = new ArrayList<>();


    public static void main(String[] args) {

        run();

        System.out.println(customers.contains(id));
    }

    private static void run() {
        System.out.println("Enter customer initials: ");
        String customerInitials = UserInput.getString();
        System.out.println("Enter customer name: ");
        String customerName = UserInput.getString();
        System.out.println("Enter initial balance: ");
        int initialBalance = UserInput.getNumber();

        //customerInitials;

        Account newAccount = new Account(id, customerName, initialBalance);
        customers.add(newAccount);
        id++;
    }
}

/*
customers.add(id);
        id++;
 */