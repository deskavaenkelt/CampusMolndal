package se.dsve;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {
    private static List<StandardUser> users = new ArrayList<>();

    // Get users
    static List<StandardUser> getUsers() {
        return users;
    }

    // New Standard User
    static void newUser(String name, String password, String roll, double salary) {
        users.add(new StandardUser(name, password, roll, salary));
    }

    // New Admin User
    static void newAdmin(String name, String password) {
        users.add(new StandardUser(name, password));
    }

    // Delete users
    static void deleteUser(String name, String password) {

        boolean foundUser = false;

        if (name.equals("admin1")) {
            System.out.println("Invalid user deletion request");
        } else {
            for (int id = 0; id < getUsers().size(); id++) {
                if ((name.equals(users.get(id).getName())) && (password.equals(users.get(id).getPassword()))) {
                    foundUser = true;
                    System.out.println("Erase user with id = " + id);
                    System.out.println("User " + users.get(id).getName() + " has been deleted!");
                    users.remove(id);
                    break;
                }
            }
        }

        if (!foundUser) {
            System.out.println("Wrong username and/or password!");
        }
    }

    static void requestNewUserRole(int id, String requestedRole) {
        users.get(id).setRequestedRole(requestedRole);
    }

    static void requestNewUserSalary(int id, double requestedSalary) {
        users.get(id).setRequestedSalary(requestedSalary);
    }
}
