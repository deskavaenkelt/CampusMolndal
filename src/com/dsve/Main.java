package com.dsve;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    long number = 17L;

        System.out.println("Är inmatat numer ett primtal? " + isPrime(number));

    }

    public static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        for (long i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}


/*
* 88. Bug Fix for ArrayList Challenge innhåller mycket som löser uppgiften
* */