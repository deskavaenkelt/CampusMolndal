/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg , Madeleine Hallqvist
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/
 */
public class Delete {

    public class Delete {

        protected static void deleteStart(){
            deleteValueInArray();
        }


        private static void deleteValueInArray() {
            System.out.println("Skriv in vad vill du radera: ");
            String checkValue = UserInput.getString();
            int index = Search.serachAndGetStringIndex(checkValue);

            if (Arrays.getStrings().contains(checkValue)) {
                System.out.println(checkValue + " Är bort tagen");
                Arrays.getStrings().remove(index);
                Arrays.getTimeStamp().remove(index);

            } else {
                System.out.println(checkValue + "kunde inte hittas");
            }

        }
    }
}