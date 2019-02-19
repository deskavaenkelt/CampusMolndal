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
        printWholeArray();
        timeStamp();
    }

    private static void printWholeArray() {
        System.out.print(Arrays.getStrings().toString());
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