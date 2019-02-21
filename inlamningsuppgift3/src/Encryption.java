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

    public static boolean checkPassword (String input) {
        return validPassword(input);
    }

    private static boolean validPassword(String input) {
        if (input.equals(key)) {
            return true;
        } else {
            return false;
        }
    }

    private static String key = "Rickard ger oss VG";  // keySum is 1616 => 1616/256= 6,3125 ==> element 80 på varav 7.

    // Encrypt
    protected static String stringToEncrypt(String sometingToEncrypt) {
        return encrypt(sometingToEncrypt);
    }
    private static String encrypt(String encryptThis) {
        StringBuilder newRandomString = new StringBuilder(getRandomSting());
        String encryptedString = changePosition(encryptThis);
        int startPosition = offset();

        // Save the lengt off the string in the first to elements
        String hex=Integer.toHexString(encryptedString.length());
        if (encryptThis.length() < 16) {
            newRandomString.insert(0, 0);
            newRandomString.insert(1, hex.charAt(0));
        } else {
            newRandomString.insert(0, hex.charAt(0));
            newRandomString.insert(1, hex.charAt(1));
        }

        // Put encrypted string in startPosition
        for (int i = 0; i < encryptedString.length(); i++) {
            newRandomString.replace(startPosition,startPosition+encryptedString.length(), encryptedString);
        }

        return newRandomString.toString();
    }


    // Sub-parts to encryption
    /** Offset I want to use */
    private static int offset() {
        // TODO: sätt börja fylla på kryperad data på hash indexId 82 105 99 107 97 114 100 32 103 101 114 32 111 115 115 32 86 71 = 1616
        //       1616/256= 6,3125 ==> element 80 varav 7
        int keySum = 0;

        for (int i = 0; i < key.length(); i++) {
            keySum += key.charAt(i);
        }

        // ASCII table is 128 element long, divide by that, input our
        int returnModulus = keySum%128;
        return returnModulus;
    }
    /** Move chars x positions */
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
    /** Used to fill upp a string of 256 characters -2 that i add manually with hex*/
    private static String getRandomSting() {
        Random randomizer = new Random();
        String alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM+0987654321§½!#¤%&/()=?@£$€{[]}";
        String myHash = "";
        for (int i = 0; i < 263; i++) {
            myHash += alphabet.charAt(randomizer.nextInt(alphabet.length()));
        }
        return myHash;
    }





    /**
     * Decryption part
     * Example to use:
     *      String encryptedStringFromArrayList = Arrays.getStrings().get(indexId);
     *      String thisIsDecrypted = Encryption.stringToDecrypt(encryptedStringFromArrayList);
     *      System.out.println("Decrypted string:  " + thisIsDecrypted);
     */

    // Decrypt
    protected static String stringToDecrypt(String decryptThis) {
        return decrypt(decryptThis);
    }
    private static String decrypt(String decryptThis) {
        // Get hexadecimal number for lengt of string
        String hex = decryptThis.substring(0, 2);

        // Convert hex to int
        int hexValue = Integer.parseInt(hex, 16);

        // Get the real data from the string
        String stringToDecrypt = decryptThis.substring(offset(), offset() + hexValue);

        // Revert encryption
        return changePositionRevert(stringToDecrypt);
    }


    // Sub-parts to decryption
    /** Revert - "Move chars x positions" */
    private static String changePositionRevert(String changeChars) {
        StringBuilder stringToReturn = new StringBuilder();
        int dec;
        for (int i = 0; i < changeChars.length(); i++) {
            dec = changeChars.charAt(i);
            dec -= 4;
            stringToReturn.append((char)dec);
        }
        return stringToReturn.toString();
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

        String temp = "";
        for (int i = 0; i < Arrays.getStrings().size(); i++) {
            temp = decrypt(Arrays.getStrings().get(i));
            if (temp.equals(stringToSearchFor)) {
                idToReturn = i;
                break;
            }
        }
        return idToReturn;

        /*// Get hexadecimal number for lengt of string
        int hexLength = stringToSearchFor.length();

        String encryptedStringToSerchFor = changePosition(stringToSearchFor);

        // Compare "encryptedStringToSerchFor" with data in database
        StringBuilder getEncryptedStringToCompare = new StringBuilder();
        for (int i = 0; i < hexLength; i++) {
            getEncryptedStringToCompare.append()
        }

        //String getEncryptedStringToCompare = stringToSearchFor.substring(offset(), offset() + hexLength);
        System.out.println("getEncryptedStringToCompare: " + getEncryptedStringToCompare);

        String temp = "";
        for (int i = 0; i < hexLength; i++) {
            temp = Arrays.getStrings().get(i);
            if (temp.substring(offset(), offset() + hexLength) == getEncryptedStringToCompare) {
                idToReturn = i;
            }
        }*/

        /*if (Arrays.getStrings().contains(encryptedStringToSerchFor)) {              // if searchFor exist == true => get position
            idToReturn = Arrays.getStrings().indexOf(encryptedStringToSerchFor);
        }*/
    }



    // Legacy/failsafe
    private static String buildEncryptedString(String encryptThis) {
        String newEncryptedString = changePosition(encryptThis);
        return newEncryptedString;
    }
    private static String deBuildEncryptedString(String decryptThis) {
        String newDecryptedString = changePositionRevert(decryptThis);
        return newDecryptedString;
    }
}
