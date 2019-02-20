/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/datalogiUppgift3slutuppgift
 */

import java.util.Random;
class Encryption {
    private static Random randomizer = new Random();
    private static int kryptoLengt = 5;


    /**
     * Encryption part
     * Example to use:
     *      String encryptThis = "abcd";
     *      System.out.println("String to encrypt: " + encryptThis);
     *      String thisIsEncrypted = Encryption.stringToEncrypt(encryptThis);
     *
     *   Print what is stored in arraylist
     *      int indexId = 0;
     *      Arrays.setStrings(thisIsEncrypted); // lagra i databas
     *      System.out.println("Encrypted string:  " + Arrays.getStrings().get(indexId));
     */
    protected static String stringToEncrypt(String sometingToEncrypt) {
        return encrypt(sometingToEncrypt);
    }
    private static String encrypt(String encryptThis) {
        String newEncryptedString = changePosition(encryptThis);
        return newEncryptedString;
    }
    /**
     * Move chars x positions
     */
    private static String changePosition(String changeChars) {
        String stringToReturn = "";
        int dec;
        for (int i = 0; i < changeChars.length(); i++) {
            dec = changeChars.charAt(i);
            dec += 4;
            stringToReturn += (char)dec;
        }
        return stringToReturn;
    }
    /**
     * Used to fill upp a string of 256 characters
     */
    private static char inputRandomChars() {
        // TODO: generera 256 tecken lång hash/salt
        //       sätt börja fylla på kryperad data på hash indexId 82 105 99 107 97 114 100 32 103 101 114 32 111 115 115 32 86 71 = 1616
        //       1616/256= 6,3125 ==> element 80 varav 7
        String alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM+0987654321§½!#¤%&/()=?@£$€{[]}";
        return alphabet.charAt(randomizer.nextInt(alphabet.length()));
    }


    /**
     * Decryption part
     * Example to use:
     *      String encryptedStringFromArrayList = Arrays.getStrings().get(indexId);
     *      String thisIsDecrypted = Encryption.stringToDecrypt(encryptedStringFromArrayList);
     *      System.out.println("Decrypted string:  " + thisIsDecrypted);
     */
    protected static String stringToDecrypt(String decryptThis) {
        return decrypt(decryptThis);
    }
    private static String decrypt(String decryptThis) {
        String newDecryptedString = changePositionRevert(decryptThis);
        return newDecryptedString;
    }
    /**
     * Revert - "Move chars x positions"
     */
    private static String changePositionRevert(String changeChars) {
        String stringToReturn = "";
        int dec;
        for (int i = 0; i < changeChars.length(); i++) {
            dec = changeChars.charAt(i);
            dec -= 4;
            stringToReturn += (char)dec;
        }
        return stringToReturn;
    }



    /**
     * Search function returns index ID
     * If function returns -1, the searched for string was not found
     */
    // TODO: search utan att decryptera
    protected static int searchEncrypt(String stringToSearchFor) {
        return searchEncryptInternal(stringToSearchFor);
    }
    private static int searchEncryptInternal(String stringToSearchFor) {
        int idToReturn = -1;
        String encryptedStringToSerchFor = encrypt(stringToSearchFor);
        if (Arrays.getStrings().contains(encryptedStringToSerchFor)) {              // if searchFor exist == true => get position
            idToReturn = Arrays.getStrings().indexOf(encryptedStringToSerchFor);
        }
        return idToReturn;
    }


    /* rest kod
    for (int i = 0; i < lengtOfString; i++) {
            for (int j = 0; j < kryptoLengt; j++) {
                newEncryptedString += inputRandomChars();
            }
            newEncryptedString += encryptThis.charAt(i);
        }
        for (int j = 0; j < kryptoLengt; j++) {
            newEncryptedString += inputRandomChars();
        }
     */

    /*String decryptedString = "";
        int counter = kryptoLengt;
        for (int i = 0; i < decryptThis.length(); i++) {
            decryptedString += decryptThis.charAt(counter);
            counter += (kryptoLengt+1);
            if (counter >= decryptThis.length()) {
                break;
            }
        }
        return decryptedString;*/
















}
