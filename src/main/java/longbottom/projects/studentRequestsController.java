package longbottom.projects;

import longbottom.DAO.DAO;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by Japji on 4/11/2017.
 */
public class studentRequestsController {

    public Route serveStudentRequest = (Request request, Response response) -> {

    /*  if(Integer.parseInt(request.queryParams("status")) == 0)
        {

            DAO.leaveProject(Integer.parseInt(request.queryParams("studentId")),
                         Integer.parseInt(request.queryParams("projectId")));

            DAO.sendEmail(Integer.parseInt(request.queryParams("profId")),
                          Integer.parseInt(request.queryParams("studentId")),
                          "Request Denied",
                          request.queryParams("studentName") + ",\n" +
                          request.queryParams("profName") + "has denied your request to join
                          the following project: " + requestParams("projectName"));

             return "Message Sent";


        }
        else if(Integer.parseInt(request.queryParams("status")) == 1)
        {
            DAO.requestJoin(Integer.parseInt(request.queryParams("studentId")),
                           Integer.parseInt(request.queryParams("projectId")));

            DAO.sendEmail(Integer.parseInt(request.queryParams("profId")),
                          Integer.parseInt(request.queryParams("studentId")),
                          "Request Accepted",
                          request.queryParams("studentName") + ",\n" +
                          request.queryParams("profName") + "has accepted your request to join
                          the following project: " + requestParams("projectName"));

            return "Message Sent";
        }
        else
        {
            return "Error";
        }

      */
    return "temp"};
}
