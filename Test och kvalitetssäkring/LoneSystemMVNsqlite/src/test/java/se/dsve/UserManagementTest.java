package se.dsve;



import org.junit.jupiter.api.AfterAll;
import se.dsve.controller.Controller;

import static org.junit.jupiter.api.Assertions.*;

class UserManagementTest {
//    private static final String TEST_NOT_WRITTEN = "Test not written!";
//    fail(TEST_NOT_WRITTEN);

    private static String userName = "Carl03";
    private static String userPassword = "03Carl";
    private static String userRole = "Developer";
    private static double userSalary = 2000.01d;

    private static String adminName = "admin2";
    private static String adminPassword = "admin12345";

    @org.junit.jupiter.api.BeforeAll
    static void setUp() {
        UserManagement.newUser(userName, userPassword, userRole, userSalary);
        UserManagement.newAdmin(adminName, adminPassword);
    }

    // New User
    @org.junit.jupiter.api.Test
    void newUser_AddedToArrayList() {
        assertEquals(2, UserManagement.getUsers().size());
    }

    @org.junit.jupiter.api.Test
    void newUser_AddedUser() {
        assertEquals(userName, UserManagement.getUsers().get(0).getName());
    }

    @org.junit.jupiter.api.Test
    void newUser_AddedPassword() {
        assertEquals(userPassword, UserManagement.getUsers().get(0).getPassword());
    }

    @org.junit.jupiter.api.Test
    void newUser_AddedRole() {
        assertEquals(userRole, UserManagement.getUsers().get(0).getRole());
    }

    @org.junit.jupiter.api.Test
    void newUser_AddedSalary() {
        assertEquals(userSalary, UserManagement.getUsers().get(0).getSalary());
    }

    @org.junit.jupiter.api.Test
    void newUser_IsNotAdmin() {
        assertFalse(UserManagement.getUsers().get(0).isAdmin());
    }

    // Integration test
    @org.junit.jupiter.api.Test
    void newUser_Added() {
        newUser_AddedToArrayList();
        newUser_AddedUser();
        newUser_AddedPassword();
        newUser_AddedRole();
        newUser_AddedSalary();
        newUser_IsNotAdmin();
    }

    // New Admin
    @org.junit.jupiter.api.Test
    void newAdmin_AddedToArrayList() {
        assertEquals(2, UserManagement.getUsers().size());
    }

    @org.junit.jupiter.api.Test
    void newAdmin_AddedUser() {
        assertEquals(adminName, UserManagement.getUsers().get(1).getName());
    }

    @org.junit.jupiter.api.Test
    void newAdmin_AddedPassword() {
        assertEquals(adminPassword, UserManagement.getUsers().get(1).getPassword());
    }

    @org.junit.jupiter.api.Test
    void newAdmin_IsAdmin() {
        assertTrue(UserManagement.getUsers().get(1).isAdmin());
    }

    // Integration test
    @org.junit.jupiter.api.Test
    void newAdmin_Added() {
        newUser_AddedToArrayList();
        newUser_AddedUser();
        newUser_AddedPassword();
        newUser_IsNotAdmin();
    }

//    @RepeatedTest(10_000)
    @org.junit.jupiter.api.Test
    void deleteUser() {
        String deleteName = "David04";
        String deletePassword = "04David";
        String deleteRole = "Crap";
        double deleteSalary = 100.00d;
        UserManagement.newUser(deleteName, deletePassword, deleteRole, deleteSalary);
        UserManagement.deleteUser(deleteName, deletePassword);
        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            if (deleteName.equals(UserManagement.getUsers().get(i).getName())) {
                fail("User not deleted!");
            }
        }
    }

    // New roles
    @org.junit.jupiter.api.Test
    void requestNewUserRole() {
        Main.loggedInUserId = 0;
        String newUserRole = "User";
        UserManagement.requestNewUserRole(Main.loggedInUserId, newUserRole);
        assertEquals(newUserRole, UserManagement.getUsers().get(0).getRequestedRole());
    }

    @org.junit.jupiter.api.Test
    void requestNewUserSalary() {
        double newUserSalary = 1234.56d;
        UserManagement.requestNewUserSalary(Main.loggedInUserId, newUserSalary);
        assertEquals(newUserSalary, UserManagement.getUsers().get(0).getRequestedSalary());
    }

    @AfterAll
    static void tearDown() {
        UserManagement.eraseAllUsers();
        assertEquals(0, UserManagement.getUsers().size());
        Controller.logout();
    }
}