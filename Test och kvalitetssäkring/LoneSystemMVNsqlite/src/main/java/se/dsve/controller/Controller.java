package se.dsve.controller;

import se.dsve.Main;
import se.dsve.UserManagement;
import se.dsve.model.DataSource;
import se.dsve.model.Employee;

import java.util.List;

public class Controller {
    private static DataSource dataSource;

    private static void openDataSource() {
        dataSource = new DataSource();
        dataSource.open();
    }

    private static void closeDataSource() {
        dataSource.close();
    }

    ///////////////////////
    //  Login functions  //
    ///////////////////////
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

    public static boolean checkLoginCredentials(String userName, String userPassword) {

        openDataSource();

        if (dataSource.loginValidation(userName, userPassword)) {

            if (dataSource.loginValidationIsAdmin(userName)) {
                Main.loggedInAsAdmin = true;
            } else {
                Main.loggedInAsAdmin = false;
            }
            Main.loggedInUserName = userName;
//            Main.loggedInUserId = i;
            Main.isLoggedIn = true;
            dataSource.close();
            return true;
        }

        closeDataSource();
        return false;
    }


    ////////////////////////
    //  Common functions  //
    ////////////////////////
    // Not testable
    static void printSaldo() {
        openDataSource();
        System.out.println("\nAkumulerat Saldo är: " + dataSource.getSaldoForUser());
        closeDataSource();
    }

    // Not testable
    static void printSalary() {
        openDataSource();
        System.out.println("\nNuvarande lön är: " + dataSource.getSalaryForUser());
        closeDataSource();
    }

    // Not testable
    static void printRole() {
        openDataSource();
        System.out.println("\nNuvarande roll är: " + dataSource.getRoleForUser());
        closeDataSource();
    }

    public static void logout() {
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

    public static void requestChangeRoll_Function(String newRole) {
        openDataSource();
        dataSource.requestChangeRoll(newRole);
        closeDataSource();
    }

    static void requestChangeSalary() {
        System.out.println("\nÖnskad ny lön är: ");
        requestChangeSalary_Function(UserInput.readDouble());
    }

    public static void requestChangeSalary_Function(double newSalary) {
        openDataSource();
        dataSource.requestChangeSalary(newSalary);
        closeDataSource();
    }

    static void userSelfErase() {
        System.out.println("Bekräfta med ditt användarnamn och lösenord!");

        System.out.print("Skriv Användarnamn: ");
        String name = UserInput.getString();

        System.out.print("Skriv Lösenord: ");
        String password = UserInput.getString();

        if (Main.loggedInUserName.equals(name) || Main.loggedInUserName.equals("admin1")) {
            openDataSource();
            dataSource.deleteEmployee(name, password);
            closeDataSource();
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
    public static void listUsersWithPasswords() {

        openDataSource();
        System.out.println("| Username | Password |");
        System.out.println("+----------+--------- +");
        List<Employee> employees = dataSource.getUsernamePassword();
        if (employees == null) {
            System.out.println("No employees!");
            return;
        }

        for (Employee employee : employees) {
            System.out.println("|  " + employee.getName() + "  |  " + employee.getPassword() + "  |");
        }
        closeDataSource();
        System.out.println("+----------+--------- +");
    }

    public static int countRequestedChanges() {
        openDataSource();
        int changes = dataSource.countRequestedChanges();
        closeDataSource();

        return changes;
    }

    public static void listRequestedChanges() {
        openDataSource();

        List<Employee> employees = dataSource.getRequestedChanges();
        if (employees == null) {
            System.out.println("No employees!");
            return;
        }

        System.out.println("Requested changes:");
        if (countRequestedChanges() > 0) {
            for (Employee employee : employees) {
                if (employee.getSalary() != employee.getRequestedSalary()) {
                    System.out.println(employee.getName() + " request a change from: " + employee.getSalary() + " to: " + employee.getRequestedSalary());
                }
                if (!employee.getRole().equals(employee.getRequestedRole())) {
                    System.out.println(employee.getName() + " request a change from: " + employee.getRole() + " to: " + employee.getRequestedRole());
                }
            }
        } else {
            System.out.println("No requests!");
        }

        closeDataSource();
    }

    public static void monthlyRun() {
        openDataSource();
        dataSource.monthlyRun();
        closeDataSource();
    }

    static void adminCreateNewUser() throws Exception {
        System.out.print("\nAnvändarnam och lösenord skall vara 6 tecken långt," +
                " samt innehålla bara bokstäver (4st) och siffror (2st)");
        System.out.print("\nSkriv Användarnamn: ");
        String name = UserInput.getString();

        System.out.print("Skriv Lösenord: ");
        String password = UserInput.getString();

        if (isBothNameAndPasswordValid(name, password)) {

            openDataSource();
            if (dataSource.userIsUnique(name)) {
                System.out.print("Skriv Roll: ");
                String role = UserInput.getString();

                System.out.print("Skriv Lön: ");
                double salary = UserInput.readDouble();

                dataSource.createEmployee(name, password, false, role, salary);
            } else {
                System.out.println("Username is already in use!");
            }
            closeDataSource();
        } else {
            System.out.println("Invalid input!");
        }
    }

    public static boolean isBothNameAndPasswordValid(String name, String password) {
        if (validateFormatNamePassword(name) && validateFormatNamePassword(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateFormatNamePassword(String input) {
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

    public static char verifyValidInput(char c) {
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


//    public static void adminCreateNewUser_Function(String name, String password, String role, double salary) {
//        UserManagement.newUser(name, password, role, salary);
//    }

    static void adminEraseUsers() {
        userSelfErase();
    }

    ///////////////////////
    //  Handle Requests  //
    ///////////////////////

    public static void confirmChangeRole(int id) {
//        if (id >= 0 && id < UserManagement.getUsers().size()) {
//            String newRole = UserManagement.getUsers().get(id).getRequestedRole();
//            UserManagement.getUsers().get(id).setRole(newRole);
//        }
    }

    public static void confirmChangeSalary(int id) {
//        if (id >= 0 && id < UserManagement.getUsers().size()) {
//            double newSalary = UserManagement.getUsers().get(id).getRequestedSalary();
//            UserManagement.getUsers().get(id).setSalary(newSalary);
//        }
    }

    // TODO: fortsätt här!
    private static String INVALID_INPUT = "Invalid input";

    static void handleRequests() {
//        if (countRequestedChanges() > 0) {

//            System.out.println("Requested changes:");
//            for (int i = 0; i < UserManagement.getUsers().size(); i++) {
//                String role = "";
//                double salary = 0.0d;
//
//                // Check for changes in roles
//                if (!UserManagement.getUsers().get(i).getRole().equals(UserManagement.getUsers().get(i).getRequestedRole())) {
//                    role = UserManagement.getUsers().get(i).getRequestedRole();
//                }
//
//                // Check for changes in salary
//                if (UserManagement.getUsers().get(i).getSalary() != UserManagement.getUsers().get(i).getRequestedSalary()) {
//                    salary = UserManagement.getUsers().get(i).getRequestedSalary();
//                }
//
//
//                if (!role.equals("") && salary != 0.0d) {
//                    handleRequests_ChangeSomething(i);
//                    handleRequests_ChangeRole(i);
//                    handleRequests_ChangeSalary(i);
//                } else if ((!role.equals("") && salary == 0.0d)) {
//                    handleRequests_ChangeSomething(i);
//                    handleRequests_ChangeRole(i);
//                } else if ((role.equals("") && salary != 0.0d)) {
//                    handleRequests_ChangeSomething(i);
//                    handleRequests_ChangeSalary(i);
//                }
//            }
//        } else {
//            System.out.println("No more requests!");
//        }
    }

    static void handleRequests_ChangeSomething(int id) {
//        System.out.println("\n" + UserManagement.getUsers().get(i).getName() + " want the following changes:");
//        System.out.println("ID: " + id);
    }

    static void handleRequests_ChangeRole(int i) {
//        System.out.print("Allow role change from " + UserManagement.getUsers().get(i).getRole()
//                + " to " + UserManagement.getUsers().get(i).getRequestedRole() + "? (Y/N)");
//        String answer = UserInput.getString();
//        if ("y".equals(answer.toLowerCase())) {
//            confirmChangeRole(i);
//        } else if ("n".equals(answer.toLowerCase())) {
//            declineChangeRoll(i);
//        }
    }

    static void handleRequests_ChangeSalary(int i) {
//        System.out.print("Allow salary change from " + UserManagement.getUsers().get(i).getSalary()
//                + " to " + UserManagement.getUsers().get(i).getRequestedSalary() + "? (Y/N)");
//        String answer = UserInput.getString();
//        if ("y".equals(answer.toLowerCase())) {
//            confirmChangeSalary(i);
//        } else if ("n".equals(answer.toLowerCase())) {
//            declineChangeSalary(i);
//        }
    }

    public static void confirmAll() {
        openDataSource();
        dataSource.confirmAll();
        closeDataSource();
    }

    public static void declineAll() {
        openDataSource();
        dataSource.declineAll();
        closeDataSource();
    }

    public static void declineChangeRoll(int id) {
//        if (id >= 0 && id < UserManagement.getUsers().size()) {
//            String oldRole = UserManagement.getUsers().get(id).getRole();
//            UserManagement.getUsers().get(id).setRequestedRole(oldRole);
//        }
    }

    public static void declineChangeSalary(int id) {
//        if (id >= 0 && id < UserManagement.getUsers().size()) {
//            double oldSalary = UserManagement.getUsers().get(id).getSalary();
//            UserManagement.getUsers().get(id).setRequestedSalary(oldSalary);
//        }
    }
}
