package se.dsve.model;

public class Users {

    private static int idCounter = 0;
    private int id;
    private String name;
    private String password;

    public Users(String name, String password) {
        this.id = idCounter;
        this.name = name;
        this.password = password;

        idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
