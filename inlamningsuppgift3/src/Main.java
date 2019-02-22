/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/datalogiUppgift3slutuppgift
 */

public class Main {
    private static boolean quit = false;
    public static void main(String[] args) {
        runProgram();
    }

    private static void runProgram() {
        while(!quit) {
            printMenu();
            int action = UserInput.getNumber();

            if (action >= 0 && action <= 9) {
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
                        printExtra();
                        break;
                    case 7:
                        countWords();
                        break;
                    case 8:
                        recursion();
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

    private static void printMenu() {
        System.out.println("\nTillgängliga val:");
        System.out.println(
                        "+----------------------------+\n" +
                        "| 1  - Lägg till             |\n" +
                        "| 2  - Redigera              |\n" +
                        "| 3  - Sök                   |\n" +
                        "| 4  - Sortera               |\n" +
                        "| 5  - Ta bort               |\n" +
                        "| 6  - Skriv ut EXTRA        |\n" +
                        "| 7  - Räkna ord             |\n" +
                        "| 8  - Rekursiv              |\n" +
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
        Search.goToSearch();
    }

    private static void sort() {
        System.out.println("Sorterar...");
        Sort.goToSort();
    }

    private static void delete() {
        System.out.println("Radera...");
        Delete.deleteStart();
    }

    private static void printExtra() {
        System.out.println(
                "Skriver ut den jämna och ojämna Fibonacci serien\n" +
                "OddNumbers contains: " + Arrays.getOddNumbers().size() + " " + Arrays.getOddNumbers().toString() +"\n" +
                "EvenNumbers contains: " + Arrays.getEvenNumbers().size() + " " + Arrays.getEvenNumbers().toString()
                );
    }

    private static void countWords() {
        System.out.println("Räkna Ord...");
        CountWords.startCount();
    }

    private static void recursion() {
        Recursion.startRecursion();
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

<<<<<<< HEAD
// TODO: blir något fel i dekryprering när man ändrat på ett värde som redan finns i databasen
=======
// TODO: blir något fel i dekryprering när man ändrat på ett värde som redan finns i databasen

>>>>>>> 0effc1b3a1e5225b9b2a8865a99731141b46600c
