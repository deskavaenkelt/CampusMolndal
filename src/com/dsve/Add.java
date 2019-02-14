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
        System.out.println("Database contains: " + database.getDataHolder());
    }
    
    public static void sumOfArray() {
        int sum = 0;
        for (int i = 0; i < database.getDataHolder().size(); i++) {
            sum += Integer.parseInt(database.getDataHolder().get(i));
        }
        System.out.println("Sum of array is: " + sum);
        primeValidation(sum);
    }

    public static void searchForNumber() {
        int number = InputDialog.getNumber();
        if (number == -1) {
            return;
        }
        // Jag har ett giltligt nummer, kolla om det finns
        database.searchFor(number);
    }

    public static void importDatabase() {
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
        System.out.print("How many numbers to enter? ");
        int number = InputDialog.getNumber();
        if (number == -1) {
            return;
        }
        for (int i = 0; i < number; i++) {
            System.out.print("Enter number" + (i+1) + ": ");
            int multipleNumber = InputDialog.getNumber();
            primeValidation(multipleNumber);
        }
    }

    /*public static void sort() {
        int databaseLengt = database.getDataHolder().size();
        int[] arrayToBeSorted = new int[databaseLengt];

        for (int i = 0; i < databaseLengt; i++) {
            arrayToBeSorted[i] = Integer.parseInt(database.getDataHolder().get(i));
        }

        int temp = Integer.MAX_VALUE;
        int id = 0;

        for (int i = 0; i < arrayToBeSorted.length; i++) {
        }



        System.out.println("Database contains: " + Arrays.toString(arrayToBeSorted));
    }*/

    public static void sortArray() {
        clearTemporaryArrayLists();
        copyDatabaseToTemporaryDataHolder();


        System.out.println("Copied ArrayList: " + Arrays.toString(temporaryDataHolder.toArray()));

        /*int lowestNumberInList = Integer.MAX_VALUE;
        int idOfLowestNumber = Integer.MAX_VALUE;

        int counter = 0;

        while (database.getDataHolder().size() >= temporaryDataHolder.size()) {
            for (int i = 0; i < database.getDataHolder().size(); i++) {
                int temp = Integer.parseInt(database.getDataHolder().get(i));
                if (temp == numberToBeChecked) {
                    System.out.println(dataHolder.get(i) + " was found");
                }
        }



            newDistance = Math.abs(numberToBeChecked - temp);   // Extra
            if (newDistance < distance) {
                idClosest = i;
                distance = newDistance;
            }
        }*/
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
}
