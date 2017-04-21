package longbottom.projects;

import longbottom.DAO.DAO;
import longbottom.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.*;

/**
// * Created by Japji on 4/11/2017.
// */
public class studentRequestsController {


    public static Route serveStudentRequest = (Request request, Response response) -> {

      if(Integer.parseInt(request.queryParams("status")) == 0)
        {

            DAO.leaveProject(Integer.parseInt(request.queryParams("studentId")),
                         Integer.parseInt(request.queryParams("projectId")));

            DAO.sendEmail(Integer.parseInt(request.queryParams("profId")),
                          Integer.parseInt(request.queryParams("studentId")),
                          "Request Denied",
                          request.queryParams("studentName") + ",\n" +
                          request.queryParams("profName") + "has denied your request to join" +
                          "the following project: " + request.queryParams("projectName"));

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
                          request.queryParams("profName") + "has accepted your request to join" +
                          "the following project: " + request.queryParams("projectName"));

            return "Message Sent";
        }
        else
        {
            return "Error";
        }
    };

    public static Route getUserProjectRequests = (Request request, Response response) -> {
        int userId = Integer.parseInt(request.queryParams("userId"));

        //Security check
//        if(DAO.getIdentity(userId) != DAO.PROFESSOR){
//            return "Access Denied";
//            System.out.println("Non-professor")
//        }

        List<Map<String,Object>> joinRequests = DAO.listJoinRequests(userId);
        Map<String, Object> model = new HashMap<>();
        model.put("requests", joinRequests);
        return ViewUtil.render(model, "/velocity/project_join_partial.vm");
    };
}
