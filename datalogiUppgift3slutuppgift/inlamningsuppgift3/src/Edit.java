/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/datalogiUppgift3slutuppgift
 */
/**
 * Class that has methods so that the user can change a input value in the array
 * to a new value.
 */
public class Edit {

    /**
     * Starts the edit part and calls on edit()
     */
    protected static void start() {
        edit();
    }

    /**
     * Method that changes the value of an already existing value in the string array
     */
    private static void edit() {
        System.out.println("Skriv in vad vill ändra på: ");
        String checkInput = UserInput.getString();
        String newValue;
        //Get index of the value that the user want to change
        int index = Search.searchAndGetStringIndex(checkInput);
        //If the value exists, it changes to the new user input value.
        if (index >= 0) {
            System.out.println("Vad vill du ändra till? ");
            newValue = UserInput.getString();

            //Encrypts the newValue.
            String thisIsEncrypted = Encryption.stringToEncrypt(newValue);

            //Write to database
            Arrays.getStrings().set(index,thisIsEncrypted);

            //Arrays.setStrings(thisIsEncrypted);
            System.out.println("'" + checkInput + "'" + " ändrades till " + "'" + newValue + "' " + thisIsEncrypted);
        } else { //if the input value is not found.
            System.out.println("Värdet finns ej");
        }
    }
}