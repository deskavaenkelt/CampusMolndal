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
    private static boolean quit;
    protected static void start() {
        meny();
    }

    private static void meny() {
        quit = false;
        while (!quit) {
            System.out.println("\n" +
                    "+----------------------------+\n" +
                    "| 1. Import 12 strings       |\n" +
                    "| 2. Print All lists         |\n" +
                    "| 3. Encrypt                 |\n" +
                    "| 4. Print krypted string    |\n" +
                    "| 5. Decrypt                 |\n" +
                    "| 6. Encrypt loop            |\n" +
                    "| 9. Exit meny               |\n" +
                    "+----------------------------+\n\n" +
                    "Ditt Val: "
            );
            int action = UserInput.getNumber();
            switch (action) {
                case 1:
                    importLists();
                    break;
                case 2:
                    printAllLists();
                    break;
                case 3:
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
                    break;
                case 9:
                    System.out.println("Leaving meny...");
                    quit = true;
                    break;
                case 0:
                    easter();
                    break;
            }
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

    private static void encrypt() {

    }

    private static void printKrytedString() {

    }

    private static void decrypt() {

    }

    private static void encryptLoop() {
        /*encrypt();
        printKrytedString();
        decrypt();*/

        String encryptThis = "oneplus";
        System.out.println("String to encrypt: " + encryptThis);
        String thisIsEncrypted = Encryption.stringToEncrypt(encryptThis);
        int indexId = 0;
        Arrays.setStrings(thisIsEncrypted); // lagra i databas
        System.out.println("Encrypted string:  " + Arrays.getStrings().get(indexId));
        System.out.println("Decrypting...");
        String encryptedStringFromArrayList = Arrays.getStrings().get(indexId);
        String thisIsDecrypted = Encryption.stringToDecrypt(encryptedStringFromArrayList);
        System.out.println("Decrypted string:  " + thisIsDecrypted);
    }

    private static void easter() {
        egg();
    }
    private static void egg() {
        print();
    }
    private static void print() {
        System.out.println(
            "####################################################################################\n" +
            "#                                                                                  #\n" +
            "#                                                                                  #\n" +
            "#                                                                                  #\n" +
            "#                  Function Key                                                    #\n" +
            "#                  /                                                               #\n" +
            "#              __n___                                                              #\n" +
            "#              I    I                   _________                                  #\n" +
            "#      Main  _ I    I   Floppy disk     I  ___  I                                  #\n" +
            "#     Storage  I    I  '                I=(___)=I   - Application Software         #\n" +
            "#              I    I I                 I_/  /__I                                  #\n" +
            "#              I    I I    INPUT        ~~\\  \\~~~                                  #\n" +
            "#              (____) I     |             /__/                                     #\n" +
            "#                II   I___________                                                 #\n" +
            "#                I(___/___________) - User Interface         Debugging Tool        #\n" +
            "#                (__             I                                    \\ __         #\n" +
            "#                   I            /                                      II         #\n" +
            "#                    \\          / - Central                             II         #\n" +
            "#                     )        /   Processing                           II         #\n" +
            "#         OUTPUT --  I        (       Unit           .-._               II         #\n" +
            "#                    I_________`,                  o_oo'_)              II         #\n" +
            "#                    ~~~~~***&%~                   `._ `._              II         #\n" +
            "#                       ###@^&&&                     `,   \\            /__\\        #\n" +
            "#       ._____._        &&&%%## - Overflow            //_(_)_/         ~~~~        #\n" +
            "#       I      o)                (I/O error)         ~~                            #\n" +
            "#       (_____,-'                                         Mouse                    #\n" +
            "#                                                                                  #\n" +
            "#        Backup System                                                             #\n" +
            "#                                                                                  #\n" +
            "#                                                                                  #\n" +
            "#                                                                                  #\n" +
            "####################################################################################\n"
        );
        UserInput.getNumber();
    }
}

