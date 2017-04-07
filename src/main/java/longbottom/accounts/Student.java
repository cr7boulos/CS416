package longbottom.accounts;

public class Student extends User {

    private String major;

    public Student(int userId, String firstName, String lastName, String email, String password, String major) {
        super(userId, firstName, lastName, email, password);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
