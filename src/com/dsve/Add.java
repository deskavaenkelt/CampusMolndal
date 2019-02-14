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
import java.util.Arrays;

/**
 * datalogiUppgift2Primtal
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-02-13
 * https://github.com/deskavaenkelt/
 */
public class Add {
    private static DataHolder database = new DataHolder();
    private static ArrayList<Integer> temporaryDataHolder = new ArrayList<>();
    private static ArrayList<Integer> sortedList = new ArrayList<>();

    public static void start() {
        System.out.print("Skriv in ett tal: ");
        getNumber();
    }
    private static void getNumber() {
        int number = InputDialog.getNumber();
        if (number == -1) {
            return;
        }
        // Jag har ett giltligt nummer, kolla om det är ett primtal
        primeValidation(number);
    }
    private static void primeValidation(int number) {
        if (Prime.getPrime(number)) {
            // Kolla om talet redan finns i databasen
            if (!database.isDuplicate(number)) {
                // Spara i datastruktur
                database.addDatahHolderItem(String.valueOf(number));
            }
        } else {
            return;
        }
    }

    public static void printDatabase(){
        printDatabaseInternal();
    }
    private static void printDatabaseInternal(){
        System.out.println("Database contains: " + database.getDataHolder());
    }

    public static void sumOfArray() {
        sumOfArrayInternal();
    }
    private static void sumOfArrayInternal() {
        int sum = 0;
        for (int i = 0; i < database.getDataHolder().size(); i++) {
            sum += Integer.parseInt(database.getDataHolder().get(i));
        }
        System.out.println("Sum of array is: " + sum);
        primeValidation(sum);
    }

    public static void searchForNumber() {
        searchForNumberInternal();
    }
    private static void searchForNumberInternal() {
        boolean isArrayListIsEmpty = database.getDataHolder().isEmpty();

        if (isArrayListIsEmpty) {
            System.out.println("No numbers in database!");
            return;
        } else {
            int number = InputDialog.getNumber();
            if (number == -1) {
                return;
            }
            // Jag har ett giltligt nummer, kolla om det finns
            database.searchFor(number);
        }


    }

    public static void importDatabase() {
        importDatabaseInternal();
    }
    private static void importDatabaseInternal() {
        primeValidation(5);
        primeValidation(13);
        primeValidation(3);
        primeValidation(11);
        primeValidation(2);
        primeValidation(7);
        printDatabase();
        sumOfArray();
        printDatabase();
    }

    public static void multipleNumbers(){
        multipleNumbersInternal();
    }
    private static void multipleNumbersInternal(){
        System.out.print("\nHow many numbers to enter? ");
        int number = InputDialog.getNumber();
        System.out.println();
        if (number == -1) {
            return;
        }
        for (int i = 0; i < number; i++) {
            System.out.print("Enter number" + (i+1) + ": ");
            int multipleNumber = InputDialog.getNumber();
            primeValidation(multipleNumber);
        }
    }

    // TODO: Sort
    public static void sortArray() {
        sortArrayInternal();
    }
    private static void sortArrayInternal() {
        boolean isArrayListIsEmpty = database.getDataHolder().isEmpty();

        if (isArrayListIsEmpty) {
            System.out.println("No numbers in database!");
            return;
        } else {
            clearTemporaryArrayLists();
            copyDatabaseToTemporaryDataHolder();
            sort();
            System.out.println("Sorted ArrayList:  " + Arrays.toString(sortedList.toArray()));
        }
    }
    private static void clearTemporaryArrayLists() {
        temporaryDataHolder.clear();
        sortedList.clear();
    }
    private static void copyDatabaseToTemporaryDataHolder() {
        for (int i = 0; i < database.getDataHolder().size(); i++) {
            temporaryDataHolder.add(Integer.parseInt(database.getDataHolder().get(i)));
        }
    }
    private static void sort() {
        int databaseLengt = database.getDataHolder().size();
        int sortedArrayLengt = sortedList.size();

        boolean flag = true;
        while (flag) {
            flag =false;
            int newLowestNumber = temporaryDataHolder.get(0);
            int idOfLowestNumber = 0;
            for (int i = 0; i < databaseLengt; i++) {
                if (temporaryDataHolder.get(i) < newLowestNumber) {
                    newLowestNumber = temporaryDataHolder.get(i);
                    idOfLowestNumber = i;
                }
            }
            sortedList.add(temporaryDataHolder.get(idOfLowestNumber));
            temporaryDataHolder.remove(idOfLowestNumber);
            databaseLengt--;

            if (sortedArrayLengt < databaseLengt) {
                flag = true;
            }
        }
    }

}
