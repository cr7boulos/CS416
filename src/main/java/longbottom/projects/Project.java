package longbottom.projects;

import java.util.ArrayList;

/**
 * Created by Maxwell on 4/7/2017.
 */
public class Project {

    private String name;
    private String description;
    private long timeCreated;
    private int projectId;
    private int manager;

    public Project(String name, String description, long timeCreated, int projectId, int manager) {
        this.name = name;
        this.description = description;
        this.timeCreated = timeCreated;
        this.projectId = projectId;
        this.manager = manager;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
