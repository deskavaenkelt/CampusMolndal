package se.dsve;

/*
 * Menu's and views
 */
public class View {

    static void login() {
        System.out.println("+----------------------+");
        System.out.println("|     Lönesystem       |");
        System.out.println("+----------------------+");
        System.out.println("|                      |");
        System.out.println("|       Login          |");
        System.out.println("|                      |");
        System.out.println("+----------------------+\n");
    }

    static void header() {
        System.out.println("\n\n+-------------- " + Main.loggedInUserName + " +");
        System.out.println("|     Lönesystem       |");
        System.out.println("+----------------------+");
        System.out.println("|                      |");
    }

    static void footer() {
        System.out.println("|                      |");
        System.out.println("| 0. Logga ut          |");
        System.out.println("|                      |");
        System.out.println("+----------------------+");
        if (Main.loggedInAsAdmin) {
            System.out.println("Requests: " + Controller.countRequestedChanges());
        }

        System.out.print("\nVal: ");
    }

    static void loggedIn_User() {
        header();
        System.out.println("| 1. Saldo             |");
        System.out.println("| 2. Nuvarande lön     |");
        System.out.println("| 3. Nuvarande roll    |");
        System.out.println("| 4. Löneförhandling   |");
        System.out.println("| 5. Rollförhandling   |");
        System.out.println("| 8. Radera kontot     |");
        footer();
    }

    static void loggedIn_Admin() {
        header();
        System.out.println("| 1. Saldo             |");
        System.out.println("| 2. Nuvarande lön     |");
        System.out.println("| 3. Nuvarande roll    |");
        System.out.println("| 4. Lista Användare   |");
        System.out.println("| 5. Förfrågningar     |");
        System.out.println("| 6. Månadskörning     |");
        System.out.println("| 7. Ny användare      |");
        System.out.println("| 8. Radera användare  |");
        footer();
    }

    static void loggedIn_Admin_requests() {
        System.out.println("\n\n+-------------- " + Main.loggedInUserName + " +");
        System.out.println("|     Lönesystem       |");
        System.out.println("+----------------------+");
        System.out.println("|    Förfrågningar     |");
        System.out.println("|                      |");
        System.out.println("| 1. Visa Alla         |");
        System.out.println("| 2. Enskild hantering |");
        System.out.println("|                      |");
        System.out.println("| 3. Godkänn allt      |");
        System.out.println("| 4. Neka allt         |");
        System.out.println("|                      |");
        System.out.println("| 0. Tillbaka          |");
        System.out.println("|                      |");
        System.out.println("+----------------------+");

        if (Main.loggedInAsAdmin) {
            System.out.println("Requests: " + Controller.countRequestedChanges());
        }

        System.out.print("\nVal: ");
    }
}