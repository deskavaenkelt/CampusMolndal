/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg , Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/
 */

import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Base64;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class Encryption {
    private static String alphabet = "qwertyuiopasdfghjklzxcvbnm,.-'¨´+0987654321§";
    private static Random randomizer = new Random();
    private static int kryptoLengt = 5;
    private static String notEncryted;
    private static String encryptedGeneratedString;

    protected static void stringToEncrypt(String sometingToEncrypt) {
        encrypt(sometingToEncrypt);
    }
    private static void encrypt(String encryptThis) {
        notEncryted = encryptThis;
        System.out.println("Word to encrypt: " +notEncryted);
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
        encryptedGeneratedString = newEncryptedString;
    }

    protected static void stringToDecrypt(/*String decryptThis*/) {
        decrypt(/*somethingToDecrypt*/);
    }

    private static void decrypt(/*String decryptThis*/) {
        String decryptedString = "";
        int counter = kryptoLengt;
        for (int i = 0; i < encryptedGeneratedString.length(); i++) {
            decryptedString += encryptedGeneratedString.charAt(counter);
            counter += (kryptoLengt+1);
            if (counter >= encryptedGeneratedString.length()) {
                break;
            }
        }
        System.out.println("Decrypted text is: " + decryptedString);
    }




    public static void printEncryptedString() {
        System.out.println("Krypterad stränginnehåller: [ " + encryptedGeneratedString + " ]");
    }



    private static char inputRandomChars() {
        return alphabet.charAt(randomizer.nextInt(alphabet.length()));
    }














    /*private static String algorithm = "RickardGerOssVg";
    private static byte[] krypteradString;

    //public static void encrypt(String encryptInput) {

    //}

    public static void decrypt() {
        System.out.println("Decrypted: " + decryptF(krypteradString,symKey,c));
    }

    public static void printCryptedString() {
        System.out.println("Krypterad sträng: " + );
    }

    //-------------------------------------------------------------------

    private static final String key = "aesEncryptionKey";
    private static final String initVector = "encryptionIntVec";

    public static String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }*/
}
