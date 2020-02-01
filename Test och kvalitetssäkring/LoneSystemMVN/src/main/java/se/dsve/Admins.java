package se.dsve;

public class Admins extends Users {

    private boolean isAdmin;

    public Admins(String name, String password, boolean isAdmin) {
        super(name, password);
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
