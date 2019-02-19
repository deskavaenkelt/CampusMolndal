/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg , Madeleine Hallqvist
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/
 */
public class inlamningsuppgift3 {
    private static boolean quit = false;
    public static void main(String[] args) {
        runProgram();
    }

    private static void runProgram() {
        while(!quit) {
            printMeny();
            int action = UserInput.getNumber();

            if (action == 0 || action == 1 || action == 2 || action == 3 || action == 4 || action == 5 || action == 6 || action == 7 || action == 8 || action == 9) {
                switch (action) {
                    case 1:
                        add();
                        break;
                    case 2:
                        edit();
                        break;
                    case 3:
                        search();
                        break;
                    case 4:
                        sort();
                        break;
                    case 5:
                        delete();
                        break;
                    case 6:
                        printMeny();
                        break;
                    case 7:
                        printExtra();
                        break;
                    case 8:
                        countWords();
                        break;
                    case 9:
                        debug();
                        break;
                    case 0:
                        quit();
                        break;
                }
            }
        }
    }

    private static void printMeny() {
        System.out.println("\nTillgängliga val:");
        System.out.println(
                        "+----------------------------+\n" +
                        "| 1  - Lägg till             |\n" +
                        "| 2  - Redigera              |\n" +
                        "| 3  - Sök                   |\n" +
                        "| 4  - Sortera               |\n" +
                        "| 5  - Ta bort               |\n" +
                        "| 6  - Skriv ut meny         |\n" +
                        "| 7  - Skriv ut EXTRA        |\n" +
                        "| 8  - Räkna ord             |\n" +
                        "| 9  - Debug                 |\n" +
                        "| 0  - Avsluta               |\n" +
                        "+----------------------------+\n");
        System.out.print("Ditt val: ");
    }

    private static void add() {
        System.out.println("Går till addfunktion...");
        Add.userInput();
    }
    private static void edit() {
        System.out.println("Redigera");
        Edit.start();
    }
    private static void search() {
        System.out.println("Går till sökfunktion...");
        Search.goToSerach();
    }
    private static void sort() {
        System.out.println("Sorterar...");

    }
    private static void delete() {
        System.out.println("Radera...");
        Delete.deleteStart();
    }
    private static void printExtra() {
        System.out.println(
                "Skriver ut den jämna och ojämna Fibonacci serien\n" +
                "OddNumbers:  " + Arrays.getOddNumbers().toString() +"\n" +
                "EvenNumbers: " + Arrays.getEvenNumbers().toString()
                );
    }
    private static void countWords() {
        System.out.println("Räkna Ord...");
        CountWords.startCount();
    }
    private static void debug() {
        Debug.start();
    }
    private static void quit() {
        System.out.println("Avslutar...");
        UserInput.closeScanner();
        quit = true;
    }
}

