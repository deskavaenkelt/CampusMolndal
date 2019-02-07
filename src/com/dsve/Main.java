package com.dsve;

import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        /*char[] charArray1 = { 's', 't', 'r', 'i', 'n', 'g' };
        char[] charArray2 = { 's', 'i', 'n', 'g' };

        // TODO: Startuppgift
        System.out.println("Startuppgift");
        char[] computedCharArray1 = detectTInArray(charArray1, 1);
        char[] computedCharArray2 = detectTInArray(charArray2, 2);

        // TODO: a)
        // changAllRtoT
        // in detectTInArray

        // TODO: b)
        // toUppercase(char[] charArray)
        // in detectTInArray

        // TODO: c)
        // removeDoublets()
        // in detectTInArray

        // TODO: d)
        // compareTwoArrays
        compareTwoArrays(computedCharArray1, computedCharArray2);
        compareTwoArrays(charArray1,charArray2);*/

        // TODO: e)
        //  Skapa input-fält
        //inputField();

        // TODO: f)
        // t -> T

        // TODO: g)
        // t -> T

        // TODO: h)
        // t -> T

        System.out.println(getValidCharArray(3));
        scan.close();
    }

    private static char[] detectTInArray(char[] charArray, int id) {
        // TODO: om input innehåller t. Om sant skriv ut true på skärmen, annars false
        // TODO: ska kunna hanterqa andra arrays

        boolean returnValue = false;

        int i;
        for (i = 0; i < charArray.length; i++) {
            if ('t' == charArray[i]) {
                returnValue = true;
            }
        }
        System.out.println("charArray" + id + " i detectTInArray returnerar: " + returnValue);

        changeAllRtoT(charArray);
//        System.out.println(charArray);  // Debugg

        toUppercase(charArray);
//        System.out.println(charArray);  // Debugg

        charArray = removeDoublets(charArray);
//        System.out.println(charArray);  // Debugg

        return charArray;
    }

    private static void changeAllRtoT(char[] charArray) {
        int i;
        for (i = 0; i < charArray.length; i++) {
            if ('r' == charArray[i]) {
                charArray[i] = 't';
            }
        }
    }

    private static void toUppercase(char[] charArray) {
        int i;
        for (i = 0; i < charArray.length; i++) {
            if ('t' == charArray[i]) {
                charArray[i] = 'T';
            }
        }
    }

    private static char[] removeDoublets(char[] charArray) {
        String onlyRemoveT = "";

        int i;
        for (i = 0; i < charArray.length; i++) {
            if ('T' != charArray[i]) {
                onlyRemoveT += charArray[i];
            }
        }
        return onlyRemoveT.toCharArray();
    }

    private static void compareTwoArrays(char[] charArray1, char[] charArray2) {
        boolean isIdentical = true;
        int i;
        for (i = 0; i < (charArray1.length) && (i < charArray2.length); i++) {
            if (charArray1[i] != charArray2[i]) {
                isIdentical = false;
            }
        }
        if (isIdentical) {
            System.out.println("Array 1 and Array 2 are identical");
        } /*else {
            System.out.println("Array 1 and Array 2 missmatched");  // Debugg
        }*/
    }

    private static void inputField() {
        // TODO: e)
        //  1) String tar emot vad som helst.   ==> userInputStringToCharArray()
        //  2) Sätt in i en char array[3]       ==> getValidCharArray()
        //  3) Om denna array är fylld skall programmet fråga om ny input
        //  4) I denna input skall en siffra skrivas in för vilken plats i er array som skall ersättas med det nya värdet.
        //  5) Programmet skall därefter sätta in det nya värdet på begärd plats och skriva ut er array.
        //  6) När detta är gjort skall programmet begära ny input om input är tom skall programmet brytas.

        char[] aCharArray = getValidCharArray(3);
        System.out.println("aCharArray: " + aCharArray);                // debug

        int replaceCharAtPos = userInputReadNumbers(0, 2);
        System.out.println("replaceCharAtPos: " + replaceCharAtPos);    // debug

        char[] replaceCharWith = getValidCharArray(1);
        System.out.println("replaceCharWith: " + replaceCharWith);      // debug

    }

    private static char[] getValidCharArray(int maxLengtOfReturnedCharArray) {
        char[] inputFieldCharArray = new char[maxLengtOfReturnedCharArray];
        boolean isInputFieldCharArrayFull = false;

        int i = 0;
        while (!isInputFieldCharArrayFull) {
            System.out.println("\nÄr inne i while-loop\n");           // debug
            char[] recivedInput = userInputStringToCharArray();
            for (; i < maxLengtOfReturnedCharArray; i++) {
                if (recivedInput[i] != ' ') {
                    inputFieldCharArray[i] = recivedInput[i];
                }
            }
            if (inputFieldCharArray[maxLengtOfReturnedCharArray - 1] != ' ') {
                isInputFieldCharArrayFull = true;
            }
        }
        return inputFieldCharArray;
    }

    private static char[] userInputStringToCharArray() {
        System.out.print("Skriv in en sträng: ");
        String userInput = scan.nextLine();
        char[] returningCharArray = userInput.toCharArray();
        return returningCharArray;
    }           // kontrollerad och fungerar, returnerar hel stäng utan vidare kontroll

    private static int userInputReadNumbers(int min, int max) {
        System.out.print("Skriv in ett tal mellan " + min + "-" + max + ": ");
        int scannedInt = 0;
        boolean dontBreakLoop = true;

        while (dontBreakLoop) {
            boolean hasNextInt = scan.hasNextInt();
            if (hasNextInt) {
                scannedInt = scan.nextInt();
                scan.nextLine(); // handle next line character (enter key)
                if (scannedInt >= min && scannedInt <= max) {
                    dontBreakLoop = false;
                } else {
                    System.out.println("Mata in giltlig siffra");
                }
            }
        }
        return scannedInt;
    }    // kontrollerad och fungerar
}
