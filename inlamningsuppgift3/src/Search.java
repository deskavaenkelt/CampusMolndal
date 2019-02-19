import java.sql.Timestamp;
import java.util.Date;

/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/
 */
class Search {


    protected static void goToSerach() {
        internal();
    }
    private static void internal() {
        meny();
    }

    private static void meny() {
        System.out.print("Skriv in det du söker efter: ");
        String temp = UserInput.getString();


    }


    protected static int serachAndGetStringIndex(String searchFor) {
        return serachAndGetStringIndexInternal(searchFor);
        // if -1 is returned, the element was not found
    }
    private static int serachAndGetStringIndexInternal(String searchFor) {
        int position = -1;
        if (Arrays.getStrings().contains(searchFor)) {              // if searchFor exist == true => get position
            position = Arrays.getStrings().indexOf(searchFor);
        }

        return position;    // if -1 is returned, the element was not found
    }

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

    /*private static String namn(String searchItem) {
        //boolean exists = groceryList.contains(searchItem);

        int position = Arrays.getStrings().indexOf(searchItem);
        if(position >=0) {
            return Arrays.getStrings().get(position);
        }

        return null;
    }*/


    /*private static void meny() {
        System.out.println(
                "Vill du söka på id eller namn?\n" +
                        "1. ID\n" +
                        "2. Namn\n" +
                        "Val:");
        int input = UserInput.getNumber();
        if (1 == input) {
            id();
        } else if (2 == input) {
            //namn(input);
        }
    }*/

    /*protected static void searchAndGet() {
        System.out.println(searchAndGetString());
    }
    private static String searchAndGetString() {
        return "something";
    }*/
}
