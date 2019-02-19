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
    }

    private static void id() {

    }

    private static String namn(String searchItem) {
        //boolean exists = groceryList.contains(searchItem);

        int position = Arrays.getStrings().indexOf(searchItem);
        if(position >=0) {
            return Arrays.getStrings().get(position);
        }

        return null;
    }



    /*protected static void searchAndGet() {
        System.out.println(searchAndGetString());
    }
    private static String searchAndGetString() {
        return "something";
    }*/
}
