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
    /**
     * Only VIP customers have the ability to have credit account
     */
    private int creditLimit;

    /**
     * Constructor
     * @param name on vip customer
     * @param creditLimit for the vip customer
     */
    AccountVip(String name, int creditLimit) {
        super(name, true);
        this.creditLimit = creditLimit;
    }

    /**
     * This function override the regular one
     * @param withdrawalAmount from vip customer account and check so the amount is within credit limit
     */
    @Override
    public void withdrawal(int withdrawalAmount, int id) {
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
            // TODO: Rättat fel med att den la till ej genomförda transaktioner
            Storage.addVipTransaction(id, withdrawalAmount);
        }
    }

    /**
     * Get credit limit for vip customer
     * @return actual limit
     */
    int getCreditLimit() {
        return creditLimit;
    }
}


