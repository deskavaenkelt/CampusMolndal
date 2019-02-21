/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/datalogiUppgift3slutuppgift
 */
import java.util.Collections;
/**
 * Class that sorts the String Array in two ways.
 */
class Sort {

    /**
     * Calls on the method internalSort
     */
    protected static void goToSort() {
        internalSort();
    }

    /**
     * Calls on the methods menuSort and UserChoiceSort
     */
    private static void internalSort() {menuSort();userChoiceSort();}

    /**
    * Menu so that the user gets to decide on how to sort the array.
    */
    private static void menuSort() {
        System.out.print(
                "+--------------+\n" +
                        "| Alternativ:  |\n" +
                        "|  1. A - Ö    |\n" +
                        "|  2. Ö - A    |\n" +
                        "+--------------+\n" +
                        "Val: ");
    }

    /**
     * Checks what choice the User wants to do.
     */
    private static void userChoiceSort() {
        int input = UserInput.getNumber();
        if (1 == input) {
            sortArray();
        } else if (2 == input) {
            sortArrayInReverseOrder();
        }
    }

    /**
     * Sorting method that sorts the Array from a-z
     */
    private static void sortArray(){
        //Change the ArrayList to an Array.
        String[] newArray = Arrays.getStrings().toArray(new String[Arrays.getStrings().size()]);
        //Algorithm to sort the array.
        for (int a = 0; a < newArray.length; a++) {
            int minIndex = a;
            for (int b = a + 1; b < newArray.length; b++) {
                if (newArray[b].compareTo(newArray[minIndex]) < 0) {
                    minIndex = b;
                }
            }
            String temp = newArray[a];
            newArray[a] = newArray[minIndex];
            newArray[minIndex] = temp;
            System.out.println(Encryption.stringToDecrypt(newArray[a]));
        }
    }

    /**
     * Sorting method that sorts the Array from Z - A
     */
    private static void sortArrayInReverseOrder() {
        //Sorts the array in reverse order.
        Arrays.getStrings().sort(Collections.reverseOrder());
        System.out.println("Sorterar i motsatt håll: ");
        //Loops out the new order of the array
        for(String string: Arrays.getStrings()){
            System.out.println(Encryption.stringToDecrypt(string));
        }
    }
}