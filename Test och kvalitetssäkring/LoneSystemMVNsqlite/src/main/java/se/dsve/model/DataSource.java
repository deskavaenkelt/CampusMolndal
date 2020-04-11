package se.dsve.model;

import se.dsve.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "employees.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/lars/GitHub/CampusMolndal/Test och kvalitetssäkring/LoneSystemMVNsqlite/" + DB_NAME;

    public static final String TABLE_EMPLOYEES = "employees";
    public static final String COLUMN_EMPLOYEES_NAME = "name";
    public static final String COLUMN_EMPLOYEES_PASSWORD = "password";
    public static final String COLUMN_EMPLOYEES_ISADMIN = "isAdmin";
    public static final String COLUMN_EMPLOYEES_ROLE = "role";
    public static final String COLUMN_EMPLOYEES_SALARY = "salary";
    public static final String COLUMN_EMPLOYEES_REQUESTED_ROLE = "requestedRole";
    public static final String COLUMN_EMPLOYEES_REQUESTED_SALARY = "requestedSalary";
    public static final String COLUMN_EMPLOYEES_SALDO = "saldo";

    public static final int INDEX_EMPLOYEES_NAME = 1;
    public static final int INDEX_EMPLOYEES_PASSWORD = 2;
    public static final int INDEX_EMPLOYEES_ISADMIN = 3;
    public static final int INDEX_EMPLOYEES_ROLE = 4;
    public static final int INDEX_EMPLOYEES_SALARY = 5;
    public static final int INDEX_EMPLOYEES_REQUESTED_ROLE = 6;
    public static final int INDEX_EMPLOYEES_REQUESTED_SALARY = 7;
    public static final int INDEX_EMPLOYEES_SALDO = 8;


    public String[] users = {"admin1", "Adam01", "Bert02", "Carl03", "Eric04", "Fido05"};
    public String[] passwords = {"admin1234", "01Adam", "02Bert", "03Carl", "04Eric", "05Fido"};
    private static boolean[] isAdmin = {true, false, false, false, false, false};
    private static String[] roles = {"Administrator", "User", "Developer", "Accounting", "Senior Developer", "Junior Developer"};
    private static Double[] salary = {100_000d, 1000d, 1850d, 1750d, 2000d, 1500d};

    public static final String CREATE_DATABASE_IF_NOT_EXIST =
            "CREATE TABLE IF NOT EXISTS employees (" +
                    "name TEXT, " +
                    "password TEXT, " +
                    "isAdmin BOOLEAN, " +
                    "role TEXT," +
                    "salary DOUBLE," +
                    "requestedRole TEXT," +
                    "requestedSalary DOUBLE," +
                    "saldo DOUBLE)";

    public static final String QUERY_FOR_USERS_AND_PASSWORDS =
            "SELECT * FROM " + TABLE_EMPLOYEES;


    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to DB: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public void connectToDb() {
        // Auto close connection to DB
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = conn.createStatement()) {
            statement.execute(CREATE_DATABASE_IF_NOT_EXIST);
        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public void createEmployee(String name, String password, boolean isAdmin,
                               String role, double salary) throws Exception {
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = conn.createStatement()) {
            statement.execute("INSERT INTO " + TABLE_EMPLOYEES +
                    " (" + COLUMN_EMPLOYEES_NAME + ", " +
                    COLUMN_EMPLOYEES_PASSWORD + ", " +
                    COLUMN_EMPLOYEES_ISADMIN + ", " +
                    COLUMN_EMPLOYEES_ROLE + ", " +
                    COLUMN_EMPLOYEES_SALARY + ", " +
                    COLUMN_EMPLOYEES_REQUESTED_ROLE + ", " +
                    COLUMN_EMPLOYEES_REQUESTED_SALARY + ", " +
                    COLUMN_EMPLOYEES_SALDO + ") " +
                    "VALUES('" + name + "', '" + password + "', " + isAdmin + ", '" + role + "', " + salary +
                    ", '" + role + "', " + salary + ", 0)"
            );
        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public void createSomeEmployees() throws Exception {
        for (int i = 0; i < users.length; i++) {
            createEmployee(users[i], passwords[i], isAdmin[i], roles[i], salary[i]);
        }
    }

    private List<Employee> readAllEmployeeInfo() {

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(QUERY_FOR_USERS_AND_PASSWORDS)) {

            List<Employee> employees = new ArrayList<>();
            while (results.next()) {
                Employee employee = new Employee();
                employee.setName(results.getString(INDEX_EMPLOYEES_NAME));
                employee.setPassword(results.getString(INDEX_EMPLOYEES_PASSWORD));
                employee.setAdmin(results.getBoolean(INDEX_EMPLOYEES_ISADMIN));
                employee.setRole(results.getString(INDEX_EMPLOYEES_ROLE));
                employee.setSalary(results.getDouble(INDEX_EMPLOYEES_SALARY));
                employee.setRequestedRole(results.getString(INDEX_EMPLOYEES_REQUESTED_ROLE));
                employee.setRequestedSalary(results.getDouble(INDEX_EMPLOYEES_REQUESTED_SALARY));
                employee.setSaldo(results.getDouble(INDEX_EMPLOYEES_SALDO));

                employees.add(employee);
            }

            return employees;
        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
            return null;
        }
    }

    public List<Employee> getUsernamePassword() {

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(QUERY_FOR_USERS_AND_PASSWORDS)) {

            List<Employee> employees = new ArrayList<>();
            while (results.next()) {
                Employee employee = new Employee();
                employee.setName(results.getString(INDEX_EMPLOYEES_NAME));
                employee.setPassword(results.getString(INDEX_EMPLOYEES_PASSWORD));
                employees.add(employee);
            }

            return employees;
        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
            return null;
        }
    }

    public List<Employee> getRequestedChanges() {

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(QUERY_FOR_USERS_AND_PASSWORDS)) {

            List<Employee> employees = new ArrayList<>();
            while (results.next()) {
                Employee employee = new Employee();
                employee.setName(results.getString(INDEX_EMPLOYEES_NAME));
                employee.setRole(results.getString(INDEX_EMPLOYEES_ROLE));
                employee.setRequestedRole(results.getString(INDEX_EMPLOYEES_REQUESTED_ROLE));
                employee.setSalary(results.getDouble(INDEX_EMPLOYEES_SALARY));
                employee.setRequestedSalary(results.getDouble(INDEX_EMPLOYEES_REQUESTED_SALARY));
                employees.add(employee);
            }

            return employees;
        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
            return null;
        }
    }

//    public static void updateRoleEmployee() {
//        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//             Statement statement = conn.createStatement()) {
//            statement.execute();
//        } catch (SQLException e) {
//            System.out.println("Something went wrong " + e.getMessage());
//        }
//    }

//    public static void updateSalaryEmployee() {
//        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//             Statement statement = conn.createStatement()) {
//            statement.execute();
//        } catch (SQLException e) {
//            System.out.println("Something went wrong " + e.getMessage());
//        }
//    }


    ///////////////////////
    //  Login functions  //
    ///////////////////////
    public boolean loginValidation(String name, String password) {

        List<Employee> employees = getUsernamePassword();
        if (employees == null) {
            System.out.println("No employees!");
            return false;
        }

        for (Employee employee : employees) {
            if (name.equals(employee.getName()) && password.equals(employee.getPassword())) {
                return true;
            }
        }
        return false;
    }


    public boolean loginValidationIsAdmin(String name) {

        List<Employee> employees = readAllEmployeeInfo();
        if (employees == null) {
            System.out.println("No employees!");
            return false;
        }

        for (Employee employee : employees) {
            if (name.equals(employee.getName()) && employee.isAdmin()) {
                return true;
            }
        }
        return false;
    }


    ////////////////////////
    //  Common functions  //
    ////////////////////////
    public double getSaldoForUser() {

        List<Employee> employees = readAllEmployeeInfo();
        if (employees == null) {
            System.out.println("No employees!");
            return -1;
        }

        for (Employee employee : employees) {
            if (Main.loggedInUserName.equals(employee.getName())) {
                return employee.getSaldo();
            }
        }
        return -1;
    }

    public double getSalaryForUser() {

        List<Employee> employees = readAllEmployeeInfo();
        if (employees == null) {
            System.out.println("No employees!");
            return -1;
        }

        for (Employee employee : employees) {
            if (Main.loggedInUserName.equals(employee.getName())) {
                return employee.getSalary();
            }
        }
        return -1;
    }

    public String getRoleForUser() {

        List<Employee> employees = readAllEmployeeInfo();
        if (employees == null) {
            System.out.println("No employees!");
            return "No employees!";
        }

        for (Employee employee : employees) {
            if (Main.loggedInUserName.equals(employee.getName())) {
                return employee.getRole();
            }
        }
        return "No employees!";
    }

    public void deleteEmployee(String name, String password) {

        List<Employee> employees = getUsernamePassword();
        if (employees == null) {
            System.out.println("No employees!");
            return;
        }

        if (name.equals("admin1")) {
            System.out.println("Not allowed!");
            return;
        }

        boolean userMatched = false;
        for (Employee employee : employees) {
            if (name.equals(employee.getName()) && password.equals(employee.getPassword())) {

                // Verification success
                try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
                     Statement statement = conn.createStatement()) {
                    statement.execute("DELETE FROM " + TABLE_EMPLOYEES + " WHERE " + COLUMN_EMPLOYEES_NAME + "='" + name + "'");
                    userMatched = true;
                } catch (SQLException e) {
                    System.out.println("Something went wrong " + e.getMessage());
                }
            }
        }

        if (userMatched) {
            System.out.println("User: " + name + " erased!");

            // Admin will not be logged out but user who self erase will
            if (!Main.loggedInAsAdmin) {
                Main.isLoggedIn = false;
            }
        } else {
            System.out.println("Credentials didn't match");
        }
    }


    ///////////////////////////////
    //  Standard User functions  //
    ///////////////////////////////

    public void requestChangeRoll(String newRole) {
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = conn.createStatement()) {
            statement.execute("UPDATE " + TABLE_EMPLOYEES + " SET " +
                    COLUMN_EMPLOYEES_REQUESTED_ROLE + " = '" + newRole +
                    "' WHERE " + COLUMN_EMPLOYEES_NAME + "='" + Main.loggedInUserName + "'");
        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public void requestChangeSalary(double newSalary) {
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = conn.createStatement()) {
            statement.execute("UPDATE " + TABLE_EMPLOYEES + " SET " +
                    COLUMN_EMPLOYEES_REQUESTED_SALARY + " = '" + newSalary +
                    "' WHERE " + COLUMN_EMPLOYEES_NAME + "='" + Main.loggedInUserName + "'");
        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }


    ////////////////////////////
    //  Admin User functions  //
    ////////////////////////////

    public int countRequestedChanges() {
        int counter = 0;

        List<Employee> employees = readAllEmployeeInfo();
        if (employees == null) {
            System.out.println("No employees!");
            return 0;
        }

        for (Employee employee : employees) {
            if (employee.getSalary() != employee.getRequestedSalary()) {
                counter++;
            }
            if (!employee.getRole().equals(employee.getRequestedRole())) {
                counter++;
            }
        }
        return counter;
    }

    public void monthlyRun() {
        List<Employee> employees = readAllEmployeeInfo();
        if (employees == null) {
            System.out.println("No employees!");
            return;
        }

        for (Employee employee : employees) {
            double newSaldo = employee.getSaldo() + employee.getSalary();

            try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
                 Statement statement = conn.createStatement()) {
                statement.execute("UPDATE " + TABLE_EMPLOYEES + " SET " +
                        COLUMN_EMPLOYEES_SALDO + " = '" + newSaldo +
                        "' WHERE " + COLUMN_EMPLOYEES_NAME + "='" + employee.getName() + "'");
            } catch (SQLException e) {
                System.out.println("Something went wrong " + e.getMessage());
            }
        }
    }

    public boolean userIsUnique(String newUser) {
        List<Employee> employees = readAllEmployeeInfo();
        if (employees == null) {
            System.out.println("No employees!");
            return false;
        }

        for (Employee employee : employees) {
            if (newUser.equals(employee.getName())) {
                return false;
            }
        }
        return true;
    }

    public void confirmAll() {
        List<Employee> employees = readAllEmployeeInfo();
        if (employees == null) {
            System.out.println("No employees!");
            return;
        }

        for (Employee employee : employees) {

            try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
                 Statement statement = conn.createStatement()) {

                statement.execute("UPDATE " + TABLE_EMPLOYEES + " SET " +
                        COLUMN_EMPLOYEES_SALARY + " = '" + employee.getRequestedSalary() +
                        "' WHERE " + COLUMN_EMPLOYEES_NAME + "='" + employee.getName() + "'");

                statement.execute("UPDATE " + TABLE_EMPLOYEES + " SET " +
                        COLUMN_EMPLOYEES_ROLE + " = '" + employee.getRequestedRole() +
                        "' WHERE " + COLUMN_EMPLOYEES_NAME + "='" + employee.getName() + "'");
            } catch (SQLException e) {
                System.out.println("Something went wrong " + e.getMessage());
            }
        }
    }

    public void declineAll() {
        List<Employee> employees = readAllEmployeeInfo();
        if (employees == null) {
            System.out.println("No employees!");
            return;
        }

        for (Employee employee : employees) {

            try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
                 Statement statement = conn.createStatement()) {

                statement.execute("UPDATE " + TABLE_EMPLOYEES + " SET " +
                        COLUMN_EMPLOYEES_REQUESTED_SALARY + " = '" + employee.getSalary() +
                        "' WHERE " + COLUMN_EMPLOYEES_NAME + "='" + employee.getName() + "'");

                statement.execute("UPDATE " + TABLE_EMPLOYEES + " SET " +
                        COLUMN_EMPLOYEES_REQUESTED_ROLE + " = '" + employee.getRole() +
                        "' WHERE " + COLUMN_EMPLOYEES_NAME + "='" + employee.getName() + "'");
            } catch (SQLException e) {
                System.out.println("Something went wrong " + e.getMessage());
            }
        }
    }

}


















