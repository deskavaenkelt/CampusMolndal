/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg , Madeleine Hallqvist
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/
 */
public class Delete {


    protected static void deleteValueInArray() {
        System.out.println("Skriv in vad vill du radera: ");
        String checkValue = UserInput.getString();
        int index = Arrays.getStrings().indexOf(checkValue);

        boolean found = false;
        for (String element : Arrays.getStrings()) {
            if (element.equals(checkValue)) {
                found = true;
                Arrays.getStrings().remove(index);
                Arrays.getTimeStamp().remove(index);
                System.out.println(checkValue + " har tagits bort");

            }
            if(!found){
                System.out.println("Det du skrivit in finns ej");
                break;
            }
            System.out.println(Arrays.getStrings());
            System.out.println(Arrays.getTimeStamp());

        }
    }
}