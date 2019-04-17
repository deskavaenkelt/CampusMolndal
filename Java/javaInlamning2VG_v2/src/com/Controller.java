package com;

class Controller {

    // Customers
    static void addCustomer() {

        System.out.println("Enter customer name: ");
        String customerName = UserInput.getString();

        // Check if the customer should be vip
        System.out.print("Enable VIP status?\nYes = 1\nNo = 0\nChoice: ");
        int enableVipStatus = UserInput.getNumber();
        boolean isVip = false;
        int creditLimit = 0;

        if (1 == enableVipStatus) {
            isVip = true;

            System.out.println("Enter credit limit: ");
            creditLimit = UserInput.getNumber();

            System.out.println("VIP customer created.");
        } else if (0 == enableVipStatus) {
            System.out.println("Regular customer created.");
        } else {
            System.out.println("Not a valid choice");
        }

        Storage.addCustomer(customerName, isVip, creditLimit);
        //(new AccountVip(vipCustomerName, vipCreditLimit));
    }


 /*   static void updateCustomerName() {
        System.out.print("Enter ID: 0-" + (Storage.getCustomersVip().size()-1) + " to update:");
        int id = UserInput.getNumber();
        Storage.deleteVip(id);
    }
    static void updateCustomerStatus() {

    }*/

    static void deleteVip() {
        System.out.print("Enter ID: 0-" + (Storage.getCustomersVip().size()-1) + " to delete:");
        int id = UserInput.getNumber();
        Storage.deleteVip(id);
    }

    static void printCustomers() {
        for (int i = 0; i < Storage.getCustomersVip().size(); i++) {
            System.out.println("Nr: " + i +
                    " Customer: " + Storage.getCustomersVip().get(i).getName() +
                    ", have a balance of: " + Storage.getCustomersVip().get(i).getBalance() +
                    " SEK. VIP Customer = " + Storage.getCustomersVip().get(i).getVipStatus() +
                    ", credit limit: " + Storage.getCustomersVip().get(i).getCreditLimit() +
                    " SEK");
        }
    }

    static void importData(boolean choice) {
        if (choice) {
            System.out.println("Import Customers");

            // Import 3 Regular Customers
            Storage.addCustomer("Adam", false, 0);
            Storage.addCustomer("Bert", false, 0);
            Storage.addCustomer("Carl", false, 0);

            // Import 3 VIP Customers
            Storage.addCustomer("Dana", true, 1000);
            Storage.addCustomer("Erik", true, 2000);
            Storage.addCustomer("Fape", true, 3000);
        } else {
            System.out.println("Import Transactions");

            // Transactions for regular
            Storage.deposit(0,1000);
            Storage.deposit(1,100);
            Storage.deposit(2,10);
            Storage.deposit(0,20);
            Storage.deposit(1,200);
            Storage.deposit(2,2000);

            // Transactions for VIP
            Storage.deposit(3,3000);
            Storage.deposit(4,300);
            Storage.deposit(5,30);
            Storage.deposit(3,40);
            Storage.deposit(4,400);
            Storage.deposit(5,4000);
        }
    }

    static void deposit() {

        System.out.print("Input customer id 0-" + (Storage.getCustomersVip().size()-1) + ": ");
        int id = UserInput.getNumber();

        System.out.print("Amount to deposit: ");
        int amount = UserInput.getNumber();

        Storage.deposit(id, amount);
    }

    static void withdraw() {
        System.out.print("Input customer id 0-" + (Storage.getCustomersVip().size()-1) + ": ");
        int id = UserInput.getNumber();

        System.out.print("Amount to withdraw: ");
        int amount = UserInput.getNumber();

        Storage.withdraw(id, amount);
    }

    static void printTransactions() {
        // Print all transactions
        for (int i = 0; i < Storage.getCustomerTransactions().size(); i++) {
            System.out.println("Nr: " + i +
                    " Customer: " + Storage.getCustomerTransactions().get(i).getCustomerName() +
                    " Transferred: " + Storage.getCustomerTransactions().get(i).getAmount() + " SEK");
        }

        // Print the Banks Assets
        int bankAssetsAre = 0;
        for (int i = 0; i < Storage.getCustomerTransactions().size(); i++) {
            bankAssetsAre += Storage.getCustomerTransactions().get(i).getAmount();
        }
        System.out.println("\nThe banking assets are: " + bankAssetsAre + " SEK\n");
    }
}
