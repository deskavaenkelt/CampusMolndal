package se.dsve;

public class StandardUser extends Admins {

    private String role;
    private double salary;
    private String requestedRole;
    private double requestedSalary;

    public StandardUser(String name, String password, String role, double salary) {
        super(name, password, false);
        this.role = role;
        this.salary = salary;
        this.requestedRole = "";
        this.requestedSalary = 0;
    }

    public StandardUser(String name, String password) {
        super(name, password, true);
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public String getRequestedRole() {
        return requestedRole;
    }

    public double getRequestedSalary() {
        return requestedSalary;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setRequestedRole(String requestedRole) {
        this.requestedRole = requestedRole;
    }

    public void setRequestedSalary(double requestedSalary) {
        this.requestedSalary = requestedSalary;
    }
}
