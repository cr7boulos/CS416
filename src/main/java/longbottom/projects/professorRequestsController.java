package longbottom.projects;

import longbottom.DAO.DAO;
import spark.Request;
import spark.Response;
import spark.Route;

/**
// * Created by Japji on 4/11/2017.
// */
public class professorRequestsController {

   /*
    public Route serveProfessorRequest = (Request request, Response response) -> {

        if(Integer.parseInt(request.queryParams("status")) == 0)
        {

            DAO.deleteProject(Integer.parseInt(request.queryParams("projectId")));


            DAO.sendEmail(Integer.parseInt(request.queryParams("adminId")),
                          Integer.parseInt(request.queryParams("profId")),
                          "Request Denied",
                          request.queryParams("profId") + ",\nAdministration has denied your " +
                                  " request to create the following project: " + request.queryParams("projectName"));

            return "Message sent";


        }
        else if(Integer.parseInt(request.queryParams("status")) == 1)
        {
            DAO.createProject(request.queryParams("projectName"), request.queryParams("description"), Integer.parseInt("managerId"));

            DAO.sendEmail(Integer.parseInt(request.queryParams("adminId"),
                          Integer.parseInt(request.queryParams("profId")),
                          "Request Accepted",
                           request.queryParams("profId") + ",\nAdministration has accepted your " +
                           " request to create the following project: " + request.queryParams("projectName")));

            return "Message sent";
        }
        else
        {
            return "Error";
        }

    return "temp"}; */
}
