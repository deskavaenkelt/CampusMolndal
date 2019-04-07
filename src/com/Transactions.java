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
    private String customerName;
    private int amount;

    Transactions(String customerName, int amount) {
        this.customerName = customerName;
        this.amount = amount;
    }

    String getCustomerName() {
        return customerName;
    }

    int getAmount() {
        return amount;
    }
}
