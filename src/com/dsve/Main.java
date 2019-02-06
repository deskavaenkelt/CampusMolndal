package com.dsve;

public class Main {

    public static void main(String[] args) {
        char[] charArray1 = { 's', 't', 'r', 'i', 'n', 'g' };
        char[] charArray2 = { 's', 'i', 'n', 'g' };

        String[] returArray = {"\ncharArray1 returnerar: " , "\ncharArray2 returnerar: " };

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
        compareTwoArrays(charArray1,charArray2);

        // TODO: e)
        // Skapa input-fält

        // TODO: f)
        // t -> T

        // TODO: g)
        // t -> T

        // TODO: h)
        // t -> T



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
        for (i = 0; i < (charArray1.length) && (i < charArray2.length) ; i++) {
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
}
