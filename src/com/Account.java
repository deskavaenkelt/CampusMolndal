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

/**
 * java_inlamningsuppgift2_vg
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-04-03.
 * https://github.com/deskavaenkelt/
 */
public class Account {
    private int id;
    private String name;
    private double balance;
    private boolean vip;

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.vip = false;
    }
    private Account(int id, String name, double balance, boolean vip) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.vip = vip;
    }


    public void deposit(double depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " made.  New balance is " + this.balance);
    }

    public void withdrawal(double withdrawalAmount) {
        if (this.balance - withdrawalAmount < 0) {
            System.out.println("Only " + this.balance + " available. Withdrawal not processed");
        } else {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " processed.  Remaining balance = " + this.balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }
}
