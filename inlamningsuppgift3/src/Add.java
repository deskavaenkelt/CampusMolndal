/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/
 */
class Add {

    static void userInput() {
        System.out.print("Skriv in text: ");
        String input = UserInput.getString();
        Arrays.setStrings(input);

        printWholeArray();
    }

    private static void printWholeArray() {
        System.out.print(Arrays.getStrings().toString());
    }
}