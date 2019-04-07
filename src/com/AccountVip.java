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
public class AccountVip extends Account {
    private int creditLimit;

    AccountVip(String name, int creditLimit) {
        super(name, true);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdrawal(int withdrawalAmount) {
        int totalCredit = 0 - this.creditLimit;

        int tryingToWithdrawAmount = getBalance() - withdrawalAmount;

        if (tryingToWithdrawAmount < totalCredit) {
            int available = getBalance() + creditLimit;
            System.out.println("You are trying to overcharge you're available credit, only " + available + " available.\nWithdrawal not processed.\n");
        } else {
            setBalance(getBalance() - withdrawalAmount);
            System.out.println("Withdrawal of " + withdrawalAmount + " processed. " +
                    "\nRemaining balance is " + getBalance() +
                    ". \nAllowed credit is: -" + creditLimit + " SEK\n");
        }
    }

    int getCreditLimit() {
        return creditLimit;
    }
}


