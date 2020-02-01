package se.dsve;

import org.junit.Test;

public class Main {
    static String loggedInUserName = "";
    static int loggedInUserId = -1;
    static boolean loggedInAsAdmin = false;
    static boolean isLoggedIn = false;
    static boolean keepAppAlive = true;

    public static void main(String[] args) {
        addUsers();
        Menu.login();

    }

    static void addUsers() {
        Controller.createSomeUsers();
    }
}