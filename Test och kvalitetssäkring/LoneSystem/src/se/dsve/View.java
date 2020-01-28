package se.dsve;

/*
 * Menu's and views
 */
public class View {
    static void login() {
        System.out.println("+--------------------+");
        System.out.println("|     Lönesystem     |");
        System.out.println("+--------------------+");
        System.out.println("|                    |");
        System.out.println("|       Login        |");
        System.out.println("|                    |");
        System.out.println("+--------------------+\n");
    }

    static void loggedIn() {
        System.out.println("+------------ " + Main.loggedInUserName + " +");
        System.out.println("|     Lönesystem     |");
        System.out.println("+--------------------+");
        System.out.println("|                    |");
        System.out.println("|  1.                |");
        System.out.println("|  2.                |");
        System.out.println("|  3.                |");
        System.out.println("|  4.                |");
        System.out.println("|  5.                |");
        System.out.println("|  6.                |");
        System.out.println("|  0. Tillbaka       |");
        System.out.println("|                    |");
        System.out.println("+--------------------+\n");
    }
}

