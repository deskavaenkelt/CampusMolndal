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
class Add {

    // Skapa databasen
    private static DataHolder database = new DataHolder();
    // Temporära databaser vid sortering, bara accessbara här
    private static ArrayList<Integer> temporaryDataHolder = new ArrayList<>();
    private static ArrayList<Integer> sortedList = new ArrayList<>();


    // 1. Add
    static void addNumber() {
        System.out.print("Enter a number: ");
        getNumber();
    }
    private static void getNumber() {
        // Läs in nummer
        int number = InputDialog.getNumber();
        if (number == -1) {
            return;
        }
        // Jag har ett giltligt nummer, kolla om det är ett primtal
        primeValidation(number);
    }
    private static void primeValidation(int number) {
        // Kolla om number är ett primtal
        if (Prime.getPrime(number)) {
            // Kolla om talet redan finns i databasen
            if (!database.isDuplicate(number)) {
                // Spara i datastruktur om false
                database.addDatahHolderItem(String.valueOf(number));
            }
        }
    }

    // Add.d) extra Summera alla talen i listan och kontrollera om det är ett primtal, isf sätt in i listan
    static void sumOfArray() {
        sumOfArrayInternal();
    }
    private static void sumOfArrayInternal() {
        // Summering av alla tal
        int sum = 0;
        for (int i = 0; i < database.getDataHolder().size(); i++) {
            sum += Integer.parseInt(database.getDataHolder().get(i));
        }
        System.out.println("Sum of array is: " + sum);
        // Validering om det är ett primtal och validera så det inte finns en dublett
        primeValidation(sum);
    }



    // 2. Sort
    static void sortArray() {
        sortArrayInternal();
    }
    private static void sortArrayInternal() {
        boolean isArrayListIsEmpty = database.getDataHolder().isEmpty();

        if (isArrayListIsEmpty) {
            System.out.println("No numbers in database!");
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



    // 3. Search
    static void searchForNumber() {
        searchForNumberInternal();
    }
    private static void searchForNumberInternal() {
        // kontrollera om databasen är tom, true if empty
        boolean isArrayListIsEmpty = database.getDataHolder().isEmpty();

        if (isArrayListIsEmpty) {                           // Databasen är tom
            System.out.println("No numbers in database!");
        } else {                                            // Databasen är INTE tom
            int number = InputDialog.getNumber();
            if (number == -1) {
                return;
            }
            // Jag har ett giltligt nummer, kolla om det finns i databasen, anropa searchFor i DataHolder
            database.searchFor(number);
        }


    }



    // 4. Extra-uppgift: Skriv in multipla tal
    static void multipleNumbers(){
        multipleNumbersInternal();
    }
    private static void multipleNumbersInternal(){
        System.out.print("\nHow many numbers to enter? ");
        int number = InputDialog.getNumber();

        // Extra radbryt för snyggare program
        System.out.println();
        if (number == -1) {
            return;
        }

        // Lopa antalet begärda inmatningar och validera om primtal
        for (int i = 0; i < number; i++) {
            System.out.print("Enter number" + (i+1) + ": ");
            int multipleNumber = InputDialog.getNumber();
            primeValidation(multipleNumber);
        }
    }



    // 8. Skriver ut databasen
    static void printDatabase(){
        printDatabaseInternal();
    }
    private static void printDatabaseInternal(){
        System.out.println("Database contains: " + database.getDataHolder());
    }



    // 9. Min egen import av nummer för att spara tid =P
    static void importDatabase() {
        importDatabaseInternal();
    }
    private static void importDatabaseInternal() {
        // Anropar primeValidation direkt, då jag inte har någon user input
        primeValidation(5);
        primeValidation(13);
        primeValidation(3);
        primeValidation(11);
        primeValidation(2);
        primeValidation(7);
        // Printa importerade nummer
        printDatabase();
        // Kontrollera om summan är pimtal
        sumOfArray();
        // Printa den nya arreyListen
        printDatabase();
    }
}
