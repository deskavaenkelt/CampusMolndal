/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/datalogiUppgift3slutuppgift
 */
/**
 * Class that counts how many words there are in the Array.
 */
public class CountWords {
    /**
     * Method that calls on the method that count how
     * many words there are in the array, and adds them and prints out.
     */
    protected static void startCount() {
        int amoutOfWords =0;
        for (String input : Arrays.getStrings()) {
            amoutOfWords = amoutOfWords + countWords(input);
        }
        System.out.println(amoutOfWords);
    }
    /**
     * Method that counts how many words there are in the array.
     */
    private static int countWords(String word) {
        int wordCount =0;
        boolean isWord = false;
        int endOfLine = word.length() - 1;
        char [] characters = word.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i]) && i != endOfLine) {
                isWord = true;
            } else if (!Character.isLetter(characters[i]) && isWord) {
                wordCount++;
                isWord = false;
            } else if (Character.isLetter(characters[i]) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }
}