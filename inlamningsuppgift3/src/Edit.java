/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/datalogiUppgift3slutuppgift
 */
/**Class that has methods so that the user can change a input value in the array
 * to a new value. */
public class Edit {
    /**Starts the edit part and calls on edit()*/
    protected static void start() {
        edit();
    }
    /** Method that changes value of already existing values in the string array*/
    private static void edit() {
        System.out.println("Skriv in vad vill ändra på: ");
        String checkInput = UserInput.getString();
        String newvalue;
        //Get index of the value that the user want to change
        int index = Search.serachAndGetStringIndex(checkInput);
        //If the value exists it changes to the new user input value.
        if (Arrays.getStrings().contains(checkInput)) {
            System.out.println("Vad vill du ändra till? ");
            newvalue = UserInput.getString();
            Arrays.getStrings().set(index,newvalue);
            System.out.println("'" + checkInput + "'" + " ändrades till " + "'" + newvalue + "'!");

        } else { //if the input value is not found.
            System.out.println("Värdet finns ej");
        }

    }
}