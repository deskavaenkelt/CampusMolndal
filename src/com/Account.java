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

public class Account {
    /**
     * Variables for to save customer info in
     */
    private String name;
    private int balance;    // Borde använda double men använder int av bekvämlighetsskäl
    private boolean vip;


    /**
     * Regular Customer constructor
     * @param name is customer name
     * vip is set to false by default
     */
    Account(String name) {
        this.name = name;
        this.balance = 0;
        this.vip = false;
    }

    /**
     * VIP Customer constructor
     * @param name is vip customer name
     * @param vip is set to true
     */
    Account(String name, boolean vip) {
        this.name = name;
        this.balance = 0;
        this.vip = vip;
    }


    /**
     * Deposit for all customers
     * @param depositAmount to bank account
     */
    void deposit(int depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " made.  New balance is " + this.balance);
    }

    /**
     * Withdraws for regular customers, VIP customers override this function
     * @param withdrawalAmount from customer account
     */
    public void withdrawal(int withdrawalAmount, int id) {
        if (this.balance - withdrawalAmount < 0) {
            System.out.println("Only " + this.balance + " available. Withdrawal not processed");
        } else {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " processed.  Remaining balance = " + this.balance);
            // TODO: Rättat fel med att den la till ej genomförda transaktioner
            Storage.addRegularTransaction(id, withdrawalAmount);
        }
    }


    // Getters and Setters

    /**
     * Get name
     * @return name
     */
    String getName() {
        return name;
    }
    /**
     * Get balance
     * @return balance
     */
    int getBalance() {
        return balance;
    }

    /**
     * get Vip Status
     * @return vip status
     */
    boolean getVipStatus() {
        return vip;
    }

    /**
     * set account balance
     * @param balance to set
     */
    void setBalance(int balance) {
        this.balance = balance;
    }
}