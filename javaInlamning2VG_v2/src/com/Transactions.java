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
 * @since 2019-04-06.
 * https://github.com/deskavaenkelt/
 */

class Transactions {
    /**
     * This is my own functionality.
     * I want the name on the person that made the transaction and the positive or negative amount to store.
     */
    private String customerName;
    private int amount;

    /**
     * Constructor
     * @param customerName that med the transaction
     * @param amount they deposited or withdraw
     */
    Transactions(String customerName, int amount) {
        this.customerName = customerName;
        this.amount = amount;
    }

    // Only getters
    String getCustomerName() {
        return customerName;
    }

    int getAmount() {
        return amount;
    }
}
