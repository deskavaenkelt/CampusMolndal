public class inlamningsuppgift3 {
    private static boolean quit = false;
    public static void main(String[] args) {
        runProgram();
    }

    private static void runProgram() {
        while(!quit) {
            printMeny();
            int action = UserInput.getNumber();

            if (action == 0 || action == 1 || action == 2 || action == 3 || action == 4 || action == 5 || action == 6 || action == 7) {
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
                        "| 0  - Avsluta               |\n" +
                        "+----------------------------+\n");
        System.out.print("Ditt val: ");
    }

    private static void add() {
        Add.userInput();
    }
    private static void edit() {
        System.out.println("Redigera");
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
    }
    private static void printExtra() {
        System.out.println("Extra uppgift");
    }
    private static void quit() {
        System.out.println("Avslutar...");
        UserInput.closeScanner();
        quit = true;
    }

}
