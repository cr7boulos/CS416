package longbottom.projects;

import longbottom.DAO.DAO;
import longbottom.login.LoginController;
import spark.Response;
import spark.Request;
import spark.Route;

public class ProjectController {

    public static Route newProject = (Request request, Response response) -> {
        LoginController.isAuthenticated(request, response);

        String name = request.queryParams("name");
        String description = request.queryParams("description");
        int manager = Integer.parseInt(request.queryParams("manager"));

        if (DAO.createProject(name, description, manager)) {
            return "Update Successful";
        } else {
            return "Update Failed";
        }
    };


    public static Route updateProject = (Request request, Response response) -> {
        LoginController.isAuthenticated(request, response);

        int projectId = Integer.parseInt(request.queryParams("projectId"));
        String name = request.queryParams("name");
        String description = request.queryParams("description");
        String timeStarted = request.queryParams("time");
        int manager;

        if (request.queryParams("manager") != null) {
            manager = Integer.parseInt(request.queryParams("manager"));
            DAO.updateProjectManager(projectId, manager);
        }

        if (name != null) {
            DAO.updateProjectName(projectId, name);
        }

        if (description != null) {
            DAO.updateProjectDescription(projectId, description);
        }

        if (timeStarted != null) {
            DAO.updateProjectTime(projectId, timeStarted);
        }

        return "Update complete";
    };
}
