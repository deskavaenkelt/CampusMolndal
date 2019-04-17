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

class Account {
    /**
     * Variables for to save customer info in
     */
    private String name;
    private int balance;    // Borde använda double men använder int av bekvämlighetsskäl
    private boolean vip;

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
    void deposit(int id, int depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " made. New balance is " + this.balance);
        Storage.depositTransaction(id, depositAmount);
    }

    // Getters and Setters

    /**
     * Get name
     * @return name
     */
    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    /**
     * set account balance
     * @param balance to set
     */
    void setBalance(int balance) {
        this.balance = balance;
    }
}