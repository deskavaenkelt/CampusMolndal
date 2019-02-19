/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg , Madeleine Hallqvist
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/
 */
public class Sort {
    protected static void startSort(){
        System.out.println("Sorterar efter bokstavs ordning");
        sortArray();
    }

    private static void sortArray(){
        String[] newArray = Arrays.getStrings().toArray(new String[Arrays.getStrings().size()]);

        for (int a = 0; a < newArray.length; a++) {
            int minIndex = a;
            for (int b = a + 1; b < newArray.length; b++) {
                if (newArray[b].compareTo(newArray[minIndex]) < 0) {
                    minIndex = b;
                }
            }
            String temp = newArray[a];
            newArray[a] = newArray[minIndex];
            newArray[minIndex] = temp;
            System.out.println(newArray[a]);
        }
    }
}
