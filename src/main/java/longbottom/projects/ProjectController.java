package longbottom.projects;

import longbottom.DAO.DAO;
import longbottom.login.LoginController;
import spark.Response;
import longbottom.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.HashMap;
import java.util.Map;

public class ProjectController {

    /*public static Route newProjects = (Request request, Response response) -> {
        LoginController.isAuthenticated(request, response);
        if (DAO.createProject(
                request.queryParams("name"),
                request.queryParams("description"),
                request.queryParams("time"),
                Integer.parseInt( request.queryParams("manager"))) == false)
        return "Update Unsuccessful";
        else
        return "Update Successful";
    };*/

    /*/
    public static Route updateProjects = (Request request, Response response) -> {
        LoginController.isAuthenticated(request, response);
        if (DAO.updateProject(
                (Integer.parseInt(request.queryParams("projectId"))),
                request.queryParams("name"),
                request.queryParams("description"),
                request.queryParams("time"),
                Integer.parseInt( request.queryParams("manager"))) == false)
            return "Update Unsuccessful";
        else
            return "Update Successful";
    };
    /*/
}
