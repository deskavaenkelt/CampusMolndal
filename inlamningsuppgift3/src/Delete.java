/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/datalogiUppgift3slutuppgift
 */
/**
 * Class that checks if the value the User want´s to delete exists
 * and if it does, it removes the value and the same index place in TimeStamp Array
 * as in the String array.
 */
class Delete {
    /**
     * Starts the delete part and calls on deleteValuesInArray
     */
    protected static void deleteStart(){
        deleteValueInArray();
    }
    /**
     * Method that deletes the value that the user wants to remove from the array
     */
    private static void deleteValueInArray() {
        System.out.println("Skriv in vad vill du radera: ");
        String checkValue = UserInput.getString();
        int index = Search.serachAndGetStringIndex(checkValue); //Get the index of user input.
        //Checks if the string contains the given value if so removes from the array.
        if (index >= 0) {
            System.out.println(checkValue + " Är borttagen");
            Arrays.getStrings().remove(index); //Removes value from array
            Arrays.getTimeStamp().remove(index); //Removes same index place in TimeStamp array as in String array.
        } else {
            System.out.println(checkValue + " kunde inte hittas");
        }
    }
}