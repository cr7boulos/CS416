package longbottom.accounts;

/**
 * Created by Maxwell on 4/7/2017.
 */
public class works_in {

    private int projectId;
    private int userId;

    public works_in(int projectId, int userId) {
        this.projectId = projectId;
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
