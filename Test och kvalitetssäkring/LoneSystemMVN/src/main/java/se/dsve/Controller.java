package se.dsve;

public class Controller {
    // Not testable
    static void enterUserNameAndPassword() {
        boolean validCredentials = false;

        while (!validCredentials) {
            System.out.println("Enter username:");
            String enteredUsername = UserInput.getString();

            if (enteredUsername.equals("exit")) {
                Main.keepAppAlive = false;
                break;
            }

            System.out.println("Enter password:");
            String enteredPassword = UserInput.getString();

            validCredentials = checkLoginCredentials(enteredUsername, enteredPassword);

            if (!validCredentials) {
                System.out.println("Wrong credentials! \n\n");
            }
        }
    }

    static boolean checkLoginCredentials(String userName, String userPassword) {
        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            if (UserManagement.getUsers().get(i).getName().equals(userName) && UserManagement.getUsers().get(i).getPassword().equals(userPassword)) {
                if (UserManagement.getUsers().get(i).isAdmin()) {
                    Main.loggedInAsAdmin = true;
                } else {
                    Main.loggedInAsAdmin = false;
                }
                Main.loggedInUserName = userName;
                Main.loggedInUserId = i;
                Main.isLoggedIn = true;
                return true;
            }
        }
        return false;
    }


    ////////////////////////
    //  Common functions  //
    ////////////////////////
    // Not testable
    static void printSaldo() {
        System.out.println("\nAkumulerat Saldo är: " + UserManagement.getUsers().get(Main.loggedInUserId).getSaldo());
    }

    // Not testable
    static void printSalary() {
        System.out.println("\nNuvarande lön är: " + UserManagement.getUsers().get(Main.loggedInUserId).getSalary());
    }

    // Not testable
    static void printRole() {
        System.out.println("\nNuvarande roll är: " + UserManagement.getUsers().get(Main.loggedInUserId).getRole());
    }

    static void logout() {
        Main.loggedInUserName = "";
        Main.loggedInUserId = -1;
        Main.loggedInAsAdmin = false;
        Main.isLoggedIn = false;
    }

    ///////////////////////////////
    //  Standard User functions  //
    ///////////////////////////////
    static void requestChangeRoll() {
        System.out.println("\nÖnskad ny roll är: ");
        requestChangeRoll_Function(UserInput.getString());
    }

    static void requestChangeRoll_Function(String input) {
        UserManagement.getUsers().get(Main.loggedInUserId).setRequestedRole(input);
    }

    static void requestChangeSalary() {
        System.out.println("\nÖnskad ny lön är: ");
        requestChangeSalary_Function(UserInput.readDouble());
    }

    static void requestChangeSalary_Function(double newSalary) {
        UserManagement.getUsers().get(Main.loggedInUserId).setRequestedSalary(newSalary);
    }

    static void userSelfErase() {
        System.out.println("Bekräfta med ditt användarnamn och lösenord!");

        System.out.print("Skriv Användarnamn: ");
        String name = UserInput.getString();

        System.out.print("Skriv Lösenord: ");
        String password = UserInput.getString();

        if (Main.loggedInUserName.equals(name)) {
            UserManagement.deleteUser(name, password);
        } else {
            System.out.println("You can only erase you'r own account");
        }


    }

    static void wrongInput() {
        System.out.println("Wrong input");
    }


    ////////////////////////////
    //  Admin User functions  //
    ////////////////////////////
    // TODO: Sanity test
    // TODO: Komplettera med roll, lön, saldo
    static void listUsersWithPasswords() {

        System.out.println(" ID | Username | Password");

        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            System.out.println(" " + i + "  | " + UserManagement.getUsers().get(i).getName() + "   |  " + UserManagement.getUsers().get(i).getPassword());
        }

    }

    static int countRequestedChanges() {
        int changes = 0;

        // Check for changes in roles
        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            if (!UserManagement.getUsers().get(i).getRole().equals(UserManagement.getUsers().get(i).getRequestedRole())) {
                changes++;
            }
        }

        // Check for changes in salary
        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            if (UserManagement.getUsers().get(i).getSalary() != UserManagement.getUsers().get(i).getRequestedSalary()) {
                changes++;
            }
        }

        return changes;
    }

    static void listRequestedChanges() {

        if (countRequestedChanges() > 0) {
            // Check for changes in roles
            System.out.println("Requested role changes:");
            for (int i = 0; i < UserManagement.getUsers().size(); i++) {
                if (!UserManagement.getUsers().get(i).getRole().equals(UserManagement.getUsers().get(i).getRequestedRole())) {
                    System.out.println(UserManagement.getUsers().get(i).getName()
                            + " request a new role of: "
                            + UserManagement.getUsers().get(i).getRequestedRole());
                }
            }

            // Check for changes in salary
            System.out.println("Requested salary changes:");
            for (int i = 0; i < UserManagement.getUsers().size(); i++) {
                if (UserManagement.getUsers().get(i).getSalary() != UserManagement.getUsers().get(i).getRequestedSalary()) {
                    System.out.println(UserManagement.getUsers().get(i).getName()
                            + " request a new salary of: "
                            + UserManagement.getUsers().get(i).getRequestedSalary());
                }
            }
        } else {
            System.out.println("No requests!");
        }
    }

    static void monthlyRun() {
        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            double salary = UserManagement.getUsers().get(i).getSalary();
            UserManagement.getUsers().get(i).updateSaldo(salary);
        }
    }

    static void adminCreateNewUser() {
        System.out.print("\nAnvändarnam och lösenord skall vara 6 tecken långt," +
                " samt innehålla bara bokstäver (4st) och siffror (2st)");
        System.out.print("\nSkriv Användarnamn: ");
        String name = UserInput.getString();

        System.out.print("Skriv Lösenord: ");
        String password = UserInput.getString();

        if (isBothNameAndPasswordValid(name, password)) {

            if (userIsUnique(name)) {
                System.out.print("Skriv Roll: ");
                String role = UserInput.getString();

                System.out.print("Skriv Lön: ");
                double salary = UserInput.readDouble();

                adminCreateNewUser_Function(name, password, role, salary);
            } else {
                System.out.println("Username is already in use!");
            }
        } else {
            System.out.println("Invalid input!");
        }
    }

    static boolean userIsUnique(String name) {
        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            if (UserManagement.getUsers().get(i).getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    static boolean isBothNameAndPasswordValid(String name, String password) {
        if (validateFormatNamePassword(name) && validateFormatNamePassword(password)) {
            return true;
        } else {
            return false;
        }
    }

    static boolean validateFormatNamePassword(String input) {
        int requierdLength = 6;
        if (input.length() != requierdLength) {
            return false;
        }

        int countLetters = 0;
        int countNumbers = 0;

        for (int i = 0; i < requierdLength; i++) {
            char verified = verifyValidInput(input.toLowerCase().charAt(i));
            if (verified == 'c') {
                countLetters++;
            } else if (verified == 'n') {
                countNumbers++;
            } else if (verified == 'i') {
                return false;
            }
        }

        if (countLetters == 4 && countNumbers == 2) {
            return true;
        } else {
            return false;
        }
    }

    static char verifyValidInput(char c) {
        // a = 97 => z = 122
        // å = 134, ä = 132, ö = 147
        // 0 = 48 => 9 = 57

        if ((c >= 97 && c <= 122) || c == 134 || c == 132 || c == 147) {
            return 'c';
        } else if ((c >= 48 && c <= 57)) {
            return 'n';
        } else {
            return 'i';
        }
    }


    static void adminCreateNewUser_Function(String name, String password, String role, double salary) {
        UserManagement.newUser(name, password, role, salary);
    }

    static void adminEraseUsers() {
        userSelfErase();
    }

    ///////////////////////
    //  Handle Requests  //
    ///////////////////////

    static void confirmChangeRole(int id) {
        if (id >= 0 && id < UserManagement.getUsers().size()) {
            String newRole = UserManagement.getUsers().get(id).getRequestedRole();
            UserManagement.getUsers().get(id).setRole(newRole);
        }
    }

    static void confirmChangeSalary(int id) {
        if (id >= 0 && id < UserManagement.getUsers().size()) {
            double newSalary = UserManagement.getUsers().get(id).getRequestedSalary();
            UserManagement.getUsers().get(id).setSalary(newSalary);
        }
    }

    // TODO: fortsätt här!
    private static String INVALID_INPUT = "Invalid input";

    static void handleRequests() {
        if (countRequestedChanges() > 0) {

            System.out.println("Requested changes:");
            for (int i = 0; i < UserManagement.getUsers().size(); i++) {
                String role = "";
                double salary = 0.0d;

                // Check for changes in roles
                if (!UserManagement.getUsers().get(i).getRole().equals(UserManagement.getUsers().get(i).getRequestedRole())) {
                    role = UserManagement.getUsers().get(i).getRequestedRole();
                }

                // Check for changes in salary
                if (UserManagement.getUsers().get(i).getSalary() != UserManagement.getUsers().get(i).getRequestedSalary()) {
                    salary = UserManagement.getUsers().get(i).getRequestedSalary();
                }


                if (!role.equals("") && salary != 0.0d) {
                    handleRequests_ChangeSomething(i);
                    handleRequests_ChangeRole(i);
                    handleRequests_ChangeSalary(i);
                } else if ((!role.equals("") && salary == 0.0d)) {
                    handleRequests_ChangeSomething(i);
                    handleRequests_ChangeRole(i);
                } else if ((role.equals("") && salary != 0.0d)) {
                    handleRequests_ChangeSomething(i);
                    handleRequests_ChangeSalary(i);
                }
            }
        } else {
            System.out.println("No more requests!");
        }
    }

    static void handleRequests_ChangeSomething(int i) {
        System.out.println("\n" + UserManagement.getUsers().get(i).getName() + " want the following changes:");
        System.out.println("ID: " + i);
    }

    static void handleRequests_ChangeRole(int i) {
        System.out.print("Allow role change from " + UserManagement.getUsers().get(i).getRole()
                + " to " + UserManagement.getUsers().get(i).getRequestedRole() + "? (Y/N)");
        String answer = UserInput.getString();
        if ("y".equals(answer.toLowerCase())) {
            confirmChangeRole(i);
        } else if ("n".equals(answer.toLowerCase())) {
            declineChangeRoll(i);
        }
    }

    static void handleRequests_ChangeSalary(int i) {
        System.out.print("Allow salary change from " + UserManagement.getUsers().get(i).getSalary()
                + " to " + UserManagement.getUsers().get(i).getRequestedSalary() + "? (Y/N)");
        String answer = UserInput.getString();
        if ("y".equals(answer.toLowerCase())) {
            confirmChangeSalary(i);
        } else if ("n".equals(answer.toLowerCase())) {
            declineChangeSalary(i);
        }
    }

    static void confirmAll() {
        // Confirm changes in roles
        System.out.println("Confirm all role changes:");
        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            if (!UserManagement.getUsers().get(i).getRole().equals(UserManagement.getUsers().get(i).getRequestedRole())) {
                UserManagement.getUsers().get(i).setRole(UserManagement.getUsers().get(i).getRequestedRole());
            }
        }

        // Confirm changes in salary
        System.out.println("Confirm all salary changes:");
        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            if (UserManagement.getUsers().get(i).getSalary() != UserManagement.getUsers().get(i).getRequestedSalary()) {
                UserManagement.getUsers().get(i).setSalary(UserManagement.getUsers().get(i).getRequestedSalary());
            }
        }
    }

    static void declineAll() {
        // Decline changes in roles
        System.out.println("Decline all role changes:");
        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            if (!UserManagement.getUsers().get(i).getRole().equals(UserManagement.getUsers().get(i).getRequestedRole())) {
                UserManagement.getUsers().get(i).setRequestedRole(UserManagement.getUsers().get(i).getRole());
            }
        }

        // Decline changes in salary
        System.out.println("Decline all salary changes:");
        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            if (UserManagement.getUsers().get(i).getSalary() != UserManagement.getUsers().get(i).getRequestedSalary()) {
                UserManagement.getUsers().get(i).setRequestedSalary(UserManagement.getUsers().get(i).getSalary());
            }
        }
    }

    static void declineChangeRoll(int id) {
        if (id >= 0 && id < UserManagement.getUsers().size()) {
            String oldRole = UserManagement.getUsers().get(id).getRole();
            UserManagement.getUsers().get(id).setRequestedRole(oldRole);
        }
    }

    static void declineChangeSalary(int id) {
        if (id >= 0 && id < UserManagement.getUsers().size()) {
            double oldSalary = UserManagement.getUsers().get(id).getSalary();
            UserManagement.getUsers().get(id).setRequestedSalary(oldSalary);
        }
    }


    /////////////////////////
    //  Create some users  //
    /////////////////////////
    static void createSomeUsers() {
        String[] users = {"admin1", "Adam01", "Bert02", "Carl03", "Eric04", "Fido05"};
        String[] passwords = {"admin1234", "01Adam", "02Bert", "03Carl", "04Eric", "05Fido"};
        String[] roles = {"Administrator", "User", "Developer","Accounting" , "Senior Developer", "Junior Developer"};
        Double[] salary = {100_000d, 1000d, 1850d, 1750d, 2000d, 1500d};

        UserManagement.newAdmin(users[0], passwords[0]);

        for (int i = 1; i < users.length; i++) {
            UserManagement.newUser(users[i], passwords[i], roles[i], salary[i]);
        }

//        UserManagement.newAdmin("a", "a");
//        UserManagement.newUser("b", "b", "Junior Developer", 1500d);
//        UserManagement.newUser("c", "c", "Junior Developer", 1500d);
//        UserManagement.newUser("d", "d", "Junior Developer", 1500d);
    }
}
