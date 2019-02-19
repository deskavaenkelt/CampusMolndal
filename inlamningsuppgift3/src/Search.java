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
    /** search methods used by every search function in the program */
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



    /** Explicit for Search Meny */
    protected static void goToSerach() {
        internal();
    }
    private static void internal() {
        meny();
        userChoise();
    }

    private static void meny() {
        System.out.print(
                        "+--------------+\n" +
                        "| Alternativ:  |\n" +
                        "|  1. Sträng   |\n" +
                        "|  2. Datum    |\n" +
                        "+--------------+\n" +
                        "Val:");
    }
    private static void userChoise() {
        int input = UserInput.getNumber();
        if (1 == input) {
            serachSting();
        } else if (2 == input) {
            searchDate();
        }
    }
    private static void serachSting() {
        System.out.print("Skriv in det du söker efter: ");
        String input = UserInput.getString();
        int indexId = serachAndGetStringIndexInternal(input);
        if (indexId >= 0) {
            System.out.println(Arrays.getStrings().get(indexId) + " fanns!");
        } else {
            System.out.println(input + " fanns ej!");
        }
    }
    private static void searchDate() {
        System.out.print("Skriv in det datum (YYYY-MM-DD HH:mm) du söker efter: ");
        int input = UserInput.getNumber();
        int indexId = serachAndGetTimeStampInternal(input);
        if (indexId >= 0) {
            System.out.println(Arrays.getTimeStamp().get(indexId) + " fanns!");
        } else {
            System.out.println(input + " fanns ej!");
        }
    }




    /*private static String namn(String searchItem) {
        //boolean exists = groceryList.contains(searchItem);

        int position = Arrays.getStrings().indexOf(searchItem);
        if(position >=0) {
            return Arrays.getStrings().get(position);
        }

        return null;
    }*/




    /*protected static void searchAndGet() {
        System.out.println(searchAndGetString());
    }
    private static String searchAndGetString() {
        return "something";
    }*/
}
