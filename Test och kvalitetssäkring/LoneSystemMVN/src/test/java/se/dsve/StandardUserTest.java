package se.dsve;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardUserTest {

    private static StandardUser standardUser;
    private static String userName = "Bertil02";
    private static String userPassword = "02Bertil";
    private static String userRole = "User";
    private static double userSalary = 2000.01d;

    private static String newUserRole = "User";
    private static double newUserSalary = 1234.56d;

    private static StandardUser adminUser;
    private static String adminName = "admin1";
    private static String adminPassword = "admin1234";

    @BeforeEach
    void setUp() {
        standardUser = new StandardUser(userName, userPassword, userRole, userSalary);
        adminUser = new StandardUser(adminName, adminPassword);
    }

    // Unit tests
    // Standard User
    @Test
    void getRole() {
        assertEquals(userRole, standardUser.getRole());
    }

    @Test
    void setRoll() {
        standardUser.setRole(newUserRole);
        assertEquals(newUserRole, standardUser.getRole());
    }

    @Test
    void getSalary() {
        assertEquals(userSalary, standardUser.getSalary());
    }

    @Test
    void setSalary() {
        standardUser.setSalary(newUserSalary);
        assertEquals(newUserSalary, standardUser.getSalary());
    }

    // Requests
    @Test
    void getRequestedRole() {
        assertEquals(userRole, standardUser.getRequestedRole());
    }

    @Test
    void setRequestedRole() {
        String newUserRequestedRole = "CEO";
        standardUser.setRequestedRole(newUserRequestedRole);
        assertEquals(newUserRequestedRole, standardUser.getRequestedRole());
    }

    @Test
    void getRequestedSalary() {
        assertEquals(userSalary, standardUser.getRequestedSalary());
    }

    @Test
    void setRequestedSalary() {
        double newUserRequestedSalary = 9999.99d;
        standardUser.setRequestedSalary(newUserRequestedSalary);
        assertEquals(newUserRequestedSalary, standardUser.getRequestedSalary());
    }

    // Saldo
    @Test
    void getSaldo() {
        assertEquals(0, standardUser.getSaldo());
    }

    @Test
    void updateSaldo() {
        double updateSaldo = 200.00;
        standardUser.updateSaldo(updateSaldo);
        assertEquals(updateSaldo, standardUser.getSaldo());
    }

    // Admin User
    @Test
    void newAdminName() {
        assertEquals(adminName, adminUser.getName());
    }

    @Test
    void newAdminPassword() {
        assertEquals(adminPassword, adminUser.getPassword());
    }

    @Test
    void newAdminIsAdmin() {
        assertTrue(adminUser.isAdmin());
    }

    @Test
    void newAdminRole() {
        assertEquals("Administrator", adminUser.getRole());
    }

    @Test
    void newAdminSalary() {
        assertEquals(100_000d, adminUser.getSalary());
    }

    @Test
    void newAdminSaldo() {
        assertEquals(0, adminUser.getSaldo());
    }

    // Integration tests
    @Test
    void createStandardUser() {
        assertEquals(userName, standardUser.getName());
        assertEquals(userPassword, standardUser.getPassword());
        assertEquals(userRole, standardUser.getRole());
        assertEquals(userSalary, standardUser.getSalary());
        assertFalse(standardUser.isAdmin());
    }

    @Test
    void createStandardUserAndChangeRoleSalary() {
        assertEquals(userName, standardUser.getName());
        assertEquals(userPassword, standardUser.getPassword());
        assertEquals(userRole, standardUser.getRole());
        assertEquals(userSalary, standardUser.getSalary());
        assertFalse(standardUser.isAdmin());

        standardUser.setRole(newUserRole);
        standardUser.setSalary(newUserSalary);

        assertEquals(newUserRole, standardUser.getRole());
        assertEquals(newUserSalary, standardUser.getSalary());
    }

    @AfterAll
    static void tearDown() {
        UserManagement.eraseAllUsers();
    }
}