package se.dsve;

import org.junit.jupiter.api.AfterAll;
import se.dsve.controller.Controller;
import se.dsve.model.Users;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsersTest {
    private static Users testUser;
    private static String userName = "Adam01";
    private static String userPassword = "01Adam";

    @org.junit.jupiter.api.BeforeAll
    static void setUp() {
        testUser = new Users(userName, userPassword);
    }

    @org.junit.jupiter.api.Test
    void getId() {
        assertEquals(0, testUser.getId());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals(userName, testUser.getName());
    }

    @org.junit.jupiter.api.Test
    void getPassword() {
        assertEquals(userPassword, testUser.getPassword());
    }

    // Integration test
    @org.junit.jupiter.api.Test
    void testUsersConstructor() {
        assertEquals(0, testUser.getId());
        assertEquals(userName, testUser.getName());
        assertEquals(userPassword, testUser.getPassword());
    }

    @AfterAll
    static void tearDown() {
        UserManagement.eraseAllUsers();
        assertEquals(0, UserManagement.getUsers().size());
        Controller.logout();
    }
}