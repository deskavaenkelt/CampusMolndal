/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/datalogiUppgift3slutuppgift
 */

import java.util.Date;

class Debug {

    protected static void start() {
        meny();
    }

    private static void meny() {
        System.out.println(
                "1. Print All lists\n" +
                "2. Import 12 strings\n" +
                        "3. Encrypt\n" +
                        "4. Print krypted string\n" +
                        "5. Decrypt\n" +
                        "6. Encrypt loop"
        );
        int action = UserInput.getNumber();
        switch (action) {
            case 1:
                printAllLists();
                break;
            case 2:
                importLists();
                break;
            /*case 3:
                encrypt();
                break;
            case 4:
                printKrytedString();
                break;
            case 5:
                decrypt();
                break;
            case 6:
                encryptLoop();
                break;*/
        }
    }

    private static void printAllLists() {
        System.out.println("Skriver ut allt som fins i arrayer...");
        System.out.println("Strings:     " + Arrays.getStrings().toString());
        System.out.println("Fibonachi:   " + Arrays.getFibonacci().toString());
        System.out.println("TimeStamp:   " + Arrays.getTimeStamp().toString());
        System.out.println("OddNumbers:  " + Arrays.getOddNumbers().toString());
        System.out.println("EvenNumbers: " + Arrays.getEvenNumbers().toString());
    }
    private static void importLists() {
        Arrays.setStrings("Januari");
        timeStamp();
        Arrays.setStrings("Februari");
        timeStamp();
        Arrays.setStrings("Mars");
        timeStamp();
        Arrays.setStrings("April");
        timeStamp();
        Arrays.setStrings("Maj");
        timeStamp();
        Arrays.setStrings("Juni");
        timeStamp();
        Arrays.setStrings("Juli");
        timeStamp();
        Arrays.setStrings("Augusti");
        timeStamp();
        Arrays.setStrings("September");
        timeStamp();
        Arrays.setStrings("Oktober");
        timeStamp();
        Arrays.setStrings("November");
        timeStamp();
        Arrays.setStrings("December");
        timeStamp();
    }
    private static void timeStamp(){
        Date date = new Date();
        Arrays.getTimeStamp().add(date);
        Fibonacci.addNewFibonacci();
    }

    /*private static void encrypt() {
        System.out.println("Encrypting...");
        Encryption.stringToEncrypt("oneplus");
    }

    private static void printKrytedString() {
        System.out.println("Printcrypted string...");
        Encryption.printEncryptedString();
    }

    private static void decrypt() {
        System.out.println("Decrypting...");
        Encryption.stringToDecrypt();
    }

    private static void encryptLoop() {
        encrypt();
        printKrytedString();
        decrypt();
    }*/
}

