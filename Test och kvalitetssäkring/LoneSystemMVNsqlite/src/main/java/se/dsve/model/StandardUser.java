package se.dsve.model;

public class StandardUser extends Admins {

    private String role;
    private double salary;
    private String requestedRole;
    private double requestedSalary;
    private double saldo;

    public StandardUser(String name, String password, String role, double salary) {
        super(name, password, false);
        this.role = role;
        this.salary = salary;
        this.requestedRole = role;
        this.requestedSalary = salary;
        this.saldo = 0;
    }

    public StandardUser(String name, String password) {
        super(name, password, true);
        this.role = "Administrator";
        this.salary = 100_000d;
        this.requestedRole = "Administrator";
        this.requestedSalary = 100_000d;
        this.saldo = 0;
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

    public double getSaldo() {
        return saldo;
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

    public void updateSaldo(double addToSaldo) {
        this.saldo += addToSaldo;
    }
}
