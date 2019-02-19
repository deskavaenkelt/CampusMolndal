/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg , Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/
 */

import java.util.Random;
class Encryption {
    private static Random randomizer = new Random();
    private static int kryptoLengt = 5;
    private static String encryptedGeneratedString;

    protected static String stringToEncrypt(String sometingToEncrypt) {
        return encrypt(sometingToEncrypt);
    }
    private static String encrypt(String encryptThis) {
        System.out.println("Word to encrypt: " +encryptThis);
        int lengtOfString = encryptThis.length();
        String newEncryptedString = "";

        for (int i = 0; i < lengtOfString; i++) {
            for (int j = 0; j < kryptoLengt; j++) {
                newEncryptedString += inputRandomChars();
            }
            newEncryptedString += encryptThis.charAt(i);
        }
        for (int j = 0; j < kryptoLengt; j++) {
            newEncryptedString += inputRandomChars();
        }
        return newEncryptedString;
    }
    private static char inputRandomChars() {
        String alphabet = "qwertyuiopasdfghjklzxcvbnm,.-'¨´+0987654321§½!#¤%&/()=?`´@£$€{[]}";
        return alphabet.charAt(randomizer.nextInt(alphabet.length()));
    }




    protected static void stringToDecrypt(String decryptThis) {
        decrypt(decryptThis);
    }

    private static String decrypt(String decryptThis) {
        String decryptedString = "";
        int counter = kryptoLengt;
        for (int i = 0; i < decryptThis.length(); i++) {
            decryptedString += decryptThis.charAt(counter);
            counter += (kryptoLengt+1);
            if (counter >= decryptThis.length()) {
                break;
            }
        }
        return decryptedString;
    }

    protected static void printEncryptedString() {
        System.out.println("Krypterad stränginnehåller: [ " + encryptedGeneratedString + " ]");
    }





}
