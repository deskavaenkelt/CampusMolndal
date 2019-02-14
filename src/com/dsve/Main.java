package com.dsve;
/*
  __
 /\ \
 \_\ \    ____  __  __     __
 /'_` \  /',__\/\ \/\ \  /'__`\
/\ \L\ \/\__, `\ \ \_/ |/\  __/
\ \___,_\/\____/\ \___/ \ \____\
 \/__,_ /\/___/  \/__/   \/____/

*/

import java.util.ArrayList;

/**
 * datalogiUppgift2Primtal
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-02-13
 * https://github.com/deskavaenkelt/
 */

public class Main {
    public static void main(String[] args) {
        /*DataHolder databas = new DataHolder();

        databas.addDatahHolderItem(String.valueOf(89));
        databas.addDatahHolderItem(String.valueOf(79));
        databas.addDatahHolderItem(String.valueOf(69));
        databas.addDatahHolderItem(String.valueOf(59));

        System.out.println(databas.getDataHolder().get(0));

        System.out.println("Is dublicate: " + databas.isDuplicate(89));*/

        runProgram();
    }

    private static void runProgram() {
        boolean quit = false;

        while(!quit) {
            printActions();
            int action = InputDialog.getNumber();

            if (       action == 0
                    || action == 1
                    || action == 2
                    || action == 3
                    || action == 4
                    || action == 5
                    || action == 7) {
                switch (action) {
                    case 0:
                        System.out.println("\nShutting down...");
                        quit = true;
                        break;
                    case 1:
                        Add.start();
                        Add.sumOfArray();   //Extra
                        break;
                    case 2:
                        Sort.start();
                        break;
                    case 3:
                        Search.start();
                        break;
                    case 4:
                        Add.multipleNumbers();
                        Add.sumOfArray();
                        break;
                    case 5:
                        Add.printDatabase();
                        break;
                    case 7:
                        Add.importDatabase();
                        break;
                }
            }
        }
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:");
        System.out.println( "0  - Shutdown\n" +
                            "1  - Add\n" +
                            "2  - Sort\n" +
                            "3  - Search\n" +
                            "4  - Add multiple numbers\n" +
                            "5  - Print Database\n" +
                            "7  - Import Database\n");
        System.out.print("\nEnter action: ");
    }
}



















/*
* 88. Bug Fix for ArrayList Challenge innehåller mycket som löser uppgiften
* */