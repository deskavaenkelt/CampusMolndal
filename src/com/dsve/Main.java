package com.dsve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static char[] charArray1 = { 's', 't', 'r', 'i', 'n', 'g' };
    public static char[] charArray2 = { 's', 'i', 'n', 'g' };

    public static boolean globalFlag = true;
    public static char[] charArrayE = new char[3];
    public static ArrayList<String> stringArrayF = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: Kör uppgift A till D
        runAtoD();

        // TODO: Kör uppgift E till G
        inputField();

        scan.close();
    }

    private static void runAtoD() {
        System.out.println("Uppgift A-D");
        char[] computedCharArray1 = detectTInArray(charArray1, 1);
        char[] computedCharArray2 = detectTInArray(charArray2, 2);
        compareTwoArrays(computedCharArray1, computedCharArray2);
        //compareTwoArrays(charArray1,charArray2);
    }


    // 0)
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
        System.out.println("\ncharArray" + id + " returnerar: " + returnValue);

        System.out.println("0) " + Arrays.toString(charArray));

        changeAllRtoT(charArray);

//        System.out.println(charArray);  // Debugg
        toUppercase(charArray);
//        System.out.println(charArray);  // Debugg

        charArray = removeDoublets(charArray);
        System.out.println("c) " + Arrays.toString(charArray));
//        System.out.println(charArray);  // Debugg

        return charArray;
    }
    // a)
    private static void changeAllRtoT(char[] charArray) {
        int i;
        for (i = 0; i < charArray.length; i++) {
            if ('r' == charArray[i]) {
                charArray[i] = 't';
            }
        }
        System.out.println("a) " + Arrays.toString(charArray));
    }
    // b)
    private static void toUppercase(char[] charArray) {
        int i;
        for (i = 0; i < charArray.length; i++) {
            if ('t' == charArray[i]) {
                charArray[i] = 'T';
            }
        }
        System.out.println("b) " + Arrays.toString(charArray));
    }
    // c)
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
    // d)
    private static void compareTwoArrays(char[] charArray1, char[] charArray2) {
        boolean isIdentical = true;
        int i;
        for (i = 0; i < (charArray1.length) && (i < charArray2.length); i++) {
            if (charArray1[i] != charArray2[i]) {
                isIdentical = false;
            }
        }
        System.out.println("\nd) \n" + Arrays.toString(charArray1) + "\n" + Arrays.toString(charArray2));
        if (isIdentical) {
            System.out.println("Array 1 and Array 2 are identical\n");
        } /*else {
            System.out.println("Array 1 and Array 2 missmatched");  // Debugg
        }*/
    }



    private static void inputField() {
        System.out.println("Uppgift E-G)");

        while (globalFlag) {
            System.out.print("Skriv in en char: ");
            String temp = getStringInput(false);
            if (!globalFlag) {
                break;
            }
            //System.out.println("stringArrayF innehåller: " + Arrays.toString(stringArrayF.toArray()));  // debug
            //System.out.println("Returnerat värde: " + temp.charAt(0)); //debug
            int placeHolder = getIntInput(0, 2);
            if (!globalFlag) {
                break;
            }
            charArrayE[placeHolder] = temp.charAt(0);
        }

        System.out.println("\ne)\n" + Arrays.toString(charArrayE));                     // e)

        System.out.println(toFormattedString(charArrayE));
        
        System.out.println("\nf)\n" + Arrays.toString(stringArrayF.toArray()));         // f)

    }
    private static String getStringInput(boolean isNumber) {
        String userInput = scan.nextLine();
        int length = userInput.length();
        if (length == 0) {
            globalFlag = false;
            return "*";
        }
        if (!isNumber) {
            addToStringArray(userInput);    // g)
        }
        return userInput;
    }                        // g)
    private static int getIntInput(int min, int max) {
        System.out.print("Skriv in ett tal mellan " + min + "-" + max + ": ");
        int userInput = -1;

        boolean flag = true;
        while (flag) {
            flag = false;

            String temp = getStringInput(true);
            if (temp.charAt(0) == '0' || temp.charAt(0) == '1' || temp.charAt(0) == '2') {
                userInput = Integer.parseInt(temp);

                if (userInput >= min && userInput <= max) {
                    return userInput;
                } else {
                    System.out.println("Mata in giltlig siffra");
                    flag = true;
                }

            } else {
                globalFlag = false;
                return -1;
            }
        }
        return userInput;
    }
    private static void addToStringArray(String input) {
        stringArrayF.add(input);
    }
    public static String toFormattedString(char[] a)
    {
        if (a.length==1) return String.valueOf(a[0]);
        else
            return a[0]+toFormattedString(Arrays.copyOfRange(a,1,a.length)) ;

    }
}


