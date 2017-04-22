package longbottom.accounts;

import longbottom.DAO.*;

public class Admin extends User {
    public Admin(int userId, String firstName, String lastName, String email, String password) {
        super(userId, firstName, lastName, email, password);
    }

    public boolean deleteUser(int userId){
        return DAO.deleteUser(userId);
    }
}
