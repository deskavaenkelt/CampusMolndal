/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/
 */

import java.util.Date;
class Add {

    static void userInput() {
        System.out.print("Skriv in text: ");
        String input = UserInput.getString();
        Arrays.setStrings(input);
        System.out.println("\nEn ny sträng '" + input + "' lades till..");
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