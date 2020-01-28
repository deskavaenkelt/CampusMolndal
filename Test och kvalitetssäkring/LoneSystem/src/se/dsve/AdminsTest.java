package se.dsve;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminsTest {

    private static String userName = "admin1";
    private static String userPassword = "admin1234";

    // Unit testing
    @Test
    void isAdminTrue() {
        Admins admin = new Admins(userName, userPassword, true);
        assertTrue(admin.isAdmin());
    }

    @Test
    void isAdminFalse() {
        Admins admin = new Admins(userName, userPassword, false);
        assertFalse(admin.isAdmin());
    }

    // Integration testing
    @Test
    void AdminToStandardUserConstructorTrue() {
        Admins admin = new Admins(userName, userPassword, true);
        assertEquals(userName, admin.getName());
        assertEquals(userPassword, admin.getPassword());
        assertTrue(admin.isAdmin());
    }
    @Test
    void AdminToStandardUserConstructorFalse() {
        Admins admin = new Admins(userName, userPassword, false);
        assertEquals(userName, admin.getName());
        assertEquals(userPassword, admin.getPassword());
        assertFalse(admin.isAdmin());
    }
}