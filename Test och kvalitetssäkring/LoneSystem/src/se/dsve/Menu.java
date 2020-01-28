package se.dsve;

public class Menu {
    // Not testable with junit tests
    static void login() {
        boolean validCredentials = false;

        while (!validCredentials) {
            View.login();

            System.out.println("Enter username:");
            String enteredUsername = UserInput.getString();

            System.out.println("Enter password:");
            String enteredPassword = UserInput.getString();

            validCredentials = Controller.checkLoginCredentials(enteredUsername, enteredPassword);

            if (!validCredentials) {
                System.out.println("Wrong credentials! \n\n");
            }
        }
    }

    static void loggedIn() {
        View.loggedIn();
        int userInput = UserInput.readNumber();

        switch (userInput) {
            case 0:
                // do something
            case 1:
                // do something
            default:
                System.out.println("Wrong input");
        }
    }
}
