package se.dsve;

//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;
//import org.junit.jupiter.*;
//import org.junit.platform.*;
//import org.junit.vintage.*;

public class Main {

    static String loggedInUserName = "";
    static int loggedInUserId = -1;
    static boolean loggedInAsAdmin = false;
    static boolean isLoggedIn = false;
    static boolean keepAppAlive = true;

    public static void main(String[] args) {

        Controller.createSomeUsers();

        Menu.login();

//        Result result = JUnitCore.runClasses(Users.class, AdminsTest.class, StandardUser.class);
//        for (Failure failure : result.getFailures()){
//            System.out.println(failure.toString());
//        }
//        System.out.println(result.wasSuccessful());
    }
}

// TODO: Hantera requests i admin menyn