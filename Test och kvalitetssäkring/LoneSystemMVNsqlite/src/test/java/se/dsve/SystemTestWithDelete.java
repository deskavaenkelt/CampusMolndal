package se.dsve;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import se.dsve.controller.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SystemTestWithDelete {
    // This is a big test to verify as much functionality as possible and call the same functions ass menu.class do.
    // Scanner methods will be excluded!

    private static String[] users = {"admin1", "Adam01", "Bert02", "Carl03", "Eric04", "Fido05"};
    private static String[] passwords = {"admin1234", "01Adam", "02Bert", "03Carl", "04Eric", "05Fido"};
    private static String[] roles = {"Administrator", "User", "Developer", "Accounting", "Senior Developer", "Junior Developer"};
    private static Double[] salary = {100_000d, 1000d, 1850d, 1750d, 2000d, 1500d};

    @Disabled
    @BeforeAll
    static void setUp() {
//        Controller.createSomeUsers();
    }

    static void verify_users_created() {
        for (int i = 0; i < users.length; i++) {
            assertEquals(users[i], UserManagement.getUsers().get(i).getName());
            assertEquals(passwords[i], UserManagement.getUsers().get(i).getPassword());
            assertEquals(roles[i], UserManagement.getUsers().get(i).getRole());
            assertEquals(salary[i], UserManagement.getUsers().get(i).getSalary());
        }
    }

    @Test
    void user_Tests_erase() {
        verify_users_created();
        // User id 5 = fido05
        int id = 5;
        SystemTest.login_with_a_user(id);
        UserManagement.deleteUser(users[id], passwords[id]);

        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            assertNotEquals(users[id], UserManagement.getUsers().get(id).getName());
        }
        if (!Main.isLoggedIn) {
            Controller.logout();
        }
    }

    @AfterAll
    static void tearDown() {
        UserManagement.eraseAllUsers();
        assertEquals(0, UserManagement.getUsers().size());
        Controller.logout();
    }
}


















