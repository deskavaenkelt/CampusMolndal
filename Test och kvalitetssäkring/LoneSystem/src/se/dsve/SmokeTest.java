package se.dsve;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmokeTest {

    private static final String TEST_NOT_WRITTEN = "Test not written!";
//    fail(TEST_NOT_WRITTEN);

    private static String adminName = "admin1";
    private static String adminPassword = "admin1234";

    @BeforeAll
    static void setUp() {
        // CreateUser Tables
        Controller.createSomeUsers();
    }

    ///////////////////////////
    //  Log in and out test  //
    ///////////////////////////
    @Test
    void loginAndOutWith_Admin() {
        // Verify that no one is logged in
        confirmNoOneIsLoggedIn();

        // Login with Admin
        assertTrue(Controller.checkLoginCredentials(adminName, adminPassword));
        confirmAdminIsLoggedIn();

        // Logout
        Controller.logout();

        // Verify that no one is logged in
        confirmNoOneIsLoggedIn();
    }

    @Test
    void loginAndOutWith_Admin_AndDoMonthlyRun() {
        // Verify that no one is logged in
        confirmNoOneIsLoggedIn();

        // Login with Admin
        assertTrue(Controller.checkLoginCredentials(adminName, adminPassword));
        confirmAdminIsLoggedIn();

        doMonthlyRun();

        // Logout
        Controller.logout();

        // Verify that no one is logged in
        confirmNoOneIsLoggedIn();
    }

    void confirmNoOneIsLoggedIn() {
        assertEquals("", Main.loggedInUserName);
        assertEquals(-1, Main.loggedInUserId);
        assertFalse(Main.loggedInAsAdmin);
        assertFalse(Main.isLoggedIn);
    }

    void confirmAdminIsLoggedIn() {
        assertEquals(adminName, Main.loggedInUserName);
        assertEquals(0, Main.loggedInUserId);
        assertTrue(Main.loggedInAsAdmin);
        assertTrue(Main.isLoggedIn);
    }

    void doMonthlyRun() {
        double salary = UserManagement.getUsers().get(0).getSalary();
        Controller.monthlyRun();

        double newSaldo = UserManagement.getUsers().get(0).getSaldo();

        if (newSaldo != salary) {
            fail();
        }
    }
}
