package longbottom.projects;

import longbottom.DAO.DAO;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by Japji on 4/11/2017.
 */
public class studentRequestsController {

    public Route serveStudent = (Request request, Response response) -> {

    /*    if(Integer.parseInt(request.queryParams("status")) == 0)
        {

            DAO.denyUser(Integer.parseInt(request.queryParams("studentId")),
                         Integer.parseInt(request.queryParams("projectId")));

            DAO.sendEmail(request.queryParams("profId"),
                          request.queryParams("studentId"),
                          request.queryParams("subject"),
                          request.queryParams("body"));


        }
        else
        {
            DAO.acceptUser(Integer.parseInt(request.queryParams("studentId")),
                           Integer.parseInt(request.queryParams("projectId")));

            DAO.sendEmail(request.queryParams("profId"),
                          request.queryParams("studentId"),
                          request.queryParams("subject"),
                          request.queryParams("body"));
        }

      */  return "Message Sent";
    };
}
