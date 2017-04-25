package longbottom.projects;

import longbottom.DAO.DAO;
import longbottom.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
// * Created by Japji on 4/11/2017.
// */
public class professorRequestsController {


    public static Route serveProfessorRequest = (Request request, Response response) -> {

        if(Integer.parseInt(request.queryParams("status")) == 0)
        {

            DAO.deleteProject(Integer.parseInt(request.queryParams("projectId")));


            DAO.sendEmail(Integer.parseInt(request.queryParams("adminId")),
                          Integer.parseInt(request.queryParams("profId")),
                          "Request Denied",
                          request.queryParams("profName") + ",\nAdministration has denied your " +
                                  " request to create the following project: " + request.queryParams("projectName"));

            return "Message sent";


        }
        else if(Integer.parseInt(request.queryParams("status")) == 1)
        {
            //DAO.createProject(request.queryParams("projectName"), request.queryParams("description"), Integer.parseInt("managerId"));
            int pid = Integer.parseInt(request.queryParams("projectId"));
            int profId = Integer.parseInt(request.queryParams("profId"));
            DAO.confirmProject(pid);
            //int wid = DAO.getWorksInId(pid, profId); // add the professor the project they are now managing
            DAO.acceptUser(pid, profId);
            DAO.sendEmail(Integer.parseInt(request.queryParams("adminId")),
                          Integer.parseInt(request.queryParams("profId")),
                          "Request Accepted",
                           request.queryParams("profName") + ",\nAdministration has accepted your " +
                           "request to create the following project: " + request.queryParams("projectName"));

            return "Message sent";
        }
        else
        {
            return "Error";
        }


    };

    public static Route getAdminRequests = (Request request, Response response) -> {
        int userId = Integer.parseInt(request.queryParams("userId"));

        List<Map<String,Object>> requests = DAO.listProjectsForAdmin();
        //System.out.println(requests.get(0).keySet());
        Map<String,Object> model = new HashMap<>();
        model.put("requests", requests);
      return ViewUtil.render(model, "/velocity/admin_requests.vm");
    };
}
