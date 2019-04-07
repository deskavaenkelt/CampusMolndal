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
    private String name;
    private int balance;    // Borde använda double men använder int av bekvämlighetsskäl
    private boolean vip;


    /** Constructors
     *
     *
     */
    Account(String name) {
        this.name = name;
        this.balance = 0;
        this.vip = false;
    }
    Account(String name, boolean vip) {
        this.name = name;
        this.balance = 0;
        this.vip = vip;
    }


    /** Deposit
     *
     *
     */
    void deposit(int depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " made.  New balance is " + this.balance);
    }

    /** Withdraws
     *
     *
     */
    public void withdrawal(int withdrawalAmount) {
        if (this.balance - withdrawalAmount < 0) {
            System.out.println("Only " + this.balance + " available. Withdrawal not processed");
        } else {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " processed.  Remaining balance = " + this.balance);
        }
    }


    /** Getters and Setters
     *
     *
     */

    String getName() {
        return name;
    }

    int getBalance() {
        return balance;
    }
    boolean getVipStatus() {
        return vip;
    }
    void setBalance(int balance) {
        this.balance = balance;
    }
}


// TODO: JavaDoc check