package se.dsve;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private static final String TEST_NOT_WRITTEN = "Test not written!";
//    fail(TEST_NOT_WRITTEN);

    static void loggedIn_Admin() {
        Main.loggedInUserName = "admin1";
        Main.loggedInUserId = 0;
        Main.loggedInAsAdmin = true;
        Main.isLoggedIn = true;
    }

    private static String userName = "Adam01";
    private static String userPassword = "01Adam";
    private static String userRole = "Developer";
    private static double userSalary = 2000.01d;

    private static String adminName = "admin1";
    private static String adminPassword = "admin1234";

    private static String passwordStringToVerify = "aR1?";

    @BeforeAll
    static void setUp() {
        UserManagement.newAdmin(adminName, adminPassword);
        UserManagement.newUser(userName, userPassword, userRole, userSalary);
    }

    /////////////////////////////
    //  checkLoginCredentials  //
    /////////////////////////////
    // Admin
    @Test
    void checkLoginCredentials_admin_0() {
        assertTrue(Controller.checkLoginCredentials(adminName, adminPassword));
    }

    @Test
    void checkLoginCredentials_admin_1() {
        assertFalse(Controller.checkLoginCredentials(adminName, userPassword));
    }

    @Test
    void checkLoginCredentials_admin_2() {
        assertFalse(Controller.checkLoginCredentials(userName, adminPassword));
    }

    @Test
    void checkLoginCredentials_admin_IntegrationTest() {
        assertTrue(Controller.checkLoginCredentials(UserManagement.getUsers().get(0).getName(), UserManagement.getUsers().get(0).getPassword()));
        System.out.println(Main.loggedInUserName);
        assertEquals(Main.loggedInUserName, adminName);
        assertEquals(0, Main.loggedInUserId);
        assertTrue(Main.loggedInAsAdmin);
        assertTrue(Main.isLoggedIn);
    }

    // User
    @Test
    void checkLoginCredentials_user_0() {
        assertTrue(Controller.checkLoginCredentials(userName, userPassword));
    }

    @Test
    void checkLoginCredentials_user_1() {
        assertFalse(Controller.checkLoginCredentials(adminName, userPassword));
    }

    @Test
    void checkLoginCredentials_user_2() {
        assertFalse(Controller.checkLoginCredentials(userName, adminPassword));
    }

    @Test
    void checkLoginCredentials_user_IntegrationTest() {
        assertTrue(Controller.checkLoginCredentials(UserManagement.getUsers().get(1).getName(), UserManagement.getUsers().get(1).getPassword()));
        assertEquals(Main.loggedInUserName, userName);
        assertEquals(1, Main.loggedInUserId);
        assertFalse(Main.loggedInAsAdmin);
        assertTrue(Main.isLoggedIn);
    }

    ////////////////////////
    //  Common functions  //
    ////////////////////////
    @Test
    void logout() {
        loggedIn_Admin();
        Controller.logout();
        if (Main.loggedInUserName.equals("") && Main.loggedInUserId == -1 && !Main.loggedInAsAdmin && !Main.isLoggedIn) {
            System.out.println("Success");
        } else {
            fail("credentials not cleared");
        }
    }

    ///////////////////////////////
    //  Standard User functions  //
    ///////////////////////////////
    @Test
    void requestChangeRoll_Function() {
        int oldId = Main.loggedInUserId;
        Main.loggedInUserId = 1;
        String newRequestedRole = "Bäver";
        Controller.requestChangeRoll_Function(newRequestedRole);
        assertEquals(UserManagement.getUsers().get(1).getRequestedRole(), newRequestedRole);
        Main.loggedInUserId = oldId;
    }

    @Test
    void requestChangeSalary_Function() {
        int oldId = Main.loggedInUserId;
        Main.loggedInUserId = 1;
        double newRequestedSalary = userSalary + 1000d;
        Controller.requestChangeSalary_Function(newRequestedSalary);
        assertEquals(UserManagement.getUsers().get(1).getRequestedSalary(), newRequestedSalary);
        Main.loggedInUserId = oldId;
    }

    ////////////////////////////
    //  Admin User functions  //
    ////////////////////////////

    @Test
    void listUsersWithPasswords() {
        Controller.listUsersWithPasswords();
    }

    @Test
    void countRequestedChanges() {
        int id = 2;
        String newRole = "Senior Developer";
        double newSalary = userSalary + 1500d;

        UserManagement.newUser(userName, userPassword, userRole, userSalary);   // ID = 2
        UserManagement.getUsers().get(id).setRequestedRole(newRole);
        UserManagement.getUsers().get(id).setRequestedSalary(newSalary);

        assertEquals(2, Controller.countRequestedChanges());
    }

    @Test
    void listRequestedChanges() {
        Controller.listRequestedChanges();
    }

    @Test
    void monthlyRun() {
        int id = 0;
        double oldSaldo = UserManagement.getUsers().get(id).getSaldo();
        double salary = UserManagement.getUsers().get(id).getSalary();
        Controller.monthlyRun();
        assertEquals(oldSaldo + salary, UserManagement.getUsers().get(id).getSaldo());
    }

    @Test
    void userIsUnique_Unique() {
        assertTrue(Controller.userIsUnique("Alex07"));
    }

    @Test
    void userIsUnique_Duplicate() {
        assertFalse(Controller.userIsUnique(userName));
    }

    @Test
    void isBothNameAndPasswordValid_0() {
        assertTrue(Controller.isBothNameAndPasswordValid(userName, userPassword));
    }

    @Test
    void isBothNameAndPasswordValid_1() {
        assertFalse(Controller.isBothNameAndPasswordValid(userName, passwordStringToVerify));
    }

    @Test
    void isBothNameAndPasswordValid_2() {
        assertFalse(Controller.isBothNameAndPasswordValid(passwordStringToVerify, userName));
    }

    @Test
    void isBothNameAndPasswordValid_3() {
        assertFalse(Controller.isBothNameAndPasswordValid("adam#1", "12s#wd"));
    }

    @Test
    void isBothNameAndPasswordValid() {
        isBothNameAndPasswordValid_0();
        isBothNameAndPasswordValid_1();
        isBothNameAndPasswordValid_2();
        isBothNameAndPasswordValid_3();
    }


    @Test
    void validateFormatNamePassword_0() {
        assertTrue(Controller.validateFormatNamePassword(userName));
    }

    @Test
    void validateFormatNamePassword_1() {
        assertTrue(Controller.validateFormatNamePassword(userPassword));
    }

    @Test
    void validateFormatNamePassword_2() {
        assertFalse(Controller.validateFormatNamePassword("Adam1"));
    }

    @Test
    void validateFormatNamePassword_3() {
        assertFalse(Controller.validateFormatNamePassword("Ada01"));
    }

    @Test
    void validateFormatNamePassword_4() {
        assertFalse(Controller.validateFormatNamePassword("Adamm01"));
    }

    @Test
    void validateFormatNamePassword_5() {
        assertFalse(Controller.validateFormatNamePassword("Adam001"));
    }

    @Test
    void validateFormatNamePassword_6() {
        assertFalse(Controller.validateFormatNamePassword("12#&as"));
    }

    @Test
    void validateFormatNamePassword() {
        validateFormatNamePassword_0();
        validateFormatNamePassword_1();
        validateFormatNamePassword_2();
        validateFormatNamePassword_3();
    }

    @Test
    void verifyValidInput() {
        verifyValidInput_0();
        verifyValidInput_1();
        verifyValidInput_2();
        verifyValidInput_3();
    }

    @Test
    void verifyValidInput_0() {
        assertEquals('c', Controller.verifyValidInput(passwordStringToVerify.toLowerCase().charAt(0)));
    }

    @Test
    void verifyValidInput_1() {
        assertEquals('c', Controller.verifyValidInput(passwordStringToVerify.toLowerCase().charAt(1)));
    }

    @Test
    void verifyValidInput_2() {
        assertEquals('n', Controller.verifyValidInput(passwordStringToVerify.toLowerCase().charAt(2)));
    }

    @Test
    void verifyValidInput_3() {
        assertEquals('i', Controller.verifyValidInput(passwordStringToVerify.toLowerCase().charAt(3)));
    }


    ///////////////////////
    //  Handle Requests  //
    ///////////////////////
    @Test
    void confirmChangeRole() {
        int id = 1;
        String newRole = "Senior Developer";
        UserManagement.getUsers().get(id).setRequestedRole(newRole);
        Controller.confirmChangeRole(id);
        assertEquals(UserManagement.getUsers().get(id).getRole(), UserManagement.getUsers().get(id).getRequestedRole());
    }

    @Test
    void confirmChangeSalary() {
        int id = 1;
        double newSalary = UserManagement.getUsers().get(id).getSaldo() + 333d;
        UserManagement.getUsers().get(id).setRequestedSalary(newSalary);
        Controller.confirmChangeSalary(id);
        assertEquals(UserManagement.getUsers().get(id).getSalary(),
                UserManagement.getUsers().get(id).getRequestedSalary());
    }

    // Integrity test
    @Test
    void confirmAll() {
        String newRoleAdmin = UserManagement.getUsers().get(0).getRole() + " Senior";
        String newRoleUser = UserManagement.getUsers().get(1).getRole() + " Senior";
        UserManagement.getUsers().get(0).setRequestedRole(newRoleAdmin);
        UserManagement.getUsers().get(1).setRequestedRole(newRoleUser);

        double newSalaryAdmin = UserManagement.getUsers().get(0).getSalary() + 500.00d;
        double newSalaryUser = UserManagement.getUsers().get(1).getSalary() + 500.00d;
        UserManagement.getUsers().get(0).setRequestedSalary(newSalaryAdmin);
        UserManagement.getUsers().get(1).setRequestedSalary(newSalaryUser);

        Controller.confirmAll();

        assertEquals(newRoleAdmin, UserManagement.getUsers().get(0).getRole());
        assertEquals(newRoleUser, UserManagement.getUsers().get(1).getRole());
        assertEquals(newSalaryAdmin, UserManagement.getUsers().get(0).getSalary());
        assertEquals(newSalaryUser, UserManagement.getUsers().get(1).getSalary());
    }

    @Test
    void declineAll() {
        String oldRoleAdmin = UserManagement.getUsers().get(0).getRole();
        String oldRoleUser = UserManagement.getUsers().get(1).getRole();

        String newRoleAdmin = oldRoleAdmin + " Senior";
        String newRoleUser = oldRoleUser + " Senior";
        UserManagement.getUsers().get(0).setRequestedRole(newRoleAdmin);
        UserManagement.getUsers().get(1).setRequestedRole(newRoleUser);


        double oldSalaryAdmin = UserManagement.getUsers().get(0).getSalary();
        double oldSalaryUser = UserManagement.getUsers().get(1).getSalary();

        double newSalaryAdmin = oldSalaryAdmin + 500.00d;
        double newSalaryUser = oldSalaryUser + 500.00d;
        UserManagement.getUsers().get(0).setRequestedSalary(newSalaryAdmin);
        UserManagement.getUsers().get(1).setRequestedSalary(newSalaryUser);

        Controller.declineAll();

        assertEquals(oldRoleAdmin, UserManagement.getUsers().get(0).getRequestedRole());
        assertEquals(oldRoleUser, UserManagement.getUsers().get(1).getRequestedRole());
        assertEquals(oldSalaryAdmin, UserManagement.getUsers().get(0).getRequestedSalary());
        assertEquals(oldSalaryUser, UserManagement.getUsers().get(1).getRequestedSalary());
    }

    @Test
    void declineChangeRoll() {
        String oldRoleAdmin = UserManagement.getUsers().get(0).getRole();

        String newRoleAdmin = oldRoleAdmin + " Senior";
        UserManagement.getUsers().get(0).setRequestedRole(newRoleAdmin);

        Controller.declineChangeRoll(0);

        assertEquals(oldRoleAdmin, UserManagement.getUsers().get(0).getRequestedRole());
    }

    @Test
    void declineChangeSalary() {
        double oldSalaryAdmin = UserManagement.getUsers().get(0).getSalary();

        double newSalaryAdmin = oldSalaryAdmin + 500.00d;
        UserManagement.getUsers().get(0).setRequestedSalary(newSalaryAdmin);

        Controller.declineChangeSalary(0);

        assertEquals(oldSalaryAdmin, UserManagement.getUsers().get(0).getRequestedSalary());
    }

//    @Disabled   // Breaks all test if not running last
//    @Test
//    void deleteAllUsers() {
//        Controller.createSomeUsers();
//        UserManagement.eraseAllUsers();
//        assertEquals(0, UserManagement.getUsers().size());
//    }

    @AfterAll
    static void tearDown() {
        UserManagement.eraseAllUsers();
        assertEquals(0, UserManagement.getUsers().size());
        Controller.logout();
    }

}