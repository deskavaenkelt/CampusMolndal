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
     * @param name
     * @param balance
     */
    public Account(String name) {
        this.name = name;
        this.balance = 0;
        this.vip = false;
    }
    public Account(String name, boolean vip) {
        this.name = name;
        this.balance = 0;
        this.vip = vip;
    }


    /** Deposit
     *
     * @param depositAmount
     */
    public void deposit(int depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " made.  New balance is " + this.balance);
    }

    /** Withdraws
     *
     * @param withdrawalAmount
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
     * @return
     */

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }
    protected void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean getVipStatus() {
        return vip;
    }
    public void setVipStatus(boolean vip) {
        this.vip = vip;
    }
}


// TODO: JavaDoc check