package longbottom.accounts;

import java.util.ArrayList;

/**
 * Created by Maxwell on 4/7/2017.
 */
public class ProjectUsers extends Project {

    private ArrayList<User> users;

    public ProjectUsers(String name, String description, long timeCreated, int projectId, int manager, ArrayList<User> users) {
        super(name, description, timeCreated, projectId, manager);
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
