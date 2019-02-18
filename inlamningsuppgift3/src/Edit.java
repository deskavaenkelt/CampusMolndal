/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/
 */
public class Edit {
    public static void edit() {
        System.out.println("Skriv in vad vill ändra på: ");
        String checkInput = UserInput.getString();
        String newvalue;
        //Get index of the value that the user want to change
        int index = Arrays.getStrings().indexOf(checkInput);

        boolean found = false;
        for (String element:Arrays.getStrings()) {
            if (element.equals(checkInput)) {
                found = true;
                System.out.println("Vad vill du ändra till? ");
                newvalue = UserInput.getString();

                Arrays.getStrings().set(index,newvalue);
            }
            if(!found){
                System.out.println("Värdet finns ej");
            }
            System.out.println(Arrays.getStrings());
            break;
        }

    }
}