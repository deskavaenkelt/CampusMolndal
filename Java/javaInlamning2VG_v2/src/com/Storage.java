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
    private static List<AccountVip> customersVip = new ArrayList<>();
    private static List<Transactions> customerTransactions = new ArrayList<>();

    static List<AccountVip> getCustomersVip() {
        return customersVip;
    }
    static List<Transactions> getCustomerTransactions() {
        return customerTransactions;
    }

    // New Customer
    static void addCustomer(String name, boolean isVip, int creditLimit) {
        customersVip.add(new AccountVip(name, isVip, creditLimit));
    }
    // Delete Customer
    static void deleteVip(int id) {
        customersVip.remove(id);
    }

    /*static void updateCustomerName(int id, String name) {
        customersVip.set(id, g);
    }*/


    // Transactions
    /**
     * Function for deposit funds
     * Print id range according to how many customers there is in related ArrayLists
     * Use the right loop according to regular or VIP customer
     */
    static void deposit(int id, int amount) {
        customersVip.get(id).deposit(id, amount);
    }

    /**
     * Function for withdraw funds
     * Print id range according to how many customers there is in related ArrayLists
     * Use the right loop according to regular or VIP customer
     */
    static void withdraw(int id, int amount) {
        if ((Storage.getCustomersVip().size() - 1) < id) {
            System.out.println("Invalid Customer id!");
        } else {
            if (Storage.getCustomersVip().get(id).getVipStatus()) {
                customersVip.get(id).withdrawalVip(id, amount);
            } else {
                customersVip.get(id).withdrawal(id, amount);
            }
        }
    }

    static void depositTransaction(int id, int amount) {
        customerTransactions.add(new Transactions(customersVip.get(id).getName(), amount));
    }
    static void withdrawTransaction(int id, int negativeAmount) {
        customerTransactions.add(new Transactions(customersVip.get(id).getName(), negativeAmount));
    }
}