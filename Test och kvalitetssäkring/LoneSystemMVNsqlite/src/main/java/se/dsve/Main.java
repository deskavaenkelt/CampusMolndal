package se.dsve;

import se.dsve.controller.Controller;
import se.dsve.controller.Menu;
import se.dsve.model.DataSource;

public class Main {
    public static String loggedInUserName = "";
    public static int loggedInUserId = -1;
    public static boolean loggedInAsAdmin = false;
    public static boolean isLoggedIn = false;
    public static boolean keepAppAlive = true;

    private static Controller controller;

    public static void main(String[] args) throws Exception {
//        DataSource dataSource = new DataSource();
//        controller = new Controller();

//        dataSource.open();
//        dataSource.connectToDb();

//        dataSource.createSomeEmployees();

//        dataSource.deleteEmployee("Fido05");

//        List<Employee> employees = dataSource.readAllEmployeeInfo();
//        if (employees == null) {
//            System.out.println("No employees!");
//            return;
//        }
//
//        for (Employee employee : employees) {
//            System.out.println("User name = " + employee.getName() + ", Password = " + employee.getPassword());
//        }

//        int id = 0;
//        dataSource.deleteEmployee(dataSource.users[id], dataSource.passwords[id]);

        Menu.login();

//        dataSource.close();
    }
}