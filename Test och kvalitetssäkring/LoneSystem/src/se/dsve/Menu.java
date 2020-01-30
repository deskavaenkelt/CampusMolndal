package se.dsve;

public class Menu {
    // Not testable with junit tests
    static void login() {
        while (Main.keepAppAlive) {
            View.login();
            Controller.enterUserNameAndPassword();
            if (Main.loggedInAsAdmin) {
                loggedIn_Admin();
            } else {
                loggedIn_User();
            }
        }
    }

    static void loggedIn_User() {
        while (Main.isLoggedIn) {
            View.loggedIn_User();
            loggedIn_User_switch(UserInput.readNumber());
        }
    }

    static void loggedIn_User_switch(int userInput) {
        switch (userInput) {
            case 1:
                Controller.printSaldo();
                break;
            case 2:
                Controller.printSalary();
                break;
            case 3:
                Controller.printRole();
                break;
            case 4:
                Controller.requestChangeSalary();
                break;
            case 5:
                Controller.requestChangeRoll();
                break;
            case 8:
                Controller.userSelfErase();
                if (!Main.isLoggedIn) {
                    Controller.logout();
                    login();
                }
                break;
            case 0:
                Controller.logout();
                login();
                break;
            default:
                Controller.wrongInput();
                break;
        }
    }

    static void loggedIn_Admin() {
        while (Main.isLoggedIn) {
            View.loggedIn_Admin();
            loggedIn_Admin_switch(UserInput.readNumber());
        }
    }

    static void loggedIn_Admin_switch(int userInput) {
        switch (userInput) {
            case 1:
                Controller.printSaldo();
                break;
            case 2:
                Controller.printSalary();
                break;
            case 3:
                Controller.printRole();
                break;
            case 4:
                Controller.listUsersWithPasswords();
                break;
            case 5:
                loggedIn_Admin_HandleRequests();
                break;
            case 6:
                Controller.monthlyRun();
                break;
            case 7:
                Controller.adminCreateNewUser();
                break;
            case 8:
                Controller.adminEraseUsers();
                break;
            case 0:
                Controller.logout();
                break;
            default:
                Controller.wrongInput();
                break;
        }
    }

    static boolean handleMoreRequests = true;

    static void loggedIn_Admin_HandleRequests() {
        handleMoreRequests = true;
        while (handleMoreRequests) {
            View.loggedIn_Admin_requests();
            loggedIn_Admin_HandleRequests_switch(UserInput.readNumber());
        }
    }

    static void loggedIn_Admin_HandleRequests_switch(int userInput) {
        switch (userInput) {
            case 1:
                Controller.listRequestedChanges();
                break;
            case 2:
                Controller.handleRequests();
                break;
            case 3:
                Controller.confirmAll();
                break;
            case 4:
                Controller.declineAll();
                break;
            case 0:
                handleMoreRequests = false;
                break;
            default:
                Controller.wrongInput();
                break;
        }
    }
}
