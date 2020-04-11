package se.dsve;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import se.dsve.controller.Controller;

import static org.junit.jupiter.api.Assertions.*;

public class SystemTest {
    // This is a big test to verify as much functionality as possible and call the same functions ass menu.class do.
    // Scanner methods will be excluded!

    private static String[] users = {"admin1", "Adam01", "Bert02", "Carl03", "Eric04", "Fido05"};
    private static String[] passwords = {"admin1234", "01Adam", "02Bert", "03Carl", "04Eric", "05Fido"};
    private static String[] roles = {"Administrator", "User", "Developer", "Accounting", "Senior Developer", "Junior Developer"};
    private static Double[] salary = {100_000d, 1000d, 1850d, 1750d, 2000d, 1500d};

    private static String[] bckRoles;
    private static Double[] bckSalary;

    private static String newRole = "Bäver";
    private static double newSalary = 666d;

    private static int numberOfMonthlyRuns = 0;


    @Disabled
    @BeforeAll
    static void setUp() {
//        Controller.createSomeUsers();
        bckRoles = roles;
        bckSalary = salary;
    }

    static void verify_clean_slate() {
        assertEquals("", Main.loggedInUserName);
        assertEquals(-1, Main.loggedInUserId);
        assertFalse(Main.loggedInAsAdmin);
        assertFalse(Main.isLoggedIn);
        assertTrue(Main.keepAppAlive);
    }

    static void verify_users_created() {
        for (int i = 0; i < users.length; i++) {
            assertEquals(users[i], UserManagement.getUsers().get(i).getName());
            assertEquals(passwords[i], UserManagement.getUsers().get(i).getPassword());
            assertEquals(roles[i], UserManagement.getUsers().get(i).getRole());
            assertEquals(salary[i], UserManagement.getUsers().get(i).getSalary());
        }
    }

    static void login_with_a_user(int id) {
        // Log in with standard user
        Controller.checkLoginCredentials(users[id], passwords[id]);
        verify_user_logged_in(id, UserManagement.getUsers().get(id).isAdmin());

        // Confirm role and salary
        assertEquals(roles[id], UserManagement.getUsers().get(id).getRole());
        assertEquals(salary[id], UserManagement.getUsers().get(id).getSalary());
        assertEquals((salary[id] * numberOfMonthlyRuns), UserManagement.getUsers().get(id).getSaldo());
    }

    static void verify_user_logged_in(int id, boolean isAdmin) {
        assertEquals(users[id], Main.loggedInUserName);
        assertEquals(UserManagement.getUsers().get(id).getId(), Main.loggedInUserId);
        assertTrue(Main.isLoggedIn);
        assertTrue(Main.keepAppAlive);

        if (isAdmin) {
            assertTrue(Main.loggedInAsAdmin);
        } else {
            assertFalse(Main.loggedInAsAdmin);
        }
    }

    @Disabled
    @Test
    void user_Tests() {
        verify_clean_slate();
        verify_users_created();

        // verify user with id = 1
        int id = 1;

        // Log in with standard user and Confirm role / salary
        login_with_a_user(id);

        // Change role and salary, then verify
        String newRole = "Developer";
        double newSalary = (UserManagement.getUsers().get(id).getSalary() * 2);

        Controller.requestChangeRoll_Function(newRole);
        Controller.requestChangeSalary_Function(newSalary);

        assertEquals(newRole, UserManagement.getUsers().get(id).getRequestedRole());
        assertEquals(newSalary, UserManagement.getUsers().get(id).getRequestedSalary());

        Controller.logout();
        verify_clean_slate();
    }

    void advance_X_Months(int input) {
        for (int j = 0; j < input; j++) {
            Controller.monthlyRun();
            numberOfMonthlyRuns++;
        }
    }

    @Disabled
    @Test
    void admin_Tests() {
        verify_clean_slate();
        verify_users_created();

        int id = 0;

        login_with_a_user(id);

        assertEquals(0, Controller.countRequestedChanges());

        advance_X_Months(3);

        for (int i = 0; i < UserManagement.getUsers().size(); i++) {
            assertEquals((UserManagement.getUsers().get(i).getSalary() * numberOfMonthlyRuns),
                    UserManagement.getUsers().get(i).getSaldo());
        }

        String name = "Lars01";
        int numberOfUsersInDataBase = UserManagement.getUsers().size();
//        Controller.adminCreateNewUser_Function(name, name, "Bäst", 666d);
        assertEquals((numberOfUsersInDataBase + 1), UserManagement.getUsers().size());

        UserManagement.deleteUser(name, name);
        assertEquals(numberOfUsersInDataBase, UserManagement.getUsers().size());

        Controller.logout();
        verify_clean_slate();
    }

    static void requestChangesForThreeUsers() {
        // All users do the same requests, will not verify since the same function works in other tests

        // User 1
        int id = 1;
        login_with_a_user(id);
        Controller.requestChangeRoll_Function(newRole);
        Controller.requestChangeSalary_Function(newSalary);
        Controller.logout();

        // User 2
        id = 2;
        login_with_a_user(id);
        Controller.requestChangeRoll_Function(newRole);
        Controller.logout();

        // User 3
        id = 3;
        login_with_a_user(id);
        Controller.requestChangeSalary_Function(newSalary);
        Controller.logout();

        assertEquals(4, Controller.countRequestedChanges());
    }

    // 3 users will log in an request changes
    // admin will accept all
    // verify
    @Test
    void big_test_accept() {
        verify_clean_slate();
        verify_users_created();

        // 3 users will log in an request changes
        requestChangesForThreeUsers();

        // Admin will accept all
        int id = 0;
        login_with_a_user(id);
        Controller.confirmAll();

        // Verify All new roles
        for (int i = 1; i < 4; i++) {
            assertEquals(UserManagement.getUsers().get(i).getRole(), UserManagement.getUsers().get(i).getRequestedRole());
            assertEquals(UserManagement.getUsers().get(i).getSalary(),
                    UserManagement.getUsers().get(i).getRequestedSalary());
        }

        // Verify no more requests
        assertEquals(0, Controller.countRequestedChanges());


        // Restore all values!
        for (int i = 1; i < 4; i++) {
            UserManagement.getUsers().get(i).setRole(bckRoles[i]);
            UserManagement.getUsers().get(i).setRequestedRole(bckRoles[i]);
            UserManagement.getUsers().get(i).setSalary(bckSalary[i]);
            UserManagement.getUsers().get(i).setRequestedSalary(bckSalary[i]);
        }

        Controller.logout();
        verify_clean_slate();
    }

    // 3 users will log in an request changes
    // admin will deny all
    // verify
    @Test
    void big_test_deny_rev1() {
        verify_clean_slate();
        verify_users_created();

        // 3 users will log in an request changes
        requestChangesForThreeUsers();

        // Admin will deny all
        int id = 0;
        login_with_a_user(id);
        Controller.declineAll();

        // Verify denied all new roles
        for (int i = 1; i < 4; i++) {
            assertEquals(bckRoles[i], UserManagement.getUsers().get(i).getRequestedRole());
            assertEquals(bckRoles[i], UserManagement.getUsers().get(i).getRole());
            assertEquals(bckSalary[i], UserManagement.getUsers().get(i).getRequestedSalary());
            assertEquals(bckSalary[i], UserManagement.getUsers().get(i).getSalary());
        }

        // Verify no more requests
        assertEquals(0, Controller.countRequestedChanges());

        // Restore all values!
        for (int i = 1; i < 4; i++) {
            UserManagement.getUsers().get(i).setRole(bckRoles[i]);
            UserManagement.getUsers().get(i).setRequestedRole(bckRoles[i]);
            UserManagement.getUsers().get(i).setSalary(bckSalary[i]);
            UserManagement.getUsers().get(i).setRequestedSalary(bckSalary[i]);
        }

        Controller.logout();
        verify_clean_slate();
    }

    @AfterAll
    static void tearDown() {
        UserManagement.eraseAllUsers();
        assertEquals(0, UserManagement.getUsers().size());
        Controller.logout();
    }
}


















