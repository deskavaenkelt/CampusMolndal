/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/datalogiUppgift3slutuppgift
 */
import java.util.Date;

class Add {

    static void userInput() {
        System.out.print("Skriv in text: ");
        String input = UserInput.getString();

        // Här ska krypering in
        String thisIsEncrypted = Encryption.stringToEncrypt(input);
        Arrays.setStrings(thisIsEncrypted);

        System.out.println("\nEn ny sträng '" + input + "' lades till.. " + thisIsEncrypted);
        printWholeArray();
        timeStamp();
        System.out.println("Ökar fibbonacci serien...");
        Fibonacci.addNewFibonacci();
        Fibonacci.printGeneratedFibonacciSeries();
    }
    private static void printWholeArray() {
        System.out.println(Arrays.getStrings());
    }
    private static void timeStamp(){
        Date date = new Date();
        Arrays.getTimeStamp().add(date);
        printTimeStamp();
    }
    private static void printTimeStamp(){
        System.out.println(Arrays.getTimeStamp());
    }
}