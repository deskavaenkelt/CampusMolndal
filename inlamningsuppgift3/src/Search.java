/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/datalogiUppgift3slutuppgift
 */

class Search {
    /**
     * Search methods used by every search function in the program
     * returns indexId when the element is found or -1 if the element isn't found
     */
    protected static int serachAndGetStringIndex(String searchFor) {
        return serachAndGetStringIndexInternal(searchFor);
        // if -1 is returned, the element was not found
    }
    private static int serachAndGetStringIndexInternal(String searchFor) {
        return Encryption.searchEncrypt(searchFor);
    }


    /**
     * Explicit for Search Meny
     */
    protected static void goToSerach() {internal();}
    private static void internal() {meny();userChoise();}
    private static void meny() {
        System.out.print(
                        "+----------------+\n" +
                        "|   Alternativ:  |\n" +
                        "|  1. Sträng     |\n" +
                        "|  2. Fibonacci  |\n" +
                        "+----------------+\n" +
                        "Val:");
    }
    private static void userChoise() {
        int input = UserInput.getNumber();
        if (1 == input) {
            serachSting();
        } else if (2 == input) {
            searchFibonacci();
        }
    }


    /**
     * The two different search methods
     * One to search for stored strings and the other to search for stored fibonacci numbers.
     * EXTRA if there is no match on Fibonacci, tell user what number is closest.
     */
    private static void serachSting() {
        // Check if Arrays.strings is empty, true if empty
        boolean isArrayListIsEmpty = Arrays.getStrings().isEmpty();

        if (isArrayListIsEmpty) {                           // if isEmpty = true
            System.out.println("Inga nummer lagrade ännu!");
        } else {
            System.out.print("Skriv in det du söker efter: ");
            String input = UserInput.getString();
            int indexId = serachAndGetStringIndexInternal(input);
            if (indexId >= 0) {
                System.out.println(Encryption.stringToDecrypt(Arrays.getStrings().get(indexId)) + " fanns!");
            } else {
                System.out.println(input + " fanns ej!");
            }
        }
    }
    private static void searchFibonacci() {
        // Check if Arrays.strings is empty, true if empty
        boolean isArrayListIsEmpty = Arrays.getFibonacci().isEmpty();

        if (isArrayListIsEmpty) {                           // if isEmpty = true
            System.out.println("Inga nummer lagrade ännu!");
        } else {                                            // if isEmpty = false
            System.out.print("Skriv in det nummer du vill söka efter: ");
            int userInput = UserInput.getNumber();
            if (userInput == -1) {
                return;
            }
            // when we have a valid number
            searchFor(userInput);
        }
    }
    /**
     * Search for the number and in the same loop check for closest number
     */
    private static void searchFor(int numberToBeChecked) {
        int distance = Integer.MAX_VALUE;
        int idClosest= 0;
        int newDistance;

        for (int i = 0; i < Arrays.getFibonacci().size(); i++) {
            // search for numberToBeChecked
            int temp = Arrays.getFibonacci().get(i);
            if (temp == numberToBeChecked) {
                System.out.println(Arrays.getFibonacci().get(i) + " was found");
                return;
            }

            // Check distance from numberToBeChecked to temp, save id if newDistance is shortest
            newDistance = Math.abs(numberToBeChecked - temp);   // Extra
            if (newDistance < distance) {
                idClosest = i;
                distance = newDistance;
            }
        }
        System.out.println(
                numberToBeChecked + " hittades inte.\n" +
                "Närmsta nummer är: " + Arrays.getFibonacci().get(idClosest)
                );
    }


    // TODO: Ta bort de nedan, sparas tills programmet är klart
    protected static int serachAndGetTimeStamp(int searchDate) {
        return serachAndGetTimeStampInternal(searchDate);
        // if -1 is returned, the element was not found
    }
    private static int serachAndGetTimeStampInternal(int searchDate) {
        int position = -1;
        if (Arrays.getTimeStamp().contains(searchDate)) {              // if searchFor exist == true => get position
            position = Arrays.getTimeStamp().indexOf(searchDate);
        }
        return position;    // if -1 is returned, the element was not found
    }
}
