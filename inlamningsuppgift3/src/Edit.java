/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/
 */
public class Edit {
    protected static void start() {
        edit();
    }

    private static void edit() {
        System.out.println("Skriv in vad vill ändra på: ");
        String checkInput = UserInput.getString();
        String newvalue;
        //Get index of the value that the user want to change
        int index = Search.serachAndGetStringIndex(checkInput);
        if (Arrays.getStrings().contains(checkInput)) {
            System.out.println("Vad vill du ändra till? ");
            newvalue = UserInput.getString();
            Arrays.getStrings().set(index,newvalue);
            System.out.println("'" + checkInput + "'" + " ändrades till " + "'" + newvalue + "'!");

        } else {
            System.out.println("Värdet finns ej");
        }

    }
}