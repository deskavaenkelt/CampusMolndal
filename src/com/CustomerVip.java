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
public class CustomerVip extends Customer {
    private double creditLimit;

    public CustomerVip(int id, String name, double balance, double creditLimit, boolean vip) {
        super(id, name, balance, true);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdrawal(double withdrawalAmount) {
        double totalCredit = 0 - this.creditLimit;

        double tryingToWithdrawAmount = getBalance() - withdrawalAmount;

        if (tryingToWithdrawAmount < totalCredit) {
            double available = getBalance() + creditLimit;
            System.out.println("You are trying to overcharge you're available credit, only " + available + " available.\nWithdrawal not processed.\n");
        } else {
            setBalance(getBalance() - withdrawalAmount);
            System.out.println("Withdrawal of " + withdrawalAmount + " processed. " +
                    "\nRemaining balance is " + getBalance() +
                    ". \nAllowed credit is: -" + creditLimit + "\n");
        }
    }
}
