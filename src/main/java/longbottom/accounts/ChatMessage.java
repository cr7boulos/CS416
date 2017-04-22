package longbottom.accounts;

/**
 * Created by Maxwell on 4/7/2017.
 */
public class ChatMessage {

    private int id;
    private int projectId;
    private int userId;
    private String text;
    private String time;

    public ChatMessage(int id, int projectId, int userId, String text, String time) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.text = text;
        this.time = time;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
