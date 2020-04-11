package se.dsve;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import se.dsve.controller.Controller;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void main_verifyNoUsers() {
        assertEquals(0, UserManagement.getUsers().size());
    }

    @Test
    void main() {
//        Main.addUsers();
//        assertEquals(10, UserManagement.getUsers().size());
    }

    @Test
    void integrationTest() {
        main_verifyNoUsers();
        main();
    }

    @AfterAll
    static void tearDown() {
        UserManagement.eraseAllUsers();
        assertEquals(0, UserManagement.getUsers().size());
        Controller.logout();
    }
}
