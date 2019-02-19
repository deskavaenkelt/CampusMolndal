/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg , Madeleine Hallqvist
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/
 */
/**Class that sorts the String Array in two ways.*/
public class Sort {

    protected static void goToSort() {
        internalSort();
    }
    private static void internalSort() {
        menySort();
        userChoiseSort();
    }

    private static void menySort() {
        System.out.print(
                "+--------------+\n" +
                        "| Alternativ:  |\n" +
                        "|  1. A - Ö    |\n" +
                        "|  2. Ö - A    |\n" +
                        "+--------------+\n" +
                        "Val:");
    }
    /**Checks what choice User wants to do.*/
    private static void userChoiseSort() {
        int input = UserInput.getNumber();
        if (1 == input) {
            sortArray();
        } else if (2 == input) {
            sortArrayInReversOrder();
        }
    }
    /**Sorting method that sorts the Array from a-z*/
    private static void sortArray(){
        //Change the arrayList to an Array.
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
            System.out.println(newArray[a]);
        }
    }
    /**Sorting method that sorts the Array from Z - A*/
    private static void sortArrayInReversOrder() {
        Arrays.getStrings().sort(Collections.reverseOrder());
        System.out.println("Sorterar i motsatt håll: ");
        for(String string: Arrays.getStrings()){
            System.out.println(string);
        }
    }
}
