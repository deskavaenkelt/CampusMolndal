public class CountWords {

    protected static void startCount() {
        int amoutOfWords =0;
        for (String input : Arrays.getStrings()) {
            amoutOfWords = amoutOfWords + countWords(input);
        }
        System.out.println(amoutOfWords);
    }
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