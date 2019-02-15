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

/**
 * datalogiUppgift2Primtal
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-02-13
 * https://github.com/deskavaenkelt/
 */
public class Prime {

    public static boolean getPrime(int numberToTest) {
        return getPrimeInternal(numberToTest);
    }

    // Kontrollera om primtal, returnera en boolean
    private static boolean getPrimeInternal(int numberToTest) {
        boolean result = isPrime(numberToTest);
        if (result) {
            System.out.println(numberToTest + " is a Prime number\n");
        } else {
            System.out.println(numberToTest + " is NOT a Prime number\n");
        }
        return result;
    }

    // Verifierar number
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}