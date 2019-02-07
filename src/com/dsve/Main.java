package com.dsve;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static boolean globalFlag = true;

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
        //  1) Skapa stringarray men en plats
        //  2)
        //  3)
        //  4)
        //  5)
        //  6)
        //  7)

        // TODO: g)
        //  1)
        //  2)
        //  3)
        //  4)
        //  5)
        //  6)
        //  7)

        // TODO: h)
        //  1)
        //  2)
        //  3)
        //  4)
        //  5)
        //  6)
        //  7)

//        char[] temp = getValidCharArray(3);
//        System.out.println("Returneras från getValidCharArray: " + Arrays.toString(temp));
        inputField();
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
        //  1) String tar emot vad som helst.   ==> userInputString()
        //  2) Sätt in i en char array[3]       ==> getValidCharArray()
        //  3) Om denna array är fylld skall programmet fråga om ny input               ej null mm, måste få plats i char
        //  4) I denna input skall en siffra skrivas in för vilken plats i er array som skall ersättas med det nya värdet.
        //  5) Programmet skall därefter sätta in det nya värdet på begärd plats och skriva ut er array.
        //  6) När detta är gjort skall programmet begära ny input om input är tom skall programmet brytas.
        //  7) Tom input bryter programmet.

        char[] aCharArray = getValidCharArray(3);
        System.out.println("aCharArray: " + Arrays.toString(aCharArray));                // debug

        globalFlag = true;
        while (globalFlag) {
            globalFlag = false;

            int replaceCharAtPos = userInputReadNumbers(0, 2);
            System.out.println("replaceCharAtPos: " + replaceCharAtPos);                     // debug

            char[] replaceCharWith = getValidCharArray(1);
            System.out.println("replaceCharWith: " + Arrays.toString(replaceCharWith));      // debug
        }


    }

    private static char[] getValidCharArray(int maxLengtOfReturnedCharArray) {

        char[] inputFieldCharArray = new char[maxLengtOfReturnedCharArray];
        boolean flag = true;

        int i;
        int counter = 0;
        while (flag) {
            flag = false;
            String recivedString = userInputString();
            char[] tempCharArray = recivedString.toCharArray();

            for (i = 0; i < tempCharArray.length; i++) {
                inputFieldCharArray[counter] = tempCharArray[i];
                counter++;
                if (counter == 3) {
                    break;
                }
            }
            if (counter < maxLengtOfReturnedCharArray) {
                flag = true;
            }
        }
        return inputFieldCharArray;
    }   // Kontrollerad och fungerar

    private static String userInputString() {
        globalFlag = true;
        System.out.print("Skriv in en sträng: ");
        String userInput = scan.nextLine();
        if (userInput.isEmpty()) {
            globalFlag = false;
        }
        return userInput;
    }           // kontrollerad och fungerar, returnerar hel stäng utan vidare kontroll

    private static int userInputReadNumbers(int min, int max) {
        globalFlag =true;
        System.out.print("Skriv in ett tal mellan " + min + "-" + max + ": ");
        int scannedInt = 0;
        boolean dontBreakLoop = true;

        int temp = scan.hasNextInt();

        while (dontBreakLoop) {
            boolean hasNextInt = scan.hasNextInt();
            if (hasNextInt) {
                scannedInt = scan.nextInt();
                scan.nextLine(); // handle next line character (enter key)
                if (scannedInt >= min && scannedInt <= max) {
                    dontBreakLoop = false;
                } else if (scannedInt == ' ') {
                    globalFlag = false;
                } else {
                    System.out.println("Mata in giltlig siffra");
                }
            }
        }
        return scannedInt;
    }    // kontrollerad och fungerar
}
