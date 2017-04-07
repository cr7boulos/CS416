package longbottom.accounts;

public class Professor extends User{

    private double salary;
    private long dateHired;

    public Professor(int userId, String firstName, String lastName, String email, String password) {
        super(userId, firstName, lastName, email, password);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getDateHired() {
        return dateHired;
    }

    public void setDateHired(long dateHired) {
        this.dateHired = dateHired;
    }

}
