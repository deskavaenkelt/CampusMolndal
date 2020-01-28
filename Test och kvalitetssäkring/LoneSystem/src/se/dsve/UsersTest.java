package se.dsve;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {
    private static Users testUser;
    private static String userName = "Adam01";
    private static String userPassword = "01Adam";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testUser = new Users(userName, userPassword);
    }

    @org.junit.jupiter.api.Test
    void getId() {
        System.out.println("getId: testUser.getId() = " + testUser.getId());
        assertEquals(3, testUser.getId());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        System.out.println("getName: testUser.getId() = " + testUser.getId());
        assertEquals(userName, testUser.getName());
    }

    @org.junit.jupiter.api.Test
    void getPassword() {
        System.out.println("getPassword: testUser.getId() = " + testUser.getId());
        assertEquals(userPassword, testUser.getPassword());
    }

    // Integration test
    @org.junit.jupiter.api.Test
    void testUsersConstructor() {
        System.out.println("getPassword: testUser.getId() = " + testUser.getId());
        assertEquals(2, testUser.getId());
        assertEquals(userName, testUser.getName());
        assertEquals(userPassword, testUser.getPassword());
    }
}